# 02. Type & Data — Core Theory

---

## 🧬 Java의 데이터 타입 구조

### Primitive Type
- byte, short, int, long
- float, double
- boolean
- char  
  → **Stack 저장**

### Reference Type
- Object, Array, String, Wrapper, Class 등  
  → **Heap 저장, 참조는 Stack**

---

## ⚖ equals vs ==

- `==` : 메모리 주소 비교
- `equals()` : 객체의 논리적 값 비교

equals를 오버라이드하면 반드시 **hashCode도 함께 오버라이드**해야 한다.

> HashMap/HashSet이 객체를 찾는 방식이 `HashCode -> equals` 순서이기 때문

---

## 🧾 hashCode()

- 동일 객체는 동일한 hashCode 반환
- HashMap, HashSet의 핵심 동작 기준

---

### HashMap이 객체를 찾는 실제 순서

HashMap에서 어떤 키를 찾을 때, JVM은 이 순서로 움직인다.

```
1. key.hashCode() 호출
2. hashCode 값으로 버킷(bucket) 위치 결정
3. 그 버킷 안에서 equals()로 진짜 같은 객체인지 비교
```

> hashCode는 위치 결정용, equals는 최종 판별용

---

## 🧷 Wrapper Class

| Primitive | Wrapper |
|--|--|
int | Integer |
long | Long |
double | Double |
char | Character |
boolean | Boolean |

Wrapper는 **불변 객체**

---

## 🔄 Boxing / Unboxing

- Primitive → Wrapper : Boxing
- Wrapper → Primitive : Unboxing
- 자동 변환 지원 (Auto-boxing)

---

## 🧬 Generic

Generic은 타입을 외부에서 지정하는 설계 방식이다.

### 장점
- 컴파일 타임 타입 안정성
- 캐스팅 제거
- 코드 재사용성 증가

---

## 🧯 Optional

null을 직접 다루지 않기 위한 **안전한 Wrapper**

- NPE 방지
- 명시적 null 표현

---

## 🧾 직렬화 / 역직렬화

### 직렬화
객체 → byte stream

### 역직렬화
byte stream → 객체

Serializable 인터페이스 필요

---

> 타입 설계는 **버그를 컴파일 단계에서 차단하는 기술**이다.
