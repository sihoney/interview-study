# Concurrency Issue Analysis

## 1) 목표
- 레이스 컨디션이 왜 발생하는지 설명한다.
- synchronized / volatile / Atomic의 차이를 명확히 정리한다.
- ThreadPool, ForkJoinPool의 목적을 말할 수 있어야 한다.

---

## 2) 실험 코드
- `04_implementation/concurrency/RaceCondition.java`
- `04_implementation/concurrency/SyncTest.java`
- `04_implementation/concurrency/AtomicTest.java`
- `04_implementation/concurrency/ThreadPoolExample.java`
- `04_implementation/concurrency/ForkJoinExample.java`

---

## 3) RaceCondition 왜 발생?
`value++`는 한 번의 연산처럼 보이지만 내부적으로는:
1) 읽기
2) +1
3) 쓰기
   3단계가 끊겨서 수행된다.

두 스레드가 동시에 실행하면 중간 값이 덮어씌워져 결과가 누락된다.

---

## 4) 해결 방법 비교

### (1) synchronized
- 한 번에 한 스레드만 접근하도록 잠금
- 가장 단순하고 강력
- 비용이 큼(락 경쟁, 컨텍스트 스위칭)

### (2) volatile
- 가시성(visibility)을 보장
- CPU Cache가 아니라 Main Memory에서 읽고 쓴다
- 단, 복합 연산(예: ++)의 원자성은 보장 못함
- 결론: **가시성 문제는 해결하지만, 동시 접근 문제는 해결 못한다**

### (3) Atomic (CAS)
- CAS(compare-and-swap) 기반
- 값 비교 후 동일하면 교체, 아니면 실패 후 재시도
- synchronized보다 적은 비용으로 동시성 확보 가능

---

## 5) Thread 생성 vs ThreadPool(ExecutorService)
Thread를 계속 생성/삭제하면 비용이 크다.  
운영에서는 보통 ExecutorService 기반 ThreadPool로 관리한다.

---

## 6) ForkJoinPool 개념
큰 작업을 작은 Task로 분할(Fork)하고 결과를 취합(Join)한다.  
각 워커는 자신의 큐를 가지고 있으며, 일이 없으면 남의 큐에서 훔쳐온다(work stealing).

---

## 7) 면접용 결론
RaceCondition은 복합 연산이 원자적으로 처리되지 않아 발생한다.  
synchronized는 강력하지만 비용이 크고, volatile은 가시성만 해결한다.  
Atomic은 CAS로 원자성을 비교적 저비용으로 확보한다.  
운영에서는 ThreadPool로 스레드를 관리하고, 병렬 분할 작업에는 ForkJoinPool을 활용할 수 있다.
