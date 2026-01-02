# Runtime Data Area

JVM이 프로그램 실행을 위해 사용하는 메모리 구조이다.

---

## 1. Overall Structure

Runtime Data Area는 크게 다음 영역으로 구성된다.

- **Method Area (Static Area)**
- **Heap**
- **JVM Stack**
- **PC Register**
- **Native Method Stack**

---

## 2. Method Area

클래스 정보가 저장되는 영역.

저장 내용:
- Class metadata
- Method 정보
- Field 정보
- static 변수
- final 상수

특징:
- 모든 스레드 공유
- 클래스 로딩 시 생성

---

## 3. Heap

동적으로 생성된 객체 저장.

저장 대상:
- new 연산으로 생성된 객체
- 배열
- 인스턴스 변수

특징:
- 모든 스레드 공유
- GC 관리 대상

---

## 4. JVM Stack

스레드마다 하나씩 생성.

저장 내용:
- 지역 변수
- 매개변수
- 연산 중간 값
- Return Address

특징:
- 메서드 호출 시 Stack Frame 생성
- 메서드 종료 시 Frame 제거

---

## 5. PC Register

각 스레드가 현재 실행 중인 명령 주소 저장.

---

## 6. Native Method Stack

C/C++ 등 Native 코드 실행을 위한 스택.

---

## 7. Memory Interaction

| 영역 | 공유 여부 | GC 대상 |
|---|---|---|
Method | O | X |
Heap | O | O |
Stack | X | X |
PC | X | X |
Native | X | X |

---

## 8. Interview Key Line

> Runtime Data Area는 JVM이 프로그램을 실행하기 위해 사용하는 모든 메모리 구조이다.
