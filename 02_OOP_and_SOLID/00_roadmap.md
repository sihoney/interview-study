# 📁 `02_OOP_and_SOLID` — 과정 계획

> 목표
> **"왜 객체지향이 필요한지, 그리고 어떻게 설계해야 유지보수 가능한지 설명할 수 있는 수준"**

---

## 🧩 전체 구조

```
문제 → 이론 → 설계 → 구현 → 분석 → 면접
```

---

## 🧨 Step 1 — Problem

### `02_OOP_and_SOLID/01_problem.md`

**시나리오**

> 기능 하나 추가할 때마다 기존 코드가 계속 깨진다.
> 클래스 하나가 수천 줄이 된다.
> 테스트가 불가능하다.

**질문**

* 왜 이런 구조가 되었는가?
* 객체지향은 이 문제를 어떻게 해결하는가?

---

## 📚 Step 2 — Theory

### `02_OOP_and_SOLID/02_theory.md`

포함 항목 

* 객체지향 프로그래밍 개념
* OOP 특징: 캡슐화, 상속, 다형성, 추상화
* SOLID 5대 원칙
* 오버로딩 / 오버라이딩
* 접근 제한자
* 추상 클래스
* 인터페이스
* Error vs Exception
* try-catch-finally
* try-with-resources

---

## 🧱 Step 3 — Design

### `02_OOP_and_SOLID/03_design.md`

* 절차형 → 객체지향 구조 변환 설계
* SOLID 위반 구조 시각화
* 의존성 역전 구조
* 인터페이스 기반 설계

---

## 🛠 Step 4 — Implementation

### `02_OOP_and_SOLID/04_implementation/`

| 파일                    | 실습                 |
| --------------------- | ------------------ |
| BadDesign.java        | 절차형 지옥             |
| GoodDesign.java       | 객체지향 구조            |
| SolidViolation.java   | SOLID 위반           |
| SolidRefactor.java    | SOLID 개선           |
| InterfaceExample.java | 인터페이스              |
| AbstractExample.java  | 추상클래스              |
| OverrideOverload.java | 오버라이딩/오버로딩         |
| ExceptionDesign.java  | 예외 설계              |
| ResourceExample.java  | try-with-resources |

---

## 🔬 Step 5 — Analysis

### `02_OOP_and_SOLID/05_analysis.md`

* 유지보수성 비교
* SOLID 개선 효과
* 테스트 용이성 변화

---

## 🎤 Step 6 — Interview

### `02_OOP_and_SOLID/06_interview.md`

* OOP 철학 설명
* SOLID 적용 사례
* 인터페이스/추상클래스 선택 기준
* 예외 설계 답변
