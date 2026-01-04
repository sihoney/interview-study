# 06. Stream & Performance — Interview Answers

---

## ❓ Stream API가 무엇인가요?

Stream은 데이터를 내부 반복 방식으로 처리하는 API로  
필터링, 변환, 정렬, 집계를 간결하고 안전하게 수행합니다.

---

## ❓ Stream의 장점은?

- 불변성 유지
- 가독성 향상
- Lazy Evaluation으로 성능 최적화

---

## ❓ 병렬 스트림은 언제 사용하나요?

CPU 연산이 많은 대용량 데이터 처리에 적합합니다.  
작은 데이터나 I/O 중심 작업에는 부적합합니다.

---

## ❓ ForkJoinPool과의 관계는?

병렬 스트림은 내부적으로 ForkJoinPool을 사용해  
작업을 분할·병합합니다.

---

## 🧾 한 문장 요약

> "Stream은 성능 최적화를 위한 설계 도구다."
