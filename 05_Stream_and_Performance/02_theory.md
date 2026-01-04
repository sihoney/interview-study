# 02. Stream & Performance — Core Theory

---

## 🌊 Java Stream API란?

Stream API는 Collection 타입의 데이터를  
**내부 반복** 방식으로 처리해 정렬, 필터링, 매핑, 집계 등을 지원하는 API입니다.

---

## ✅ Stream의 특징

### 1) 데이터를 변경하지 않는다 (Immutable)
Stream은 원본 데이터를 변경하지 않고 읽기만 한다.

### 2) 내부 반복(Internal Iteration)
반복을 개발자가 직접 제어하지 않고  
Stream이 반복을 수행한다.

### 3) 일회용
최종 연산이 끝나면 Stream은 닫혀 재사용할 수 없다.

---

## 🔗 Stream 처리 흐름

```

Stream 생성 → 중간 연산 → 최종 연산

```

### 중간 연산 (가공)
- filter
- map
- sorted
- limit
- peek 등

### 최종 연산 (결과)
- collect
- forEach
- count
- reduce
- anyMatch / allMatch
- min / max 등

---

## 💤 Lazy Evaluation (지연 실행)

중간 연산은 바로 실행되지 않고  
최종 연산이 호출되는 순간에 한 번에 수행된다.

즉, 필요할 때만 계산해서 성능 효율이 좋아진다.

---

## ⚡ 병렬 스트림 (Parallel Stream)

parallelStream은 ForkJoinPool 기반으로 동작하며  
작업을 분할하고 병렬로 처리한다.

### 병렬 처리 특징
- 각 스레드가 개별 큐를 가진다
- 유휴 스레드가 다른 스레드의 작업을 가져와 수행한다 (work stealing)

---

## 🧠 ForkJoinPool과의 관계

병렬 스트림은 내부적으로 ForkJoinPool을 사용한다.

ForkJoinPool은 작업(Task)을
- Fork: 분할해서 배분하고
- Join: 결과를 합치는 구조다.

---

> Stream은 "코드 간결화"만이 아니라  
> **대용량 데이터 처리의 설계 도구**다.
