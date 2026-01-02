# Model Answers — Core Java

### Q. GC가 무엇이고 장애를 유발할 수 있는 이유는?
GC는 Heap 영역의 Unreachable 객체를 제거하는 기능이다.  
Full GC 시 Stop-The-World가 발생하며 이 시간이 길어지면 서버가 멈춘 것처럼 보이는 장애로 이어진다.

### Q. StringBuilder를 쓰는 이유는?
String은 불변이라 결합 시 객체가 계속 생성된다.  
StringBuilder는 동일 객체 내에서 변경하므로 성능과 메모리 효율이 높다.

### Q. volatile은 왜 동시성 문제를 완전히 해결하지 못하는가?
volatile은 가시성만 보장한다. ++ 같은 복합 연산은 원자적이지 않기 때문에 레이스 컨디션은 해결되지 않는다.

### Q. parallelStream이 항상 빠르지 않은 이유는?
병렬 분할, 스케줄링, 합치기 비용이 있으며, CPU/메모리 경쟁으로 인해 오히려 느려질 수 있다.
