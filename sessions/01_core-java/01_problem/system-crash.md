# Problem — Production System Crash

## 🧨 Incident

서비스 트래픽이 급증한 후, 서버 응답이 급격히 느려지다가 결국 다운되었다.  
CPU 사용률은 높지 않았고, 메모리는 여유가 있는 것처럼 보였으나  
GC 로그에는 Full GC가 반복적으로 발생하고 있었다.

---

## 🔍 Observed Symptoms

- 요청 처리 지연
- 간헐적 응답 중단
- GC pause time 급증
- Heap 사용량 급격한 변동
- 스레드 수 증가
- OOM 직전 상태

---

## ❓ Key Questions

1. JVM은 메모리를 어떻게 관리하는가?
2. Runtime Data Area 구조는 어떻게 되어 있는가?
3. GC는 언제, 어떤 기준으로 실행되는가?
4. 왜 메모리가 남아있어 보이는데 서버는 멈췄는가?
5. String 사용 방식이 메모리에 어떤 영향을 주는가?
6. static 객체는 메모리 관리에 어떤 영향을 주는가?
7. 동시 요청이 들어올 때 스레드는 어떻게 처리되는가?
8. GC와 멀티스레드 사이에는 어떤 관계가 있는가?

---

## 🎯 Learning Objective

이 장애를 설명할 수 있다면  
**Java의 핵심을 이해한 것이다.**
