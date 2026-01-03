# 05. JVM & Memory — Experiment Analysis

---

## 🧪 MemoryTest 분석 (Heap OOM)

### 결과
```
PS C:\web-projects\interview-study\01_JVM_and_Memory\04_implementation> java -Xms64m -Xmx64m MemoryTest

OOM after allocating about 31MB
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at MemoryTest.main(MemoryTest.java:11)
```

### 관찰
- Heap 크기 제한 시 빠르게 OutOfMemoryError 발생
- Stack은 정상
- GC가 계속 실행되지만 회수 불가

### 해석
- Heap에 객체가 계속 누적됨
- GC는 참조가 남아 있는 객체는 제거 불가
- 객체 생성 패턴이 잘못되면 GC가 있어도 메모리는 고갈된다

### 면접 연결
> GC는 만능이 아니다.  
> 객체 생명주기 설계가 중요하다.

---

## 🧪 GcTest 분석 (GC 동작)

### 결과
```
PS C:\web-projects\interview-study\01_JVM_and_Memory\04_implementation> java -Xms128m -Xmx128m -Xlog:gc* GcTest                                                                                   
[0.011s][info][gc] Using G1
[0.014s][info][gc,init] Version: 17.0.17+10-LTS (release)
[0.015s][info][gc,init] CPUs: 12 total, 12 available
[0.015s][info][gc,init] Memory: 16067M
[0.016s][info][gc,init] Large Page Support: Disabled
[0.016s][info][gc,init] NUMA Support: Disabled
[0.016s][info][gc,init] Compressed Oops: Enabled (32-bit)
[0.016s][info][gc,init] Heap Region Size: 1M
[0.016s][info][gc,init] Heap Min Capacity: 128M
[0.017s][info][gc,init] Heap Initial Capacity: 128M
[0.018s][info][gc,init] Heap Max Capacity: 128M
[0.018s][info][gc,init] Pre-touch: Disabled
[0.018s][info][gc,init] Parallel Workers: 10
[0.018s][info][gc,init] Concurrent Workers: 3
[0.019s][info][gc,init] Concurrent Refinement Workers: 10
[0.020s][info][gc,init] Periodic GC: Disabled
[0.028s][info][gc,metaspace] CDS archive(s) mapped at: [0x000001d48f000000-0x000001d48fbb0000-0x000001d48fbb0000), size 12255232, SharedBaseAddress: 0x000001d48f000000, ArchiveRelocationMode: 1.
[0.029s][info][gc,metaspace] Compressed class space mapped at: 0x000001d490000000-0x000001d4d0000000, reserved size: 1073741824
[0.030s][info][gc,metaspace] Narrow klass base: 0x000001d48f000000, Narrow klass shift: 0, Narrow klass range: 0x100000000
Start GC test
[0.065s][info][gc,start    ] GC(0) Pause Young (Normal) (G1 Evacuation Pause)
[0.066s][info][gc,task     ] GC(0) Using 3 workers of 10 for evacuation
[0.071s][info][gc,phases   ] GC(0)   Pre Evacuate Collection Set: 0.1ms
[0.072s][info][gc,phases   ] GC(0)   Merge Heap Roots: 0.1ms
[0.072s][info][gc,phases   ] GC(0)   Evacuate Collection Set: 4.0ms
[0.073s][info][gc,phases   ] GC(0)   Post Evacuate Collection Set: 0.7ms
[0.074s][info][gc,phases   ] GC(0)   Other: 0.8ms
[0.075s][info][gc,heap     ] GC(0) Eden regions: 23->0(14)
[0.075s][info][gc,heap     ] GC(0) Survivor regions: 0->3(3)
[0.076s][info][gc,heap     ] GC(0) Old regions: 0->19
[0.077s][info][gc,heap     ] GC(0) Archive regions: 0->0
[0.078s][info][gc,heap     ] GC(0) Humongous regions: 0->0
[0.079s][info][gc,metaspace] GC(0) Metaspace: 163K(384K)->163K(384K) NonClass: 155K(256K)->155K(256K) Class: 8K(128K)->8K(128K)
[0.079s][info][gc          ] GC(0) Pause Young (Normal) (G1 Evacuation Pause) 22M->21M(128M) 14.087ms
[0.080s][info][gc,cpu      ] GC(0) User=0.02s Sys=0.03s Real=0.01s
[0.082s][info][gc,start    ] GC(1) Pause Young (Normal) (G1 Evacuation Pause)
[0.083s][info][gc,task     ] GC(1) Using 3 workers of 10 for evacuation
[0.088s][info][gc,phases   ] GC(1)   Pre Evacuate Collection Set: 0.1ms
[0.088s][info][gc,phases   ] GC(1)   Merge Heap Roots: 0.1ms
[0.089s][info][gc,phases   ] GC(1)   Evacuate Collection Set: 3.2ms
[0.090s][info][gc,phases   ] GC(1)   Post Evacuate Collection Set: 0.6ms
[0.090s][info][gc,phases   ] GC(1)   Other: 1.5ms
[0.091s][info][gc,heap     ] GC(1) Eden regions: 14->0(24)
[0.091s][info][gc,heap     ] GC(1) Survivor regions: 3->3(3)
[0.092s][info][gc,heap     ] GC(1) Old regions: 19->33
[0.093s][info][gc,heap     ] GC(1) Archive regions: 0->0
[0.093s][info][gc,heap     ] GC(1) Humongous regions: 0->0
[0.093s][info][gc,metaspace] GC(1) Metaspace: 163K(384K)->163K(384K) NonClass: 155K(256K)->155K(256K) Class: 8K(128K)->8K(128K)
```

