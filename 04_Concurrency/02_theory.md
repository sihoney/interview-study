# 02. Concurrency — Core Theory

---

## 🧵 Java에서의 멀티스레드

### 스레드 생성 방법

1. Thread 클래스 상속 → run() 오버라이드
2. Runnable 인터페이스 구현
3. Callable 인터페이스 구현 (리턴값, 예외 가능)

### 스레드 실행 구조

- start() 호출 → 실행 대기열 → 스케줄링 → run() 실행
- start()는 새로운 호출 스택을 생성

---

## 🧰 ExecutorService & ThreadPool

운영 환경에서는 직접 스레드를 만들지 않고  
**ThreadPool을 통해 관리**한다.

---

## ⚔ Race Condition

여러 스레드가 동시에 공유 자원에 접근하면서  
데이터 불일치 발생

---

## 🔐 동기화 기법

### synchronized
- 임계 영역 보호
- 비용 큼

### volatile
- 가시성 문제 해결
- 동시 수정은 해결 못함

### Atomic
- CAS 기반
- 낮은 비용 동기화

---

## 🧮 CAS 알고리즘

- CPU Cache와 Main Memory 비교
- 값이 같으면 교체
- 다르면 재시도

---

## 🔀 ForkJoinPool

작업을 분할(Fork) 후 병합(Join)  
Work Stealing 구조

---

> 동시성 설계는 **성능과 안정성의 균형**이다.
