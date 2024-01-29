<%--템플릿입니다--%>
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
    <div class="container mt-4">
        <div class="card">
            <div class="card-body">
                <p hidden="hidden" id="lessonId">${lessonDto.classId}</p>
                <h5 class="card-title">강의명: <span id="lessonName">${lessonDto.lessonName}</span></h5>
                <h5 class="card-title">강사명: ${lessonDto.teacherName}</h5>
                <p hidden="hidden" id="teacherId">  ${lessonDto.teacherId}</p>
                <p class="card-text"><strong>카테고리:</strong> ${lessonDto.category}</p>
                <p class="card-text"><strong>지역:</strong> ${lessonDto.location}</p>
                <p class="card-text"><strong>총원:</strong> ${lessonDto.peopleNumber}</p>
                <p class="card-text"><strong>가격:</strong> <span id="price">${lessonDto.price}</span></p>
                <p class="card-text"><strong>대면 여부:</strong> ${lessonDto.ftf}</p>
                <p class="card-text"><strong>강의 설명:</strong> ${lessonDto.description}</p>
                <button class="btn btn-primary" value="문의하기">문의하기</button>
                <button class="btn btn-primary" value="결제하기" onclick="payReady()">결제하기</button>
            </div>
        </div>
    </div>

    <div class="container mt-5">
        <form action="localhost:8080/review" method="POST" class="mb-5">
            <div class="form-group">
                <label for="reviewTextarea">리뷰</label>
                <textarea class="form-control" id="reviewTextarea" name="review" cols="50" rows="5"></textarea>
            </div>
            <div class="form-group">
                <label for="gradeSelect">별점</label>
                <select class="form-control" id="gradeSelect" name="grade">
                    <option value="1">1점</option>
                    <option value="2">2점</option>
                    <option value="3">3점</option>
                    <option value="4">4점</option>
                    <option value="5" selected>5점</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary" onclick="sendReview()">리뷰 작성</button>
        </form>

        <!-- 리뷰 목록 -->
        <c:forEach var="review" items="${reviewDtoList}">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">${review.userId} 학생</h5>
                    <p class="card-text">리뷰: ${review.review}</p>
                    <p class="card-text"><small class="text-muted">별점: ${review.grade}</small></p>

                    <c:if test="${review.userId == currentUserId}">
                        <span hidden="hidden" id="reviewId">${review.reviewId}</span>
                        <span hidden="hidden" id="studentId">${review.studentId}</span>
                        <button class="btn btn-primary" value="삭제하기" onclick="deleteReview()">삭제하기</button>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="footer">
    <p>저작권 © 2024 홈페이지 이름. 모든 권리 보유.</p>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function payReady() {
        let formData = new FormData();
        formData.append("classId", document.getElementById("lessonId").textContent);
        formData.append("lessonName", document.getElementById("lessonName").textContent);
        formData.append("price", document.getElementById("price").textContent);
        formData.append("teacherId", document.getElementById("teacherId").textContent);
        formData.append("progress", "0");
        formData.append("lessonDate", "30");

        console.log(formData);

        axios.post('http://localhost:8080/order', formData)
            .then(function (response) {
                console.log("결제 준비");
                console.log(response.data.next_redirect_pc_url);
                console.log(response.data);
                console.log(response);
                window.open(response.data, "_blank");
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function sendReview() {
        let formData = new FormData();
        formData.append("classId", document.getElementById("lessonId").textContent);
        formData.append("review", document.querySelector("textarea[name='review']").value);
        formData.append("grade", document.querySelector("select[name='grade']").value);

        axios.post('http://localhost:8080/review', formData)
            .then(function (response) {
                console.log(response);
                location.href = "http://localhost:8080/lesson/detail/" + document.getElementById("lessonId").textContent;
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function deleteReview() {
        axios.delete('http://localhost:8080/review/' + document.getElementById("studentId").textContent + '/' + document.getElementById("reviewId").textContent)
            .then(function (response) {
                console.log(response);
                location.href = "http://localhost:8080/lesson/detail/" + document.getElementById("lessonId").textContent;
            })
            .catch(function (error) {
                console.log(error);
            });
    }
</script>
</body>
</html>
