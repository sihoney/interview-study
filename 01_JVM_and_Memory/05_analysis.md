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

### 🧠 실행 환경
- JVM: Java 17
- GC: G1 GC
- Heap: 128MB 고정 (-Xms128m -Xmx128m)

### ♻️ 관찰 결과 요약

#### 1. 객체 폭증 → Young GC 반복 발생

```
GC(0) Pause Young
Eden: 23 → 0
Survivor: 0 → 3
Old: 0 → 19
STW ≈ 8ms
```

- Eden이 빠르게 가득 차면서 **Young GC** 반복
- GC 중 **Stop-The-World** 발생

#### 2. 객체 생존 → Old 영역 급속 증가

```
Old: 0 → 19 → 32 → 55 → 72 → 85 → 94 → 101 → 106 → 111 → 116
```

- 다량의 객체가 장기 생존
- **Old 영역 팽창 → Full GC 위험 증가**

#### 3. GC는 메모리를 회수하지만 서버는 계속 멈춤

```
Pause Young ≈ 5~9ms
```

- 짧은 STW라도 **빈번하면 체감 성능 급락**

#### 4. Concurrent Mark 시작 → 본격 GC 사이클 진입

```
Concurrent Mark Cycle
Pause Remark: 116M → 56M
```

- G1이 Old 영역 관리 단계 진입
- 일부 메모리 회수 성공
- GC 비용 상승

### 🧨 전체 구조 요약

```
객체 대량 생성
↓
Eden 포화
↓
Young GC + STW 반복
↓
객체 대량 Old 승격
↓
GC 압박 증가
↓
서버 응답 지연 및 장애 위험
```

### 관찰
- 반복 생성 → 참조 제거 → GC 발생
- Full GC 증가 시 응답 지연 발생

### 해석
- GC는 Heap을 정리하지만 STW(Stop-The-World) 발생
- GC 빈도가 높아지면 서버 응답이 멈춘 것처럼 보인다

### 면접 연결
> 트래픽 증가 → 객체 생성 폭증 → GC 압박 → 서버 장애

### 🎤 면접용 핵심 정리

> "제한된 힙 환경에서 객체를 반복 생성했더니 Young GC가 매우 자주 발생했고, 그때마다 STW가 발생했습니다.  
> 살아남은 객체들이 빠르게 Old 영역으로 승격되면서 GC 압박이 증가했고, 이 구조가 실제 서버 응답 지연과 장애로 이어질 수 있음을 실험으로 확인했습니다."

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

### try-with-resources

- try-with-resources는 컴파일 타임에 자동으로 close() 호출 코드를 생성

```
try (FileInputStream in = new FileInputStream("data.txt")) {
    // 작업
}
```

컴파일되면 사실상 이렇게 바뀐다:

```
FileInputStream in = new FileInputStream("data.txt");
try {
    // 작업
} finally {
    if (in != null) in.close();
}
```

- close()는 즉시 실행된다. GC와 아무 상관이 없다.

### 실무 패턴

```
try (Connection conn = dataSource.getConnection();
     PreparedStatement ps = conn.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    // DB 작업

} catch (SQLException e) {
    // 예외 처리
}
```

- Connection, PreparedStatement, ResultSet -> 전부 AutoCloseable 구현체
- try 블록 종료 시 역순으로 close() 자동 호출

### 면접 연결
> finalize()는 호출 시점이 전혀 보장되지 않아 실무에서 사용하면 안 됩니다. 대신 AutoCloseable과 try-with-resources를 사용해 자원을 결정적으로 회수해야 합니다.

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
