# JVM — Java Virtual Machine

## 1. Why JVM Exists

Java는 **운영체제 독립성**을 목표로 설계되었다.  
이를 가능하게 만드는 핵심이 **JVM**이다.

> **Write Once, Run Anywhere**

Java 프로그램은 바로 실행되지 않는다.  
`.java → .class → JVM → OS` 구조를 거친다.

---

## 2. JVM Architecture

JVM은 다음 네 가지 핵심 요소로 구성된다.

1. **Class Loader**
2. **Runtime Data Area**
3. **Execution Engine**
4. **Garbage Collector**

### (1) Class Loader

- `.class` 파일을 로드하고 검증하고 링크한다.
- 필요할 때만 동적으로 로딩한다.

### (2) Execution Engine

- Byte Code를 기계어로 변환하여 실행
- Interpreter + JIT Compiler 사용

### (3) Garbage Collector

- Heap 메모리의 **Unreachable Object** 정리
- 자동 메모리 관리

### (4) Runtime Data Area

- 프로그램 실행에 필요한 모든 메모리 영역

---

## 3. Java Execution Flow

1. OS → JVM 메모리 할당
2. `javac` → Byte Code 생성
3. ClassLoader → 메모리 로딩
4. Execution Engine → 실행

---

## 4. JVM is Stack-Based

JVM은 **Stack 기반 구조**로 동작한다.  
모든 연산은 Operand Stack을 통해 수행된다.

---

## 5. Why JVM is Slow (Tradeoff)

| 장점 | 단점 |
|---|---|
| OS 독립성 | 네이티브 코드보다 느림 |
| 메모리 안정성 | JVM 오버헤드 |
| 자동 GC | Pause 발생 |

---

## 6. Interview Key Line

> JVM은 OS와 Java Application 사이의 중재자로,  
> 메모리 관리, 실행 환경, GC를 담당하는 가상 머신이다.
