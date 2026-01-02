# Garbage Collector

GC는 Heap 영역의 Unreachable Object를 제거한다.

## Mark & Sweep

- Root Space(Stack, Method Area, Native Stack)에서 시작
- 참조 객체 마킹
- 미마킹 객체 제거

## 장단점

장점: 메모리 누수 방지, 안정성  
단점: GC 타이밍 제어 불가, 성능 오버헤드
