# 03. Runtime & Reflection — System Design

---

## 🎯 설계 목표

> 런타임에 클래스 정보를 읽고  
> 객체를 생성하며  
> 의존성을 자동으로 주입하는 구조를 설계한다.

---

## 🧩 런타임 객체 생성 구조

```

ClassLoader → Class 정보 로딩
↓
Reflection 분석
↓
Constructor 호출
↓
객체 생성

```

---

## 🧱 DI 컨테이너 구조

```

@ComponentScan
↓
Class 목록 수집
↓
@Component 검사
↓
Reflection으로 객체 생성
↓
@Autowired 필드 주입
↓
Bean Registry 저장

```

---

## 🧠 설계 결론

> Spring은  
> **Reflection + ClassLoader + Annotation**  
> 으로 만들어진 런타임 시스템이다.
