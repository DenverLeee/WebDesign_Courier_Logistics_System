<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login-page</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script type="text/javascript">
        let alert_msg = '${alert_msg}';
        if (alert_msg != null && alert_msg.trim() != '') {
            window.alert(alert_msg);
        }
    </script>
</head>
<body>
<h1 style="text-align: center;font-size: 40px;padding-top:1px;font-weight: 700;color:#000000;text-shadow: 2px 3px #FFFFFF;">Delivery Management System</h1>
<form action="authLogin" method="post" onsubmit="return check()">
    <input type="hidden" name="forwardPage" id="forwardPage" value="userList"/>
    <div class="login">
        <div class="login-top">
            <a href="#" style="color:dodgerblue ;text-decoration: none;padding-left: 63px;">Login</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a
                style="color: black;text-decoration: none;" href="register.jsp">Register</a>
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="img/name.png"/></div>
            <div class="login-center-input">
                <input type="text" id="username" name="username"  placeholder="Enter UserName" onfocus="this.placeholder=''" onblur="this.placeholder='Enter UserName'"/>
            </div>
        </div>
        <br>
        <br>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="img/password.png"/></div>
            <div class="login-center-input">
                <input type="password" id="password" name="password"  placeholder="Password" onfocus="this.placeholder=''" onblur="this.placeholder='Password'"/>
            </div>
        </div>
        <br>
        <br>
		
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="img/password.png"/></div>
            <div class="login-center-input">
                <input type="text" id="validationCode" name="validationCode"  style="font-size: 10px;width: 90px;margin-top: 0px;" placeholder="Enter the verification code"/>
                <img id="img_validation_code" src="authValidationCode" onclick="refresh()" style="height: 30px;"/>
            </div>
        </div>
        <br>
		
        <button type="submit" class="login-button">Login</button>
    </div>
</form>
</body>
<script type="text/javascript">
    function check() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if (username == "") {
            alert("Username cannot be empty!");
            return false;
        }
        if (password == "") {
            alert("Password cannot be empty!");
            return false;
        }
        return true;
    }
    function refresh() {
        var img = document.getElementById("img_validation_code")
        img.src = "authValidationCode?r=" + Math.random();
    }
</script>
</html>
