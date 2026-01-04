# 📁 `04_Concurrency` — 과정 계획

> 목표
> **"동시성 문제를 원인부터 해결 전략까지 설명할 수 있는 수준"**

---

## 🧩 전체 구조

```
문제 → 이론 → 설계 → 구현 → 분석 → 면접
```

---

## 🧨 Step 1 — Problem

### `04_Concurrency/01_problem.md`

**시나리오**

> 동시에 주문 요청이 들어오면
> 재고가 마이너스가 된다.
> 간헐적으로 데이터가 깨진다.

**질문**

* 왜 이런 현상이 발생하는가?
* Java에서 스레드는 어떻게 동작하는가?
* 동기화는 왜 필요한가?

---

## 📚 Step 2 — Theory

### `04_Concurrency/02_theory.md`

포함 항목 

* Thread / Runnable / Callable
* Thread 실행 구조
* ExecutorService / ThreadPool
* Java MultiThread 프로그래밍
* 동기화 개념
* synchronized
* volatile
* Atomic
* CAS 알고리즘
* ForkJoinPool

---

## 🧱 Step 3 — Design

### `04_Concurrency/03_design.md`

* Race Condition 구조
* 임계 구역 설계
* Lock 설계 전략
* CAS 기반 구조

---

## 🛠 Step 4 — Implementation

### `04_Concurrency/04_implementation/`

| 파일                     | 실습           |
| ---------------------- | ------------ |
| RaceCondition.java     | 경쟁 상태        |
| SyncTest.java          | synchronized |
| VolatileTest.java      | volatile     |
| AtomicTest.java        | Atomic       |
| ThreadPoolExample.java | ThreadPool   |
| ForkJoinExample.java   | ForkJoin     |

---

## 🔬 Step 5 — Analysis

### `04_Concurrency/05_analysis.md`

* 동기화 성능 비교
* Race Condition 해결 과정

---

## 🎤 Step 6 — Interview

### `04_Concurrency/06_interview.md`

* 동시성 설명
* synchronized / volatile / Atomic 비교
* ThreadPool / ForkJoin 설명

---

지금 바로 **`04_Concurrency/01_problem.md`**부터 만들어줄게.
