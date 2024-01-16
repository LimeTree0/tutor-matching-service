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
<form action="/lesson/lessonList" method="get">
    <div>
        카테고리: <input type="text" name="category">
        지역: <input type="text" name="location">
        <span>
            비대면 여부
            대면: <input type="radio" name="ftf" value="Y">
            비대면: <input type="radio" name="ftf" value="N">
        </span>
    </div>

    <button type="submit">검색</button>
</form>
<table>
    <tr>
        <td>강의명</td>
        <td>카테고리</td>
        <td>지역</td>
        <td>강의 총원</td>
        <td>대면 여부</td>
    </tr>
    <c:forEach var="lesson" items="${lessonDtoList}">
        <tr>
            <td>${lesson.teacherName}</td>
            <td>${lesson.category}</td>
            <td>${lesson.location}</td>
            <td>${lesson.peopleNumber}</td>
            <td>${lesson.ftf}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>