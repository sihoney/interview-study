# 📁 `06_Runtime_and_Reflection` — 과정 계획

> 목표
> **"컴파일 타임이 아닌 런타임에 시스템을 조작하는 메커니즘을 설명할 수 있는 수준"**

---

## 🧩 전체 구조

```
문제 → 이론 → 설계 → 구현 → 분석 → 면접
```

---

## 🧨 Step 1 — Problem

### `06_Runtime_and_Reflection/01_problem.md`

**시나리오**

> 클래스 이름도, 메서드 이름도 모른 채
> 런타임에 객체를 생성하고 주입해야 한다.
> (Spring 컨테이너 내부 동작과 동일한 문제)

**질문**

* 컴파일 시 모르는 클래스를 어떻게 사용하나?
* DI 컨테이너는 객체를 어떻게 생성하고 주입하나?

---

## 📚 Step 2 — Theory

### `06_Runtime_and_Reflection/02_theory.md`

포함 항목

* Java Reflection
* ClassLoader
* Annotation
* 런타임 동적 로딩

---

## 🧱 Step 3 — Design

### `06_Runtime_and_Reflection/03_design.md`

* 런타임 객체 생성 설계
* Reflection 기반 DI 구조

---

## 🛠 Step 4 — Implementation

### `06_Runtime_and_Reflection/04_implementation/`

| 파일                     | 실습         |
| ---------------------- | ---------- |
| ReflectionExample.java | Reflection |
| MiniDIContainer.java   | DI 구현      |

---

## 🔬 Step 5 — Analysis

### `06_Runtime_and_Reflection/05_analysis.md`

* Reflection 장단점
* 프레임워크 활용 분석

---

## 🎤 Step 6 — Interview

### `06_Runtime_and_Reflection/06_interview.md`

* Reflection 설명
* Spring 내부 동작 설명
