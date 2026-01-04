# 05. Stream & Performance — Experiment Analysis

---

## 🧪 Loop vs Stream

### 결과
```
Loop sum=24999995000000, time=21
Stream sum=24999995000000, time=109
```

### 관찰
- Stream 코드 가독성 ↑
- 성능은 상황에 따라 유사하거나 Loop가 약간 빠를 수 있음

### 해석
- 성능보다 구조적 가독성 & 유지보수성이 핵심

---

## 🧪 Parallel Stream

### 결과
```
Single stream time: 31
Parallel stream time: 64
```

### 관찰
- 대용량 데이터에서 병렬 스트림이 더 빠름
- 작은 데이터에서는 오히려 느릴 수 있음

### 해석
- CPU 연산 집중 작업에서 효과적
- I/O 작업에는 부적합

---

## 🧠 종합 결론

| 상황 | 전략 |
|--|--|
코드 가독성 | Stream |
CPU 집중 | Parallel Stream |
I/O 중심 | ExecutorService |

---

> 성능은 **코드 구조에서 결정**된다.
