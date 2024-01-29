<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
        }

        .navbar-custom {
            background-color: #395ED3;
        }

        .header {
            background-color: #80D1E4;
            padding: 40px;
            text-align: center;
        }

        .content {
            padding: 20px;
        }

        .footer {
            background-color: #395ED3;
            color: white;
            text-align: center;
            padding: 10px;
            /*position: fixed;*/
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
    <a class="navbar-brand" href="/"><img src="/static/images/icon.png" width="40">내일 과외</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">

        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="http://localhost:8080/user/joinForm">회원가입</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/login">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/user/myPage">마이 페이지</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/lesson/lessonList">강의 리스트</a>
            </li>
        </ul>
    </div>
</nav>

<div class="header">
    <h1>환영합니다!</h1>
    <p>이곳에서 당신의 최고의 선생님을 찾아보세요!</p>
</div>

<div class="content">
    <form class="container mt-4">
        <div class="form-group">
            <label for="userId">사용자 아이디:</label>
            <input type="text" class="form-control" name="userId" id="userId">
        </div>

        <div class="form-group">
            <label for="password">password: 비밀번호</label>
            <input type="password" class="form-control" name="password" id="password">
        </div>

        <div class="form-group">
            <label for="si">si: 시</label>
            <input type="text" class="form-control" name="si" id="si">
        </div>

        <div class="form-group">
            <label for="gun">gun: 군</label>
            <input type="text" class="form-control" name="gun" id="gun">
        </div>

        <div class="form-group">
            <label for="gu">gu: 구</label>
            <input type="text" class="form-control" name="gu" id="gu">
        </div>

        <div class="form-group">
            <label>gender: 성별</label>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="gender" value="M" id="genderM">
                <label class="form-check-label" for="genderM">남자</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="gender" value="W" id="genderW">
                <label class="form-check-label" for="genderW">여자</label>
            </div>
        </div>

        <div class="form-group">
            <label for="age">age: 나이</label>
            <input type="text" class="form-control" name="age" id="age" value="20">
        </div>

        <div class="form-group">
            <label for="userName">userName: 사용자 이름</label>
            <input type="text" class="form-control" name="userName" id="userName">
        </div>

        <div class="form-group">
            <label for="phoneNumber">phoneNumber: 전화번호</label>
            <div class="input-group">
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber">
                <div class="input-group-append">
                    <button type="button" class="btn btn-outline-secondary" onclick="sendSms()">인증번호 전송</button>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="certificationCode">certificationCode: 인증번호</label>
            <div class="input-group">
                <input type="text" class="form-control" id="certificationCode">
                <div class="input-group-append">
                    <button type="button" class="btn btn-outline-secondary" onclick="certificate()">인증 확인</button>
                </div>
            </div>
        </div>

        <div class="form-group">
            <button type="button" class="btn btn-primary" onclick="join()">회원가입</button>
        </div>
    </form>
</div>

<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

    let isCertificate = false;

    function sendSms() {
        const phoneNumber = document.querySelector("input[name='phoneNumber']").value;

        let formData = new FormData();

        formData.append("phoneNumber", phoneNumber);

        axios.post("/user/sms/verificationCode", formData)
            .then(function (response) {
                alert("인증번호를 발송했습니다");
            }).catch(function (error) {
            alert(error);
        });
    }

    function certificate() {
        const phoneNumber = document.querySelector("input[name='phoneNumber']").value;
        const certificationCode = document.querySelector("input[id='certificationCode']").value;

        let formData = new FormData();

        formData.append("phoneNumber", phoneNumber);
        formData.append("certificationCode", certificationCode);

        axios.post("/user/sms/certificate", formData)
            .then(function (response) {
                alert("인증이 완료되었습니다");
                isCertificate = true;
            }).catch(function (error) {
            alert(error);
        });
    }

    function join() {
        if (!isCertificate) {
            alert("인증번호를 확인해주세요");
            return;
        }

        let formData = new FormData();
        formData.append("userId", document.querySelector('input[name="userId"]').value);
        formData.append("password", document.querySelector('input[name="password"]').value);
        formData.append("si", document.querySelector('input[name="si"]').value);
        formData.append("gun", document.querySelector('input[name="gun"]').value);
        formData.append("gu", document.querySelector('input[name="gu"]').value);
        formData.append("gender", document.querySelector('input[name="gender"]:checked').value);
        formData.append("age", document.querySelector('input[name="age"]').value);
        formData.append("userName", document.querySelector('input[name="userName"]').value);
        formData.append("phoneNumber", document.querySelector('input[name="phoneNumber"]').value);

        axios.post("/user/join", formData)
            .then(function (response) {
                alert("회원가입을 환영합니다");
                location.href = "/";
            }).catch(function (error) {
            alert(error);
        });
    }
</script>
</body>
</html>
