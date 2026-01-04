# 05. Concurrency — Experiment Analysis

---

## 🧪 RaceCondition

### 결과
```
Expected stock = -60000
Actual stock   = 51289
```

### 관찰
- 예상 값과 실제 값 불일치
- 실행할 때마다 결과 달라짐

### 해석
- 임계 구역 미보호 → 데이터 손상

---

## 🧪 synchronized

### 결과
```
Expected stock = -60000
Actual stock   = -60000
```

### 관찰
- 항상 정확한 결과
- 성능 감소

### 해석
- 강한 안전성
- 비용 큼

---

## 🧪 volatile

### 결과
```
Expected count = 1600000
Actual count   = 609598
volatile은 가시성은 보장하지만 ++ 같은 동시 수정은 못 막는다.
```

### 관찰
- 값 불일치 지속

### 해석
- 가시성만 보장
- 동시 수정은 해결 불가

---

## 🧪 Atomic

### 결과
```
Expected count = 1600000
Actual count   = 1600000
```

### 관찰
- 항상 정확한 결과
- synchronized보다 빠름

### 해석
- CAS 기반 동기화
- 낮은 비용

---

## 🧪 ThreadPool

### 결과
```
Task 2 done by pool-1-thread-2
Task 3 done by pool-1-thread-3
Task 4 done by pool-1-thread-4
Task 1 done by pool-1-thread-1
Task 6 done by pool-1-thread-4
Task 8 done by pool-1-thread-2
Task 5 done by pool-1-thread-3
Task 7 done by pool-1-thread-1
Task 9 done by pool-1-thread-4
Task 10 done by pool-1-thread-2
Sum = 550
```

### 관찰
- 스레드 관리 안정
- 성능 향상

---

## 🧪 ForkJoin

### 결과
```
Sum = 2000000
```

### 관찰
- 대용량 데이터 빠른 처리

---

## 🧠 종합 결론

| 기법 | 특징 |
|--|--|
synchronized | 안전, 느림 |
volatile | 가시성만 |
Atomic | 빠르고 안전 |
ThreadPool | 운영 필수 |
ForkJoin | 병렬 최적화 |

---

> 동시성 설계는 **시스템 안정성의 핵심**이다.