### 관찰
- 반복 생성 → 참조 제거 → GC 발생
- Full GC 증가 시 응답 지연 발생

### 해석
- GC는 Heap을 정리하지만 STW(Stop-The-World) 발생
- GC 빈도가 높아지면 서버 응답이 멈춘 것처럼 보인다

### 면접 연결
> 트래픽 증가 → 객체 생성 폭증 → GC 압박 → 서버 장애

---

## 🧪 StringPoolTest 분석

### 결과
```
PS C:\web-projects\interview-study\01_JVM_and_Memory\04_implementation> java StringPoolTest
[Pool]
a == b : true

[Heap new String]
c == d : false
a == c : false

[intern()]
a == e : true
```

### 관찰
- `""`는 String Pool 공유
- `new String()`은 Heap에 개별 객체 생성
- intern() 호출 시 Pool 이동

### 해석
- 불필요한 new String은 Heap 낭비
- String Pool 활용이 메모리 효율적

### 면접 연결
> 문자열 생성 전략만 바꿔도 메모리 사용량이 크게 달라진다.

---

## 🧪 StackHeapTest 분석

### 결과
```
PS C:\web-projects\interview-study\01_JVM_and_Memory\04_implementation> java StackHeapTest
methodA x=10, p.name=J
methodB p.name=Changed
```

### 관찰
- 지역 변수는 Stack
- 객체는 Heap
- 참조만 Stack에서 관리됨

### 해석
- Stack은 메서드 종료 시 자동 정리
- Heap은 GC에 의존

### 면접 연결
> 메모리 누수의 대부분은 Heap 설계 문제다.

---

## 🧪 FinalizeTest 분석

### 결과
```
PS C:\web-projects\interview-study\01_JVM_and_Memory\04_implementation> java -Xms128m -Xmx128m FinalizeTest
Objects created. Requesting GC...
finalize called: 2622
finalize called: 2498
finalize called: 2497
finalize called: 2496
finalize called: 2495
finalize called: 2494
finalize called: 2493
finalize called: 2492
finalize called: 2491
finalize called: 2490

...

Done.
```

### 관찰
- finalize는 호출될 수도, 안 될 수도 있음

### 해석
- finalize는 신뢰 불가
- 실무에서 사용 금지 수준

### 면접 연결
> finalize는 비결정적이며, 자원 관리는 try-with-resources로 처리해야 한다.

---

## 🧪 StaticTest 분석

### 결과
```
PS C:\web-projects\interview-study\01_JVM_and_Memory\04_implementation> java StaticTest
staticCounter (shared) = 3
a.instanceCounter = 2
b.instanceCounter = 1
```

### 관찰
- static은 객체 간 공유
- instance는 객체별 분리

### 해석
- static은 클래스 로딩 시 생성
- main이 static인 이유 명확해짐

### 면접 연결
> JVM이 객체 생성 없이 실행하기 위해 main은 static이다.

---

## 🧠 종합 결론

| 항목 | 핵심 요약 |
|--|--|
Heap | 객체 저장, GC 관리 |
Stack | 실행 흐름 관리 |
GC | 장애 원인 가능 |
String | 메모리 설계 핵심 |
static | 클래스 단위 공유 |

---

> 이 분석을 통해  
> JVM, 메모리, GC, 객체 생애주기를  
> **장애 상황에 연결해서 설명 가능해야 한다.**
