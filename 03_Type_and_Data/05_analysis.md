# 05. Type & Data — Experiment Analysis

---

## 🧪 equals / hashCode

### 결과
```
Set size = 1
```

### 관찰
- 동일 객체가 Set에 1개만 저장됨

### 해석
- equals와 hashCode 계약 준수 → 컬렉션 정상 동작

### 면접 연결
> hashCode를 오버라이드하지 않으면 HashMap/HashSet이 깨진다.

---

## 🧪 GenericBox

### 결과
```
hello
```

### 관찰
- 캐스팅 제거
- 컴파일 단계 타입 검증

### 해석
- 런타임 오류 감소
- 코드 가독성 상승

---

## 🧪 OptionalExample

### 결과
```
Guest
```

### 관찰
- NPE 없음
- null 처리 명시화

### 해석
- 버그 원인 구조적으로 차단

---

## 🧪 BoxingUnboxing

### 결과
```
true
true
false
true
```

### 관찰
- == 비교 위험
- equals 안정

### 해석
- Wrapper는 equals 사용 필수

---

## 🧪 SerializationTest

### 결과
```
Jiyeon
```

### 관찰
- 객체 → 파일 → 객체 복원 성공

### 해석
- 네트워크, 캐시, 파일 저장 기반 기술

---

## 🧪 PrimitiveVsWrapper

### 결과
```
Primitive: 10
Wrapper: 10
Equals: true
```

### 관찰
- Wrapper는 객체
- Primitive는 값

### 해석
- 성능과 null 처리 차이

---

## 🧠 종합 결론

| 항목 | 효과 |
|--|--|
타입 안정성 | 버그 감소 |
Optional | NPE 제거 |
Generic | 컴파일 오류 차단 |
equals/hashCode | 컬렉션 안정 |

---

> 타입 설계는 **시스템 안정성의 출발점**이다.
