# 05. Runtime & Reflection — Experiment Analysis

---

## 🧪 ReflectionExample 분석

### 관찰
- 문자열로 클래스 로딩
- 생성자, 메서드, 필드 동적 접근

### 해석
- 컴파일 시점 정보 없이 객체 조작 가능
- 프레임워크 핵심 메커니즘

---

## 🧪 MiniDIContainer 분석

### 관찰
- @Component 탐색
- 객체 자동 생성
- @Autowired 필드 주입

### 해석
- Spring DI 구조의 최소 구현
- IoC 개념 직접 체험

---

## 🧠 Reflection 장단점

| 장점 | 단점 |
|--|--|
유연성 | 성능 저하 |
프레임워크 구현 가능 | 캡슐화 파괴 |
동적 확장 | 컴파일 안정성 저하 |

---

> Reflection은 **프레임워크의 엔진**이다.
