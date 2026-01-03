# 03. JVM & Memory — System Design

---

## 🎯 설계 목표

> JVM 내부에서  
> **객체가 생성 → 사용 → 참조 제거 → GC → 메모리 회수**  
> 되는 전체 흐름을 **메모리 구조 기준으로 설명할 수 있어야 한다.**

---

## 🧩 JVM 전체 구조 맵

```

OS
│
└─ JVM
├─ ClassLoader
│
├─ Runtime Data Area
│   ├─ Method Area
│   ├─ Heap
│   ├─ Stack (Thread 1)
│   ├─ Stack (Thread 2)
│   ├─ PC Register
│   └─ Native Method Stack
│
├─ Execution Engine
└─ Garbage Collector

```

---

## 🧬 객체 생애주기 흐름

```

new → Heap 생성
↓
Stack 참조 변수 연결
↓
Method 실행
↓
참조 제거 (Stack Pop)
↓
Unreachable 상태
↓
GC Mark
↓
GC Sweep
↓
Heap 메모리 회수

```

---

## 🗂 Runtime Data Area 세부 구조

### 📦 Method Area
- Class 정보
- Method 정보
- static 변수
- final 상수

### 🧮 Heap
- 모든 객체 인스턴스
- 배열
- String Pool 포함

### 🧵 Stack
- 지역 변수
- 매개 변수
- 연산 중간 값

### 📍 PC Register
- 현재 실행 명령어 주소 

### 🔧 Native Method Stack
- C/C++ 네이티브 코드 실행

---

## 🧠 GC 동작 구조

### GC Root
```

Stack
Native Stack
Method Area

```

### Mark & Sweep

```

[Mark]  → 도달 가능한 객체 표시
[Sweep] → 표시 안 된 객체 제거

```

---

## 🧵 String 메모리 구조

```

String Pool (Heap)
↑
"hello"  ← msg1, msg2
↓
new String("hello") → Heap 일반 영역

```

---

## 🧷 static 메모리 구조

```

Method Area
└─ static 변수
↑
모든 객체 공유

```

---

## 🧱 장애 발생 구조 예시

```

객체 과다 생성
↓
Heap 팽창
↓
GC 빈도 증가
↓
Stop-The-World 반복
↓
서버 응답 중단

```

---

> 이 설계를 통해  
> JVM, 메모리, GC, 객체 생애주기를  
> **한 장의 그림처럼 설명할 수 있어야 한다.**
