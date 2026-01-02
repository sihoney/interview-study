좋습니다. 이제 05_analysis 폴더를 “실행 결과를 해석 → 원인 규명 → 개선 포인트 → 면접 답변 소재”로 채웁니다.
아래 파일 4개 그대로 생성해서 넣으면 됩니다.

📂 sessions/01_core-java/05_analysis
📄 gc-analysis.md
# GC Analysis (Mark & Sweep 관점 포함)

## 1) 목표
- GC가 왜 자주/길게 발생하는지 설명 가능해야 한다.
- "메모리는 남아있는데 서버가 멈춘다"를 GC/Stop-The-World로 설명할 수 있어야 한다.

---

## 2) 실험 코드
- `04_implementation/memory/MemoryTest.java`
- `04_implementation/memory/GcTest.java`

권장 실행:
```bash
java -Xms256m -Xmx256m -Xlog:gc* MemoryTest
java -Xms256m -Xmx256m -Xlog:gc* GcTest

3) 관찰 포인트(로그에서 봐야 하는 것)

GC가 발생하는 빈도 (Young/Full 여부)

Pause 시간이 얼마나 되는지

Heap 사용량이 회수되는지(회수 실패 시 Full GC 증가)

"GC를 해도 힙이 안 줄어드는 패턴"이 있는지

4) 핵심 해석
(1) GC는 Heap 대상이다

Java에서 동적 할당(new)으로 생성되는 객체는 Heap에 쌓인다.
참조가 끊긴(Unreachable) 객체는 GC가 제거한다.

(2) Mark & Sweep 개념 매핑

Root Space(시작점): Stack, Method Area, Native Method Stack

Mark: 루트에서부터 참조되는 객체를 마킹

Sweep: 마킹되지 않은 객체 제거

즉, "참조가 남아있으면" GC가 못 지운다.

5) “메모리는 남아있는데 서버가 멈춘다”의 설명
원인 패턴

Full GC가 반복되면 GC는 실행 중인 애플리케이션을 멈추게 된다(STW).

이 시간이 길어지면 요청 처리가 밀리고 타임아웃/장애처럼 보인다.

사용자는 "서버 다운"으로 체감한다.

6) 개선 방향(설계/코드 관점)
(1) 객체 생명주기 단축

불필요한 객체 생성 제거

대량 객체 생성 루프 최소화

(2) 불변/풀 자원 적극 활용

String 리터럴/String Pool 활용

캐싱 전략 설계(남발 금지)

(3) static 주의

static에 큰 객체/컬렉션이 붙으면 참조가 끊기지 않아 GC가 못 지운다.

Method Area(메타데이터/정적 정보)와 참조 관계를 고려해야 한다.

7) 면접용 한 줄 결론

GC는 Heap의 Unreachable 객체를 정리하지만, 참조가 남아있으면 회수되지 않는다.
Full GC가 반복되면 STW 시간이 누적되어 "서버가 멈춘 것처럼" 보이는 장애로 이어진다.


---

## 📄 `memory-leak.md`

```md
# Memory Leak / Memory Pressure Analysis

## 1) 목표
- Java에서 "메모리 누수"가 C/C++과 다르게 나타나는 이유를 설명한다.
- String, static, 컬렉션이 누수 패턴을 만드는 구조를 이해한다.

---

## 2) 실험 코드
- `04_implementation/memory/StringPoolTest.java`
- `04_implementation/memory/MemoryTest.java`

---

## 3) Java에서의 누수 정의
Java는 GC가 있으므로 "할당한 메모리를 해제하지 않아서"라기보다,
**참조가 끊기지 않아 Unreachable이 되지 않는 상태가 지속되는 것**이 누수/압박으로 나타난다.

즉,
- Heap 객체가 계속 참조됨 → GC 대상이 아님 → 사용량 증가 → GC 빈번/Full GC 증가

---

## 4) String 관련 핵심

### (1) String은 불변(Immutable)
- 문자열 변경/결합이 많으면 객체가 계속 생성된다.
- `+` 연산은 새로운 String 객체를 만든다(반복이면 특히 치명적).

### (2) StringBuilder / StringBuffer 사용 이유
- 동일 객체 내부에서 append/delete 가능
- StringBuilder: 동기화 없음(단일 스레드 성능 좋음)
- StringBuffer: 동기화 있음(멀티 스레드 안전)

---

## 5) String Pool 관점

### "" 리터럴
- String Pool에 저장
- 동일 리터럴이면 같은 참조 공유

### new String("x")
- Heap에 별도 객체 생성
- 같은 내용이어도 참조가 다름

### intern()
- String Pool 등록/참조 반환 가능
- 남발하면 Pool 쪽 부담이 될 수 있으니 전략적으로 사용

---

## 6) static이 위험해지는 순간
- static 변수는 클래스당 1개, 프로그램 종료까지 살아있다.
- static 컬렉션에 계속 add하면 참조가 끊기지 않아 GC가 회수할 수 없다.

---

## 7) 면접용 결론
Java의 메모리 문제는 "해제 누락"보다  
**참조가 유지되어 GC가 회수 못 하는 구조(특히 static/컬렉션/String 생성 패턴)**에서 발생한다.