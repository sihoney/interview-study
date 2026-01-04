# 📁 `05_Stream_and_Performance` — 과정 계획

> 목표
> **"데이터 처리 성능을 설계 관점에서 설명할 수 있는 수준"**

---

## 🧩 전체 구조

```
문제 → 이론 → 설계 → 구현 → 분석 → 면접
```

---

## 🧨 Step 1 — Problem

### `05_Stream_and_Performance/01_problem.md`

**시나리오**

> 대량 데이터 처리에서 성능 병목 발생
> 루프 기반 처리 느림
> CPU 사용률 비효율

**질문**

* 왜 Stream이 필요한가?
* 병렬 스트림은 언제 사용해야 하는가?
* ForkJoinPool과의 관계는?

---

## 📚 Step 2 — Theory

### `05_Stream_and_Performance/02_theory.md`

포함 항목

* Java Stream API
* Lazy Evaluation
* 중간 연산 / 최종 연산
* 병렬 스트림
* ForkJoinPool 연계

---

## 🧱 Step 3 — Design

### `05_Stream_and_Performance/03_design.md`

* 데이터 처리 파이프라인 설계
* 병렬 처리 전략
* 성능 설계 기준

---

## 🛠 Step 4 — Implementation

### `05_Stream_and_Performance/04_implementation/`

| 파일                      | 실습        |
| ----------------------- | --------- |
| StreamVsLoop.java       | 루프 vs 스트림 |
| ParallelStreamTest.java | 병렬 스트림    |

---

## 🔬 Step 5 — Analysis

### `05_Stream_and_Performance/05_analysis.md`

* 성능 비교
* 병렬 처리 효과

---

## 🎤 Step 6 — Interview

### `05_Stream_and_Performance/06_interview.md`

* Stream 설명
* 병렬 스트림 답변
* 성능 설계 전략
