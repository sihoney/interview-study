# 03. Stream & Performance — System Design

---

## 🎯 설계 목표

> 데이터 처리 성능을  
> **코드 구조 단계에서 결정**한다.

---

## 🧩 데이터 처리 파이프라인 설계

### ❌ 비효율 구조

```

for (...) {
if (...) {
if (...) {
...
}
}
}

```

### ⭕ Stream 구조

```

data.stream()
.filter(...)
.map(...)
.sorted(...)
.collect(...)

```

---

## ⚡ 병렬 처리 설계 기준

| 상황 | 선택 |
|--|--|
작은 데이터 | 일반 Stream |
대용량 CPU 연산 | Parallel Stream |
I/O 작업 | ExecutorService |

---

## 🧮 병렬 스트림 주의점

- 상태 공유 금지
- 동기화 필요 시 성능 하락
- ForkJoinPool 공용 사용 주의

---

> Stream은 **성능 설계의 언어**다.
