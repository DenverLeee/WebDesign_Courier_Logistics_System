<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script type="text/javascript">
        let alert_msg = '${alert_msg}';
        if(alert_msg != null && alert_msg.trim() != ''){
            window.alert(alert_msg) ;
        }
    </script>
</head>
<body>
<h1 style="text-align: center;font-size: 40px;padding-top:1px;font-weight: 700;color:#000000;text-shadow: 2px 3px #FFFFFF;">Delivery Management System</h1>
<form action="authRegister" method="post" onsubmit="return check()">
    <div class="login">
        <div class="login-top">
            <a href="login.jsp" style="color: black;text-decoration: none;padding-left: 63px;">Login</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="#" style="color:dodgerblue ;text-decoration: none;">Register</a>
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="img/name.png"/></div>
            <div class="login-center-input">
                <input type="text" id="username" name="username" value="" placeholder="Username"
                       onfocus="this.placeholder=''" onblur="this.placeholder='Username'"/>
            </div>
        </div>
        <br>
        <br>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="img/password.png"/></div>
            <div class="login-center-input">
                <input type="password" id="password" name="password" value="" placeholder="Password"
                       onfocus="this.placeholder=''" onblur="this.placeholder='Password'"/>
            </div>
        </div>
        <br>
        <br>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="img/password.png"/></div>
            <div class="login-center-input">
                <input type="password" id="password2" name="password2" value="" placeholder="Confirm Password"
                       onfocus="this.placeholder=''" onblur="this.placeholder='Confirm Password'"/>
            </div>
        </div>
        <br>
        <button type="submit" class="login-button">Register</button>
    </div>
</form>
</body>
<script type="text/javascript">
    function check() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var password2 = document.getElementById("password2").value;
        if (username == "") {
            alert("Username cannot be empty!");
            return false;
        }
        if (password == "") {
            alert("Password cannot be empty!");
            return false;
        }
        if (password2 != password) {
            alert("Inconsistent password input!");
            return false;
        }
        return true;
    }
</script>
</html>
