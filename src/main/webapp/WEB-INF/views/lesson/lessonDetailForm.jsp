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
    <input name="classId" value="${lessonDto.classId}" readonly hidden="hidden">

    <div>
        강의 설명: <textarea name="description">
        ${lessonDto.description}
    </textarea>
    </div>
    <div>
        대면/비대면 여부:
        대면: <input type="radio" name="ftf" value="Y"
                   <c:if test="${lessonDto.ftf == 'Y'}">checked="checked"</c:if>>
        비대면: <input type="radio" name="ftf" value="N"
                    <c:if test="${lessonDto.ftf == 'N'}">checked="checked"</c:if>>
    </div>
    <div>
        정원: <input type="number" name="peopleNumber" value="${lessonDto.peopleNumber}">
    </div>
    <input type="button" onclick="updateLesson()" value="수정">
    <input type="button" onclick="deleteLesson()" value="삭제">
</form>
<script type="text/javascript">
    function updateLesson() {
        let studentUpdateDto = {
            classId: document.querySelector("input[name='classId']").value,
            description: document.querySelector("textarea[name='description']").value,
            ftf: document.querySelector("input[name='ftf']:checked").value,
            peopleNumber: document.querySelector("input[name='peopleNumber']").value
        }

        axios.put('http://localhost:8080/lesson/detail',
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

    function deleteLesson() {
        let classId = document.querySelector("input[name='classId']").value;

        axios.delete('http://localhost:8080/lesson/detail/' + classId)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
</script>
</body>
</html>