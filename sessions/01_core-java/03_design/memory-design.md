# Memory Design

## Problem

서비스 트래픽 증가 후 GC가 과도하게 발생하면서 시스템이 멈추는 현상이 발생했다.

## Design Goals

- Heap 사용 안정화
- GC Pause 최소화
- 객체 생명주기 관리 명확화

## Strategy

- 불필요한 객체 생성 제거
- String Pool 적극 활용
- static 객체 사용 최소화
- 대량 객체 생성 구간 분리
- GC 로그 기반 튜닝

## Expected Effect

- Full GC 감소
- 응답 시간 안정화
