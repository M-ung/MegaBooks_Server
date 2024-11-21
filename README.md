# 📚 MegaBooks - Server

## 🖥️ 프로젝트 소개
사용자가 책을 읽을 때, 빔프로젝터, 스피커, Control Box를 활용하여 읽고 있는 문장을 다감각으로 느껴볼 수 있는 앱 서비스입니다.

<div style="display: flex; flex-wrap: wrap; gap: 10px;">
    <img src="https://github.com/user-attachments/assets/fdb5ca6c-ee41-4d87-aee5-a87095c27f5a" width="30%">
    <img src="https://github.com/user-attachments/assets/9cb086f1-f426-45ca-9428-fdfb43bd8e47" width="30%">
    <img src="https://github.com/user-attachments/assets/e33b19fe-c115-4a37-8ed3-aa367adbe373" width="30%">
    <img src="https://github.com/user-attachments/assets/df366703-2ae1-4ae5-866d-bea242c4d8c6" width="30%">
    <img src="https://github.com/user-attachments/assets/573c3fcb-528b-4be1-9140-990d966e916d" width="30%">
    <img src="https://github.com/user-attachments/assets/05092b45-70a9-4986-9464-03eee175733f" width="30%">
    <img src="https://github.com/user-attachments/assets/164dd906-9464-44d0-b103-35f67f547ac7" width="30%">
    <img src="https://github.com/user-attachments/assets/380062a2-67d6-4a6c-8e2e-cc782263a44d" width="30%">
    <img src="https://github.com/user-attachments/assets/7da7d34d-c969-4e18-8b64-aa2aee93c392" width="30%">
    <img src="https://github.com/user-attachments/assets/1d165882-cc39-4ef4-8af7-544071b79051" width="30%">
</div>

<br>

## 📺 MegaBooks 실제 화면
<div style="display: flex; flex-wrap: wrap; gap: 10px;">
    <img src="https://github.com/user-attachments/assets/1ac7e8fd-addd-4740-98db-e3430614293b" width="30%">
    <img src="https://github.com/user-attachments/assets/39703e0a-aeb4-42ca-9ec2-9bc93c531721" width="30%">
    <img src="https://github.com/user-attachments/assets/f518baa4-2735-4923-b07a-514d33bc36c1" width="30%">
    <img src="https://github.com/user-attachments/assets/47c260bb-9df7-422a-a8db-ac2509bc2603" width="30%">
    <img src="https://github.com/user-attachments/assets/e8aa8441-ac34-4644-9374-64c05ded2ce0" width="30%">
    <img src="https://github.com/user-attachments/assets/300fb486-3dd6-4cf4-8821-8288ca968212" width="30%">
    <img src="https://github.com/user-attachments/assets/c42188b5-50dc-4488-9053-884f6c4121e5" width="30%">
    <img src="https://github.com/user-attachments/assets/3bcf3992-63e2-4d66-989c-02ff5cbc0797" width="30%">
    <img src="https://github.com/user-attachments/assets/4a0af744-e6dd-4a9f-bf03-260ce9d25d62" width="30%">
    <img src="https://github.com/user-attachments/assets/76a41859-1ed6-4d14-a04c-a49922ca4b40" width="30%">
    <img src="https://github.com/user-attachments/assets/4cf9f401-8ef1-436c-8af3-01ba22183209" width="30%">
</div>

<br>

## 🎥 시연 영상(Youtube 링크 🔗)
https://www.youtube.com/watch?v=gfNkmmNcwHU

<br>

## 🕰️ 개발 기간
* 24.02.15 - 2024.10.30

<br>

## ⚙️ 개발 환경
- `Java 17`
- **IDE** : IntelliJ IDEA
- **Framework** : Springboot(3.1.7)
- **Database** : MySQL
- **ORM** : Hibernate (Spring Data JPA 사용)

<br>

## 🧑‍🤝‍🧑 맴버구성
<p>
    <a href="https://github.com/M-ung">
      <img src="https://avatars.githubusercontent.com/u/126846468?v=4" width="100">
    </a>
</p>

<br>

## 📌 CI/CD 파이프라인 및 아키텍처
<img width="661" alt="스크린샷 2024-09-02 오후 10 46 32" width="50%">

<br>

## 📝 규칙
- `커밋 컨벤션`
    - Feat: 새로운 기능 추가
    - Fix: 버그 수정
    - Docs: 문서 수정
    - Style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
    - Refactor: 코드 리팩토링
    - Test: 테스트 코드, 리팩토링 테스트 코드 추가
    - Chore: 빌드 업무 수정, 패키지 매니저 수정

- `branch 규칙`
    - 각자의 깃 닉네임을 딴 branch 명을 사용한다.
    - 예시
        - git checkout -b feature/기능
        - git checkout -b feature/user

- `commit message 규칙`
    - 종류: 메시지
    - 예시
        - feat: 커밋 내용 
        - feat: 로그인 구현 

- `DTO 규칙`
    - 엔티티명 + Response/Request + DTO
    - 예시
        - UserResponseDTO
        - PostRequestDTO

<br>

## 📌 참고 자료
- 도커 참고 자료
  - https://devfoxstar.github.io/java/springboot-docker-ec2-deploy/
  - https://ppaksang.tistory.com/17
  - https://velog.io/@zvyg1023/CICD-Docker-Github-Action-Spring-Boot
  - https://chan-it-note.tistory.com/121
---
