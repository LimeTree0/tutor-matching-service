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
    <form method="post">
        <input name="userId" value="${userId}" readonly hidden>
        <input name="regionId" value="${regionId}" readonly hidden>

        <div class="form-group">
            <label>범위:</label>
            <input type="text" class="form-control" name="range" value="${studentDto.range}">
        </div>

        <div class="form-group">
            <label>요일:</label>
            <input type="text" class="form-control" name="yail" value="${studentDto.yail}">
        </div>

        <div class="form-group">
            <label>시간:</label>
            <input type="time" class="form-control" name="time">
        </div>

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
            <label>수준:</label>
            <select name="classLevel" class="form-control">
                <option value="초등" selected>초등</option>
                <option value="중등">중등</option>
                <option value="고등">고등</option>
                <option value="대학">대학</option>
            </select>
        </div>

        <div class="form-group">
            <label>학력:</label>
            <input type="text" class="form-control" name="academic" value="${studentDto.academic}">
        </div>

        <c:if test="${!isExist}">
            <input type="submit" class="btn btn-primary" value="학생 등록">
        </c:if>
        <c:if test="${isExist}">
            <button type="button" class="btn btn-secondary" onclick="studentUpdate()">수정</button>
        </c:if>
        <c:if test="${isExist}">
            <button type="button" class="btn btn-danger" onclick="studentDelete()">삭제</button>
        </c:if>
    </form>

    <h1 class="mb-4">나의 수업 목록</h1>
    <c:if test="${empty orderDtoList}">
        <div class="alert alert-info">등록된 수업이 없습니다.</div>
    </c:if>
    <c:if test="${not empty orderDtoList}">
        <table class="table">
            <thead>
            <tr>
                <th>강의명</th>
                <th>강의 시작일</th>
                <th>진행도</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orderDtoList}">
                <tr>
                    <td>${order.lessonName}</td>
                    <td>${order.firstDate}</td>
                    <td>${order.progress}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function studentUpdate() {
        let studentUpdateDto = {
            userId: document.querySelector("input[name='userId']").value,
            regionId: document.querySelector("input[name='regionId']").value,
            range: document.querySelector("input[name='range']").value,
            yail: document.querySelector("input[name='yail']").value,
            time: document.querySelector("input[name='time']").value,
            category: Array.from(document.querySelectorAll("input[name='category']:checked")).map(function (checkbox) {
                return checkbox.value;
            }) ,
            classLevel: document.querySelector("select[name='classLevel']").value,
            academic: document.querySelector("input[name='academic']").value,
        }

        axios.put('http://localhost:8080/user/student',
            JSON.stringify(studentUpdateDto), {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(function (response) {
                console.log(response);
                alert("수정되었습니다.");
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function studentDelete() {
        let userId = document.querySelector("input[name='userId']").value;

        axios.delete('http://localhost:8080/user/student/' + userId)
            .then(function (response) {
                console.log(response);
                alert("삭제되었습니다.");
                window.location.href = "http://localhost:8080";
            })
            .catch(function (error) {
                console.log(error);
            });
    }
</script>
</body>
</html>