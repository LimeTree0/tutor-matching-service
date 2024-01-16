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
<form action="/lesson" method="post">
    <input name="teacherId" value="${teacherId}" readonly hidden="hidden">

    <div>
        카테고리:
        수학: <input type="checkbox" name="category" value="수학">
        과학: <input type="checkbox" name="category" value="과학">
        컴퓨터 공학: <input type="checkbox" name="category" value="컴퓨터">
    </div>

    <div>
        지역: <input type="text" name="location">
    </div>
    <div>
        강의 설명: <textarea name="description"></textarea>
    </div>
    <div>
        대면/비대면 여부:
        대면: <input type="radio" name="ftf" value="Y">
        비대면: <input type="radio" name="ftf" value="N">
    </div>
    <div>
        정원: <input type="number" name="peopleNumber">
    </div>
    <input type="submit" value="강의 등록">
</form>
</body>
</html>