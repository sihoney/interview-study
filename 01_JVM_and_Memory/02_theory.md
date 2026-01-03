# 02. JVM & Memory — Core Theory

---

## ☕ Java의 장단점

### 장점
- JVM 위에서 동작 → **운영체제 독립적**
- **Garbage Collector**를 통한 자동 메모리 관리
- **ClassLoader**에 의한 동적 로딩 지원
- 객체지향 언어: 캡슐화, 상속, 다형성, 추상화 완전 지원

### 단점
- JVM 위에서 실행되므로 **실행 속도가 상대적으로 느림**
- 다중 상속 미지원, 엄격한 타입 제약
- 바이트코드 → JVM → 기계어 번역 과정으로 오버헤드 존재

---

## 🧠 JVM이란?

**JVM(Java Virtual Machine)** 은  
OS와 Java Application 사이에서 **실행 환경을 제공하는 가상 머신**이다.

### JVM 구성 요소
- **ClassLoader**: 클래스 로딩 및 링킹
- **Execution Engine**: 바이트코드 해석 및 실행
- **Garbage Collector**: Heap 메모리 자동 관리
- **Runtime Data Area**: 모든 메모리 영역

JVM은 **스택 기반 구조**이며, Java ByteCode를 OS에 맞게 실행한다.

---

## ▶ Java 프로그램 실행 과정

1. OS로부터 **Runtime Data Area 메모리 할당**
2. `.java` → `javac` → `.class` 바이트코드 생성
3. **ClassLoader**가 `.class` 파일을 메모리로 로딩
4. **Execution Engine**이 바이트코드를 해석/실행

---

## 🗂 Runtime Data Area 구조

### 📦 Method Area
- 클래스 정보, 메서드, 필드, static 변수, final 변수 저장

### 🧮 Heap
- new로 생성된 객체, 배열 저장
- GC 관리 대상

### 🧵 Stack
- 각 스레드마다 생성
- 지역변수, 매개변수, 연산 데이터 저장

### 📍 PC Register
- 현재 실행 중인 명령어 주소 저장

### 🔧 Native Method Stack
- C/C++ 네이티브 코드 실행

---

## 🧬 Java 데이터 타입

### Primitive Type (Stack 저장)
- byte, short, int, long
- float, double
- boolean
- char

### Reference Type (Heap 저장)
- Object, Array, String, Wrapper 등
- 참조 주소는 Stack에 저장

---

## 🧷 static 변수

- 클래스당 하나
- Method Area에 저장
- 모든 객체가 공유
- 프로그램 종료 시 소멸

---

## 🧨 main 메서드가 static인 이유

JVM은 객체 생성 전에 main을 호출해야 한다.  
static이므로 인스턴스 없이 실행 가능하다.

---

## 🧵 String / StringBuilder / StringBuffer

| 타입 | 특징 |
|--|--|
String | 불변, String Pool 사용 |
StringBuilder | 가변, 동기화 X, 빠름 |
StringBuffer | 가변, 동기화 O, thread-safe |

---

## 🧬 new String("") vs ""

`""` → String Pool  
`new String()` → Heap 객체

`intern()` 사용 시 Pool 이동 가능

---

## ♻ Garbage Collector

- Heap 메모리 관리
- Unreachable Object 제거
- **Mark & Sweep 방식**

### GC Root
- Stack
- Native Stack
- Method Area

---

## 🧱 final / finally / finalize

| 키워드 | 의미 |
|--|--|
final | 변경 불가 |
finally | 항상 실행 블록 |
finalize | GC 직전 호출 메서드 |
