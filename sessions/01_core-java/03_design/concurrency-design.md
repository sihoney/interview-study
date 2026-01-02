# Concurrency Design

## Problem

동시 요청 시 데이터 무결성 깨짐

## Design Goals

- Race Condition 제거
- 성능 저하 최소화

## Strategy

- synchronized 최소화
- Atomic 클래스 활용
- CAS 기반 동시성 제어
- ThreadPool 구조 설계
- ForkJoinPool 활용

## Expected Effect

- 데이터 정합성 확보
- 처리량 증가
