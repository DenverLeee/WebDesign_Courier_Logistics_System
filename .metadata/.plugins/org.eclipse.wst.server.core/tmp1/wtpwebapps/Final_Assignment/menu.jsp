<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<div class="index-nav">
    <div class="index-nav-frame clearfix">
        <div class="nav-line"></div>
        <div class="nav-small" tabindex="-1">
            <div class="nav-small-focus" tabindex="-1">
            </div>
            <img src="img/icon.png"/>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-pill btn-grad btn-default btn-sm" href="userList">User Page</a>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-pill btn-grad btn-default btn-sm" href="carList">Car Page</a>
        </div>
        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-pill btn-grad btn-default btn-sm" href="orderList">Order Page</a>
        </div>

        <div class="index-nav-frame-line" tabindex="-1">
            <a class="btn btn-pill btn-grad btn-default btn-sm" href="noticeList">Announcement</a>
        </div>
        <div class="index-nav-frame-line" style="float: right;" tabindex="-1">
            <a href="authLogout" class="btn btn-pill btn-grad btn-warning btn-sm">Exit</a>
        </div>
        <div class="index-nav-frame-line" style="float: right;color: #000000;width: 200px">
            Welcome!<a>${loginUser.username}</a>
        </div>
    </div>
</div>
</body>
</html>
