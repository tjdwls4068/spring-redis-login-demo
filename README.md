# 🔐 Spring + Redis 로그인 세션 API

이 프로젝트는 Spring Boot와 Redis를 사용하여 로그인 세션을 관리하는 API입니다.  
실무에서 자주 사용하는 Redis 기반 세션 저장 및 로그아웃 기능을 직접 구현했습니다.

---

## 🚀 주요 기능

- 사용자 로그인 시 UUID 토큰 발급
- 토큰을 Redis에 저장 (TTL 30분)
- 사용자 정보 조회 (토큰 인증 방식)
- 로그아웃 시 Redis 키 제거
- Postman으로 테스트 완료

---

## 🛠 기술 스택

- Java 17
- Spring Boot 3.x
- Redis (Docker)
- Spring Web, Spring Data Redis
- StringRedisTemplate, ObjectMapper
- IntelliJ + Git + Postman

---

## 📌 API 명세

### ✅ POST /auth/login

- 요청 바디:

```json
{
  "username": "성진",
  "password": "1234"
}

```
- 응답:

"e2230fc1-xxxx-xxxx-xxxx-abc123"



### ✅ GET /auth/me
- 요청 헤더:

Authorization: e2230fc1-xxxx-xxxx-xxxx-abc123
- 응답:

```json
{
"username": "성진",
"password": "1234"
}
```
✅ POST /auth/logout
- 요청 헤더:
Authorization: e2230fc1-xxxx-xxxx-xxxx-abc123

- 응답: "로그아웃 완료"

실행 방법
1. 로컬에서 Redis 실행 (또는 Docker로 실행):

  bash
  docker run -d -p 6379:6379 --name my-redis redis

2. IntelliJ에서 프로젝트 실행

3. Postman으로 위 API 요청 테스트


📚 공부 목표
실무에서 자주 쓰는 Redis 사용법 체득

토큰 방식 인증 구조 익히기

Spring Boot + 외부 시스템 연동 경험


 