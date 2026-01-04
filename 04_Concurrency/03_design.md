# 03. Concurrency — System Design

---

## 🎯 설계 목표

> 공유 자원 접근을 통제하여  
> **Race Condition을 제거**한다.

---

## ⚔ Race Condition 구조

```

Thread A → read stock = 10
Thread B → read stock = 10
Thread A → stock = 9
Thread B → stock = 9   ❌ 데이터 손상

```

---

## 🧱 임계 구역 설계

### ❌ 보호 없는 구조

```

stock--;

```

### ⭕ 보호된 구조

```

synchronized(lock) {
stock--;
}

```

---

## 🧮 CAS 기반 설계

```

AtomicInteger stock = new AtomicInteger(10);
stock.decrementAndGet();

```

---

## 🧠 설계 전략

| 상황 | 선택 |
|--|--|
강한 안전성 | synchronized |
높은 성능 | Atomic |
가시성만 필요 | volatile |

---

> 동시성 설계는 **버그를 구조적으로 차단하는 기술**이다.
