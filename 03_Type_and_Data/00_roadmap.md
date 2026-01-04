# 📁 `03_Type_and_Data` — 과정 계획

> 목표
> **"타입 안정성과 데이터 설계로 시스템 신뢰도를 올리는 방법을 설명할 수 있는 수준"**

---

## 🧩 전체 구조

```
문제 → 이론 → 설계 → 구현 → 분석 → 면접
```

---

## 🧨 Step 1 — Problem

### `03_Type_and_Data/01_problem.md`

**시나리오**

> 서비스에서 갑자기 NPE가 터지고,
> equals 비교 때문에 버그가 발생하며,
> 캐스팅 오류로 장애가 난다.

**질문**

* 타입 시스템은 왜 중요한가?
* equals/hashCode를 잘못 구현하면 어떤 일이 벌어지는가?
* Generic과 Optional은 어떤 문제를 해결하는가?

---

## 📚 Step 2 — Theory

### `03_Type_and_Data/02_theory.md`

포함 항목 

* Primitive / Reference Type
* equals vs ==
* hashCode
* Wrapper Class
* Boxing / Unboxing
* Generic
* Optional
* Java 직렬화 / 역직렬화

---

## 🧱 Step 3 — Design

### `03_Type_and_Data/03_design.md`

* 타입 안정성 설계
* NPE 차단 설계
* equals/hashCode 계약 설계
* Generic 구조 설계

---

## 🛠 Step 4 — Implementation

### `03_Type_and_Data/04_implementation/`

| 파일                      | 실습              |
| ----------------------- | --------------- |
| EqualsHashCodeTest.java | equals/hashCode |
| GenericBox.java         | 제네릭             |
| OptionalExample.java    | Optional        |
| BoxingUnboxing.java     | 박싱              |
| SerializationTest.java  | 직렬화             |
| PrimitiveVsWrapper.java | 타입 차이           |

---

## 🔬 Step 5 — Analysis

### `03_Type_and_Data/05_analysis.md`

* 타입 안정성 효과 분석
* NPE 감소 분석
* Generic 설계 장점

---

## 🎤 Step 6 — Interview

### `03_Type_and_Data/06_interview.md`

* 타입 시스템 설명
* equals/hashCode 답변
* Optional, Generic 설명
