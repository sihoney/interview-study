# 06. Type & Data — Interview Answers

---

## ❓ Java의 타입 시스템을 설명해주세요.

Java는 Primitive Type과 Reference Type으로 나뉩니다.  
Primitive는 값 자체를 Stack에 저장하고,  
Reference Type은 Heap에 객체를 저장하고 참조만 Stack에 둡니다.

---

## ❓ equals와 hashCode를 왜 같이 오버라이드해야 하나요?

equals가 같으면 hashCode도 같아야  
HashMap, HashSet이 정상 동작하기 때문입니다.

---

## ❓ Wrapper와 Primitive 차이는?

Primitive는 성능이 좋고 null을 가질 수 없고,  
Wrapper는 객체이므로 null 가능하고 컬렉션에 사용됩니다.

---

## ❓ Generic의 장점은?

컴파일 단계 타입 검증, 캐스팅 제거, 코드 재사용성 증가입니다.

---

## ❓ Optional은 왜 사용하나요?

null 대신 명시적으로 부재를 표현해  
NPE를 구조적으로 차단합니다.

---

## ❓ 직렬화는 언제 사용되나요?

객체를 네트워크 전송, 파일 저장, 캐시 저장할 때 사용합니다.

---

## 🧾 한 문장 요약

> "타입 설계는 버그를 컴파일 단계에서 제거하는 가장 강력한 방법입니다."
