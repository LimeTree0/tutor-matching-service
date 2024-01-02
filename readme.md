# 테스트 방법
1. git clone "https://github.com/LimeTree0/tutor-matching-service.git"
2. 프로젝트 열고 실행
3. localhost:8080/test 로 접속
4. 테스트입니다 문구가 나오면 정상
5. localhost:8080/h2-console 로 접속
6. saved setting: Generic H2 (Embedded)로 변경
7. JDBC URL을 jdbc:h2:mem:testdb 로 변경
8. connect 클릭
9. select * from test; 입력 후 실행
10. test 데이터가 저장되어 있으면 정상