<%--
  Created by IntelliJ IDEA.
  User: bum95
  Date: 2024-01-10
  Time: 오전 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/join" method="post">
    <div>
        사용자 아이디: userId <input type="text" name="userId">
    </div>
    <div>
        si : 시 <input type="text" name="si">
    </div>
    <div>
        gun : 군 <input type="text" name="gun">
    </div>
    <div>
        gu : 구 <input type="text" name="gu">
    </div>
    <div>
        password : 비밀번호 <input type="password" name="password">
    </div>
    <div>
        gender : 성별
        <input type="radio" name="gender" value="M"> 남자
        <input type="radio" name="gender" value="W"> 여자
    </div>
    <div>
        age : 나이 <input type="text" name="age" value="20">
    </div>
    <div>
        userName : 사용자 이름 <input type="text" name="userName">
    </div>
    <div>
        profileImage : 프로필 <input type="text" name="profileImage" value="profile">
    </div>
    <div>
        phoneNumber : 전화번호 <input type="text" name="phoneNumber">
    </div>
    <div>
        <input type="submit" value="회원가입">
    </div>
</form>



</body>
</html>
