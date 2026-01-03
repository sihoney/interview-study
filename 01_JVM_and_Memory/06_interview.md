# 06. JVM & Memory — Interview Answers

---

## ❓ JVM이 무엇입니까?

JVM은 OS와 Java Application 사이에서 실행 환경을 제공하는 가상 머신입니다.  
Java 프로그램은 OS 위에서 바로 실행되지 않고, JVM 위에서 실행되며 JVM이 메모리 관리, 스레드 관리, 바이트코드 해석을 담당합니다.

---

## ❓ Java 프로그램 실행 과정 설명해주세요.

1. 자바 소스 파일을 컴파일하여 바이트코드(.class) 생성
2. ClassLoader가 해당 클래스를 메모리에 로드
3. Execution Engine이 바이트코드를 해석 및 실행
4. Runtime Data Area에서 메모리 관리

---

## ❓ JVM 메모리 구조 설명해주세요.

JVM 메모리는 Method Area, Heap, Stack, PC Register, Native Method Stack으로 구성됩니다.  
Heap은 객체가 저장되고 GC 관리 대상이며, Stack은 메서드 호출 흐름과 지역 변수를 관리합니다.

---

## ❓ 서버 장애 상황에서 GC가 어떤 영향을 주나요?

객체 생성이 많아지면 Heap이 빠르게 증가하고 GC가 자주 발생합니다.  
GC는 Stop-The-World를 발생시키므로 빈번해지면 서버가 멈춘 것처럼 보일 수 있습니다.

---

## ❓ String과 메모리 관계를 설명해주세요.

String 리터럴은 String Pool에 저장되어 공유됩니다.  
`new String()`은 Heap에 개별 객체를 생성하므로 메모리를 더 사용합니다.

---

## ❓ main 메서드는 왜 static인가요?

JVM이 객체 생성 전에 실행할 수 있어야 하므로 인스턴스 없이 호출 가능한 static으로 선언되어 있습니다.

---

## ❓ static 변수의 특징은 무엇인가요?

static 변수는 클래스당 하나만 생성되며 Method Area에 저장되고 모든 객체가 공유합니다.

---

## ❓ finalize는 왜 사용하면 안 되나요?

finalize는 호출이 보장되지 않으며 성능과 안정성에 문제를 일으킬 수 있어 실무에서는 사용하지 않습니다.

---

## 🧾 한 문장 정리

> "JVM은 객체 생명주기와 메모리, GC를 통해 서버의 안정성과 성능을 직접 결정하는 핵심 시스템입니다."
