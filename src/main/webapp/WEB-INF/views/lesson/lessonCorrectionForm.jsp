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
    <form action="/lesson" method="post" class="mb-3">
        <input name="classId" value="${lessonDto.classId}" readonly hidden>

        <div class="form-group">
            <label for="description">강의 설명:</label>
            <textarea name="description" class="form-control" id="description">
                ${lessonDto.description}
            </textarea>
        </div>

        <div class="form-group">
            <label>대면/비대면 여부:</label>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="ftf" value="Y" id="ftfYes"
                       <c:if test="${lessonDto.ftf == 'Y'}">checked="checked"</c:if>>
                <label class="form-check-label" for="ftfYes">대면</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" name="ftf" value="N" id="ftfNo"
                       <c:if test="${lessonDto.ftf == 'N'}">checked="checked"</c:if>>
                <label class="form-check-label" for="ftfNo">비대면</label>
            </div>
        </div>

        <div class="form-group">
            <label for="peopleNumber">정원:</label>
            <input type="number" class="form-control" name="peopleNumber" id="peopleNumber" value="${lessonDto.peopleNumber}">
        </div>

        <button type="button" class="btn btn-primary" onclick="updateLesson()">수정</button>
        <button type="button" class="btn btn-danger" onclick="deleteLesson()">삭제</button>
    </form>

</div>

<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function updateLesson() {
        let studentUpdateDto = {
            classId: document.querySelector("input[name='classId']").value,
            description: document.querySelector("textarea[name='description']").value,
            ftf: document.querySelector("input[name='ftf']:checked").value,
            peopleNumber: document.querySelector("input[name='peopleNumber']").value
        }

        axios.put('http://localhost:8080/lesson/detail/correction',
            JSON.stringify(studentUpdateDto), {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(function (response) {
                console.log(response);
                alert("수정되었습니다");
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function deleteLesson() {
        let classId = document.querySelector("input[name='classId']").value;

        axios.delete('http://localhost:8080/lesson/detail/correction/' + classId)
            .then(function (response) {
                console.log(response);
                alert("삭제되었습니다");
                window.location.href = "http://localhost:8080";
            })
            .catch(function (error) {
                console.log(error);
            });
    }
</script>
</body>
</html>
