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
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

<form>
    <div>
        사용자 아이디: userId <input type="text" name="userId">
    </div>
    <div>
        password : 비밀번호 <input type="password" name="password">
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
        phoneNumber : 전화번호 <input type="text" name="phoneNumber">
        <button type="button" onclick="sendSms()">인증번호 전송</button>
    </div>
    <div>
        certificationCode : 인증번호 <input type="text" id="certificationCode">
        <button type="button" onclick="certificate()">인증 확인</button>
    </div>
    <div>
        <input type="button" onclick="join()" value="회원가입">
    </div>
</form>
<script type="text/javascript">

    let isCertificate = false;

    function sendSms() {
        const phoneNumber = document.querySelector("input[name='phoneNumber']").value;

        let formData = new FormData();

        formData.append("phoneNumber", phoneNumber);

        axios.post("/user/sms/verificationCode", formData)
            .then(function (response) {
            alert(response.data);
        }).catch(function (error) {
            alert(error);
        });
    }

    function certificate() {
        const phoneNumber = document.querySelector("input[name='phoneNumber']").value;
        const certificationCode = document.querySelector("input[id='certificationCode']").value;

        let formData = new FormData();

        formData.append("phoneNumber", phoneNumber);
        formData.append("certificationCode", certificationCode);

        axios.post("/user/sms/certificate", formData)
            .then(function (response) {
            alert(response.data);
                isCertificate = true;
        }).catch(function (error) {
            alert(error);
        });
    }

    function join() {

        if (!isCertificate) {
            alert("인증번호를 확인해주세요");
            return;
        }

        let formData = new FormData();
        formData.append("userId", document.querySelector('input[name="userId"]').value);
        formData.append("password", document.querySelector('input[name="password"]').value);
        formData.append("si", document.querySelector('input[name="si"]').value);
        formData.append("gun", document.querySelector('input[name="gun"]').value);
        formData.append("gu", document.querySelector('input[name="gu"]').value);
        formData.append("gender", document.querySelector('input[name="gender"]:checked').value);
        formData.append("age", document.querySelector('input[name="age"]').value);
        formData.append("userName", document.querySelector('input[name="userName"]').value);
        formData.append("phoneNumber", document.querySelector('input[name="phoneNumber"]').value);

        axios.post("/user/join", formData)
            .then(function (response) {
            alert(response.data);
        }).catch(function (error) {
            alert(error);
        });
    }
</script>


</body>
</html>
