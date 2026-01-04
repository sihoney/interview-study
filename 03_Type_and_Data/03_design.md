# 03. Type & Data — System Design

---

## 🎯 설계 목표

> 타입 오류, NPE, 캐스팅 오류를  
> **설계 단계에서 차단**한다.

---

## 🧩 타입 안정성 설계

### ❌ 불안정한 구조

```

Object value;
String s = (String) value; // 런타임 오류 위험

```

### ⭕ 안정 구조

```

GenericBox<String> box;
String s = box.get();

```

---

## 🧬 equals / hashCode 설계 계약

### 계약
- equals가 같으면 hashCode도 같아야 함
- hashCode가 다르면 equals는 달라도 됨

### 목적
- HashMap, HashSet 정상 동작 보장

---

## 🧯 NPE 차단 설계

### ❌ 기존 방식

```

if (obj != null) { ... }

```

### ⭕ Optional 방식

```

Optional<User> user;
user.ifPresent(...)

```

---

## 🧷 Wrapper / Primitive 설계 기준

| 상황 | 선택 |
|--|--|
컬렉션 | Wrapper |
null 필요 | Wrapper |
성능 | Primitive |

---

## 🧾 직렬화 설계

- 네트워크 전송
- 파일 저장
- 캐시 저장

---

> 타입 설계는 시스템의 **안전벨트**다.
