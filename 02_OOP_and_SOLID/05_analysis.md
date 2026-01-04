# 05. OOP & SOLID — Experiment Analysis

---

## 🧪 BadDesign vs GoodDesign

### 관찰

| 항목 | BadDesign | GoodDesign |
|--|--|--|
확장 | 기존 코드 수정 | 클래스 추가 |
유지보수 | 위험 | 안전 |
테스트 | 어려움 | 쉬움 |
의존성 | 강결합 | 느슨한 결합 |

### 해석
- BadDesign은 OCP, DIP 위반
- GoodDesign은 인터페이스 + 다형성으로 확장 가능

---

## 🧪 SOLID 위반과 개선

### SolidViolation 문제
- 하나의 클래스가 너무 많은 책임(SRP 위반)
- 테스트와 변경 모두 위험

### SolidRefactor 효과
- 책임 분리
- DIP 적용 → 교체 가능 구조

---

## 🧪 Interface / Abstract

### 관찰
- Interface: 기능 강제, 다중 구현
- Abstract: 공통 코드 공유

### 해석
- 역할 규약은 Interface
- 코드 공유는 Abstract

---

## 🧪 Override / Overload

### 결과

```
PS C:\web-projects\interview-study\02_OOP_and_SOLID\04_implementation> java OverrideOverload
Child hello()
Child hello(Jiyeon)
```

- 오버라이딩: 다형성 핵심
- 오버로딩: 사용성 개선

---

## 🧪 Exception / Resource

- Error는 복구 불가
- Exception은 설계로 제어 가능
- try-with-resources로 누수 방지

---

## 🧠 종합 결론

| 원칙 | 효과 |
|--|--|
SRP | 변경 범위 축소 |
OCP | 확장 안전 |
DIP | 테스트 용이 |
ISP | 결합도 감소 |
LSP | 안정성 유지 |

---

> 객체지향은 **변경을 통제하는 기술**이다.
