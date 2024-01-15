<%--
  Created by IntelliJ IDEA.
  User: bum95
  Date: 2024-01-10
  Time: 오전 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<h1>마이페이지</h1>
<div><img src="${filePath}"></div>
<form>
    <div>userId      : <input type="text" name="userId" value="${userDto.userId}" readonly></div>
    <div>si          : <input type="text" name="si" value="${userDto.region.si}"></div>
    <div>gun         : <input type="text" name="gun" value="${userDto.region.gun}"></div>
    <div>gu          : <input type="text" name="gu" value="${userDto.region.gu}"></div>
    <div>gender      : <input type="text" name="gender" value="${userDto.gender}"></div>
    <div>age         : <input type="text" name="age" value="${userDto.age}"></div>
    <div>userName    : <input type="text" name="userName" value="${userDto.userName}"></div>
    <div>profileImage: <input type="file" name="profileImage"></div>
    <div>phoneNumber : <input type="text" name="phoneNumber" value="${userDto.phoneNumber}"></div>
  <button type="button" onclick="update()">수정</button>
    <button type="button" onclick="deleteUser()">삭제</button>
</form>

<a href="http://localhost:8080/user/student">학생 페이지</a>
<a href="http://localhost:8080/user/teacher">선생님 페이지</a>
<script type="text/javascript">
    function update() {
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
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function deleteUser() {
        let userId = document.querySelector('input[name="userId"]').value;

        axios.delete('http://localhost:8080/user/myPage/' + userId)
            .then(function (response) {
                console.log(response);
                location.href = 'http://localhost:8080';
            })
            .catch(function (error) {
                console.log(error);
            });
    }
</script>
</body>
</html>
