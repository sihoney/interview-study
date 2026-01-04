# 06. Runtime & Reflection — Interview Answers

---

## ❓ Java Reflection이 무엇인가요?

Reflection은 **런타임에** 클래스 구조를 분석하고  
객체 생성, 메서드 호출, 필드 조작을 수행하는 기술입니다.

---

## ❓ Reflection은 언제 사용되나요?

프레임워크에서  
객체 생성, DI, Annotation 처리, 플러그인 구조 구현에 사용됩니다.

---

## ❓ Reflection의 단점은 무엇인가요?

- 성능 저하
- 캡슐화 침해
- 컴파일 타임 안정성 감소

---

## ❓ Spring은 내부적으로 어떻게 객체를 관리하나요?

ClassLoader로 클래스 정보를 수집한 뒤  
Reflection과 Annotation을 이용해 객체를 생성하고  
의존성을 주입합니다.

---

## 🧾 한 문장 요약

> "Reflection은 Spring 같은 프레임워크를 가능하게 만드는 핵심 기술입니다."
