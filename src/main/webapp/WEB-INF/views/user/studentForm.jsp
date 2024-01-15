<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: bum95
  Date: 2024-01-15
  Time: 오전 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<form method="post">
    <input name="userId" value="${userId}" readonly hidden="hidden">
    <input name="regionId" value="${regionId}" readonly hidden="hidden">

    <div>
        범위: <input type="text" name="range" value="${studentDto.range}">
    </div>
    <div>
        요일: <input type="text" name="yail" value="${studentDto.yail}">
    </div>
    <div>
        시간: <input type="time" name="time">
    </div>
    <div>
        카테고리:
        수학: <input type="checkbox" name="category" value="수학">
        과학: <input type="checkbox" name="category" value="과학">
        컴퓨터 공학: <input type="checkbox" name="category" value="컴퓨터">
    </div>
    <div>
        수준:
        <select name="classLevel">
            <option value="초등" selected>초등</option>
            <option value="중등">중등</option>
            <option value="고등">고등</option>
            <option value="대학">대학</option>
        </select>
    </div>
    <div>
        학력: <input type="text" name="academic" value="${studentDto.academic}">
    </div>
    <c:if test="${!isExist}">
        <input type="submit" value="학생 등록">
    </c:if>
    <c:if test="${isExist}">
        <input type="button" onclick="studentUpdate()" value="수정">
    </c:if>
    <c:if test="${isExist}">
        <input type="button" onclick="studentDelete()" value="삭제">
    </c:if>
</form>
</body>
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
            })
            .catch(function (error) {
                console.log(error);
            });
    }
</script>
</html>
