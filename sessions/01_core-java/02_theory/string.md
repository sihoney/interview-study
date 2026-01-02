좋아.
이게 **메모리 & 성능 면접에서 가장 자주 나오는 파트**다.

---

## 📄 `sessions/01_core-java/02_theory/string.md`

```md
# String & Memory

## 1. String Immutability

Java의 `String`은 **불변 객체(Immutable)** 이다.

내부 구조:
```

private final char[] value;

````

문자열을 변경하면 **기존 객체 수정 ❌ → 새로운 객체 생성 ⭕**

---

## 2. String Pool

문자열 리터럴은 Heap 내부의 **String Pool**에 저장된다.

```java
String a = "hello";
String b = "hello";
````

a와 b는 **같은 객체**를 참조한다.

---

## 3. new String("") vs ""

```java
String a = "hello";           // String Pool
String b = new String("hello"); // Heap (새 객체)
```

`new` 사용 시 무조건 **새 인스턴스 생성** → GC 부담 증가

`intern()` → String Pool 등록

---

## 4. String + 연산의 위험성

```java
String s = "";
for(int i=0;i<10000;i++){
    s += i;
}
```

매 반복마다 새 객체 생성 → **메모리 폭증**

---

## 5. StringBuilder

* 가변 객체
* 동기화 ❌
* 단일 스레드 환경 최적

---

## 6. StringBuffer

* 가변 객체
* 동기화 ⭕
* 멀티 스레드 안전
* 성능은 Builder보다 느림

---

## 7. Interview Key Line

> String은 불변 객체이기 때문에 문자열 변경 시 새로운 객체가 생성되며,
> 대량 문자열 처리에는 StringBuilder가 필수이다.

```

---

다음 이론 파일은  
**`type-system.md`** — Primitive / Reference, equals, hashCode, Wrapper, Boxing 전부 묶는다.
```
