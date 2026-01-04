# 02. Runtime & Reflection — Core Theory

---

## 🪞 Java Reflection이란?

Reflection은 **컴파일 시간이 아닌 런타임에**  
클래스, 메서드, 필드 정보를 분석하고 조작하는 기술이다.

---

## 🧠 Reflection이 할 수 있는 것

- Class 정보 조회
- 생성자 호출
- 메서드 호출
- 필드 접근 및 수정

---

## 📦 ClassLoader

ClassLoader는 `.class` 파일을 JVM 메모리로 로딩하는 시스템이다.

### 주요 단계
1. Loading
2. Linking
3. Initialization

---

## 🧩 Annotation

Annotation은 메타데이터이며  
Reflection과 함께 동작하여 프레임워크 동작을 제어한다.

---

## ⚠ Reflection의 장단점

### 장점
- 런타임 확장성
- 프레임워크 구현 가능

### 단점
- 성능 저하
- 캡슐화 침해
- 컴파일 타임 안정성 감소

---

> Reflection은 **프레임워크를 가능하게 하는 핵심 기술**이다.
