# Performance Analysis (Stream / Parallel / String / GC 연계)

## 1) 목표
- Stream이 왜 “일회용”인지 설명한다.
- Lazy Evaluation을 정확히 말할 수 있어야 한다.
- parallelStream이 무조건 빠르지 않은 이유를 설명한다.
- 성능 문제를 GC/메모리/스레드 관점으로 같이 엮을 수 있어야 한다.

---

## 2) 실험 코드
- `04_implementation/stream/StreamVsLoop.java`
- `04_implementation/stream/ParallelStreamTest.java`
- `04_implementation/memory/GcTest.java` (성능과 GC 연계)

---

## 3) Stream 핵심 정리

### (1) 내부 반복
개발자가 for-loop로 반복 제어를 직접 하지 않고, Stream이 내부적으로 처리한다.

### (2) 불변(Immutable)
원본 데이터를 변경하지 않고 읽기만 한다.

### (3) Lazy Evaluation
중간 연산(filter/map 등)은 즉시 실행되지 않는다.  
최종 연산(sum/collect 등)이 호출될 때 실행된다.

### (4) 일회용
최종 연산 후 스트림은 닫힌다.

---

## 4) parallelStream이 항상 빠르지 않은 이유
- 병렬화 오버헤드(분할/스케줄링/합치기)가 존재
- 데이터 크기가 작으면 오히려 느려질 수 있음
- CPU 코어 수, 스레드 경쟁, 메모리 대역폭 영향
- ForkJoinPool(commonPool) 공유로 인해 다른 작업과 충돌 가능

---

## 5) String 성능
- String은 불변이라 결합이 많으면 객체 생성 폭증
- 반복 문자열 작업은 StringBuilder 사용이 일반적으로 유리

---

## 6) 성능 문제를 GC와 연결하는 관점
객체가 많이 생성되면:
- Young GC 증가
- 때로 Old 압박 증가
- Full GC 발생 가능
- STW 시간이 누적되면 “성능 저하”가 아니라 “장애”처럼 보임

---

## 7) 면접용 결론
Stream은 Lazy Evaluation과 내부 반복을 통해 코드 품질을 높이지만, 최종 연산 시점에 실행되는 일회용 구조다.  
parallelStream은 ForkJoinPool 기반 병렬 처리지만, 오버헤드와 리소스 경쟁 때문에 항상 빠르지 않다.  
성능 문제는 코드 레벨뿐 아니라 객체 생성 패턴과 GC 동작(STW)까지 함께 봐야 한다.
