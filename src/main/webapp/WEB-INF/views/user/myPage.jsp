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
            position: fixed;
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
    <h1 class="mb-4"  class="circle-image">마이페이지</h1>
    <div class="mb-4"><img src="${filePath}" height="50px"></div>
    <form>
        <div class="form-group">
            <label for="userId">userId:</label>
            <input type="text" class="form-control" id="userId" name="userId" value="${userDto.userId}" readonly>
        </div>

        <div class="form-group">
            <label for="si">si:</label>
            <input type="text" class="form-control" id="si" name="si" value="${userDto.region.si}">
        </div>

        <div class="form-group">
            <label for="gun">gun:</label>
            <input type="text" class="form-control" id="gun" name="gun" value="${userDto.region.gun}">
        </div>

        <div class="form-group">
            <label for="gu">gu:</label>
            <input type="text" class="form-control" id="gu" name="gu" value="${userDto.region.gu}">
        </div>

        <div class="form-group">
            <label for="gender">gender:</label>
            <input type="text" class="form-control" id="gender" name="gender" value="${userDto.gender}">
        </div>

        <div class="form-group">
            <label for="age">age:</label>
            <input type="text" class="form-control" id="age" name="age" value="${userDto.age}">
        </div>

        <div class="form-group">
            <label for="userName">userName:</label>
            <input type="text" class="form-control" id="userName" name="userName" value="${userDto.userName}">
        </div>

        <div class="form-group">
            <label for="profileImage">profileImage:</label>
            <input type="file" class="form-control-file" id="profileImage" name="profileImage">
        </div>

        <div class="form-group">
            <label for="phoneNumber">phoneNumber:</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${userDto.phoneNumber}">
        </div>

        <button type="button" class="btn btn-primary" onclick="updateUser()">수정</button>
        <button type="button" class="btn btn-danger" onclick="deleteUser()">삭제</button>
    </form>

    <div class="mt-4">
        <a href="http://localhost:8080/user/student" class="btn btn-primary" role="button">학생 페이지</a>
        <a href="http://localhost:8080/user/teacher" class="btn btn-secondary" role="button">선생님 페이지</a>
    </div>

</div>

<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function updateUser() {
        let userUpdateDto = {
            userId: document.querySelector('input[name="userId"]').value,
            si: document.querySelector('input[name="si"]').value,
            gun: document.querySelector('input[name="gun"]').value,
            gu: document.querySelector('input[name="gu"]').value,
            gender: document.querySelector('input[name="gender"]').value,
            age: document.querySelector('input[name="age"]').value,
            userName: document.querySelector('input[name="userName"]').value,
            phoneNumber: document.querySelector('input[name="phoneNumber"]').value,
        };

        let profileImage = document.querySelector('input[name="profileImage"]').files[0];

        let updateDto = new FormData();
        updateDto.append('userUpdateDto', new Blob([JSON.stringify(userUpdateDto)], {
            type: "application/json"
        }));
        updateDto.append('profileImage', profileImage);

        axios.put('http://localhost:8080/user/myPage', updateDto, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
            .then(function (response) {
                alert("수정이 완료되었습니다");
            })
            .catch(function (error) {
                console.log(error);
                alert("수정 중 에러가 발생하였습니다");
            });
    }

    function deleteUser() {
        let userId = document.querySelector('input[name="userId"]').value;

        axios.delete('http://localhost:8080/user/myPage/' + userId)
            .then(function (response) {
                alert("삭제가 완료되었습니다");
                location.href = 'http://localhost:8080';
            })
            .catch(function (error) {
                alert("삭제 중 에러가 발생하였습니다");
            });
    }
</script>
</body>
</html>
