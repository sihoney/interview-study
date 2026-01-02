# Mock Interview Simulation

면접관: GC가 왜 장애로 이어질 수 있죠?  
지원자: GC 중 Full GC가 발생하면 모든 애플리케이션 스레드가 멈추는 Stop-The-World가 발생합니다. 이 시간이 길어지면 요청 처리가 지연되거나 타임아웃이 발생하여 서버 장애처럼 보이게 됩니다.

면접관: volatile과 Atomic의 차이는?  
지원자: volatile은 가시성만 보장하고 원자성은 보장하지 않습니다. Atomic은 CAS 기반으로 원자적 연산을 제공하여 동시성 문제를 해결합니다.
