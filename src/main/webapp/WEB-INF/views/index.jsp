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
<%--네비게이션 영역--%>
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
                <a class="nav-link" href="http://localhost:8080/logout">로그아웃</a>
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

<%--헤더 영역--%>
<div class="header">
    <h1>환영합니다!</h1>
    <p>이곳에서 당신의 최고의 선생님을 찾아보세요!</p>
</div>

<%--    컨텐츠 영역--%>
<div class="content">
    <form action="/lesson/lessonList" method="get" class="form-inline">
        <div class="form-group mb-2 d-inline">
            <label for="category" class="sr-only">카테고리</label>
            <input type="text" class="form-control" id="category" name="category" placeholder="카테고리">
        </div>

        <div class="form-group mx-sm-3 mb-2 d-inline">
            <label for="location" class="sr-only">지역</label>
            <input type="text" class="form-control" id="location" name="location" placeholder="지역">
        </div>

        <div class="form-check form-check-inline mb-2">
            <input class="form-check-input" type="radio" name="ftf" id="ftfYes" value="Y">
            <label class="form-check-label" for="ftfYes">대면</label>
        </div>

        <div class="form-check form-check-inline mb-2">
            <input class="form-check-input" type="radio" name="ftf" id="ftfNo" value="N">
            <label class="form-check-label" for="ftfNo">비대면</label>
        </div>

        <button type="submit" class="btn btn-primary mb-2">검색</button>
    </form>
    <c:if test="${empty lessonDtoList}">
        <h2>등록된 강의가 없습니다</h2>
    </c:if>
    <%--강의 리스트 카드 형식으로 출력--%>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:if test="${not empty lessonDtoList}">
            <c:forEach var="lessonDto" items="${lessonDtoList}">

                <div class="col">
                    <div class="card h-60">
                        <a href="http://localhost:8080/lesson/detail/${lessonDto.classId}">
                            <img src="${lessonDto.filePath}" class="card-img-top circle-image" alt="..." width="50"></a>
                        <div class="card-body">
                            <h5 class="card-title">${lessonDto.teacherName}</h5>
                            <p class="card-text">${lessonDto.lessonName}</p>
                            <p class="card-text">${lessonDto.category}</p>
                            <p class="card-text">${lessonDto.location}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>

<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
