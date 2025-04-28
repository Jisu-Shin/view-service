# 🖼️ view-service

OO-SMS 프로젝트의 프론트엔드 역할을 담당하는 서비스입니다.  
Spring MVC 아키텍처와 Mustache 템플릿 엔진을 기반으로, 고객 등록, 공연 예약 및 문자 발송 관련 웹 페이지를 제공합니다.

---

## 🛠 기술 스택

- Java 17
- Spring Boot 3.3
- Spring MVC
- Mustache
- RestTemplate (API 통신)
- Docker

---
## 🧩 주요 기능

- 공연 예약 화면
- 고객 등록/조회 화면
- 문자 발송 화면
- API 호출을 통한 예약, 고객, 문자 데이터 조회 및 저장

---
## 🖼️ 화면 예시

### 🎟️ 공연 예약 화면

![booking-page](./docs/images/booking-page.png)

공연 정보를 확인하고 고객이 예매할 수 있는 화면입니다.

<br>

### 👤 고객 등록 화면

![customer-page](./docs/images/customer-page.png)

고객 이름과 전화번호를 입력하여 등록할 수 있습니다.

<br>

### 💬 문자 발송 화면

![sms-page](./docs/images/sms-page.png)

예약한 공연과 고객을 선택하여 문자 발송을 예약하는 화면입니다.

---

## 🛤️ 시스템 연동 구조

- 사용자는 Gateway를 통해 `/view` 경로로 요청을 보냅니다.
- Gateway는 해당 요청을 view-service로 라우팅합니다.
- view-service는 Mustache 템플릿을 렌더링하여 사용자에게 웹 페이지를 제공합니다.
- view-service는 내부적으로 booking-service, cust-service, sms-service 등의 API를 호출하여 필요한 데이터를 가져옵니다.

```plaintext
[사용자 브라우저] 
   ↓ (HTTP 요청: /view/**)
[Gateway] 
   ↓ (라우팅)
[view-service] 
   ↓ (RestTemplate으로 API 호출)
[booking-service / cust-service / sms-service]
```



