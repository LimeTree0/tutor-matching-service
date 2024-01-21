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
    <form action="/lesson" method="post" class="mb-3">
        <input name="teacherId" value="${teacherId}" readonly hidden>

        <div class="form-group">
            <label>카테고리:</label>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="category" value="수학" id="math">
                <label class="form-check-label" for="math">수학</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="category" value="과학" id="science">
                <label class="form-check-label" for="science">과학</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="category" value="컴퓨터" id="computer">
                <label class="form-check-label" for="computer">컴퓨터 공학</label>
            </div>
        </div>
        <div class="form-group">
            <label for="lessonName">강의명:</label>
            <input type="text" class="form-control" name="lessonName" id="lessonName">
        </div>
        <div class="form-group">
            <label for="location">지역:</label>
            <input type="text" class="form-control" name="location" id="location">
        </div>
        <div class="form-group">
            <label for="price">강의 가격:</label>
            <input type="number" name="price" class="form-control" id="price">
        </div>
        <div class="form-group">
            <label for="description">강의 설명:</label>
            <textarea name="description" class="form-control" id="description"></textarea>
        </div>
        <div class="form-group">
            <label>대면/비대면 여부:</label>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="ftf" value="Y" id="ftfYes">
                <label class="form-check-label" for="ftfYes">대면</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="ftf" value="N" id="ftfNo">
                <label class="form-check-label" for="ftfNo">비대면</label>
            </div>
        </div>
        <div class="form-group">
            <label for="peopleNumber">정원:</label>
            <input type="number" class="form-control" name="peopleNumber" id="peopleNumber">
        </div>
        <input type="submit" class="btn btn-primary" value="강의 등록">
    </form>
</div>

<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
