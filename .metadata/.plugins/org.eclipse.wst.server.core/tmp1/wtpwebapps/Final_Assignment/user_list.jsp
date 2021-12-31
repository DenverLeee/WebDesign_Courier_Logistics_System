<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>User Management</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">User Management</a>
        <br>
        <br>
    </div>
    <br>
    <div class="index-content-operation">
        <button class="btn btn-pill btn-grad btn-default btn-sm" <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if> onclick="window.location.href='user_add.jsp'">Add</button>
        <div class="index-content-operation-search"><input id="search_keyword" placeholder="Name" type="text" name="search_keyword"/><input type="hidden" id="searchColumn" name="searchColumn" value="real_name"/><button class="btn btn-pill btn-grad btn-default btn-sm" onclick="searchList()">Search</button></div>
    </div>
    <br>
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr class="index-content-table-th">
            <th>Username</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Phone Number</th>
            <th>Type</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="vo">
            <tr class="index-content-table-td">
                <td>${vo.username}</td>
                <td>${vo.realName}</td>
                <td>${vo.userSex}</td>
                <td>${vo.userPhone}</td>
                <td>${vo.userType}</td>
                <td>
                    <button class="btn btn-pill btn-grad btn-info btn-sm" style="padding: 0px 1px;" onclick="window.location.href='userGet?id=${vo.id}'">Details</button>&nbsp;
                    <button class="btn btn-pill btn-grad btn-warning btn-sm" style="padding: 0px 1px;"
                            <c:if test="${loginUser.userType != 'Admin' && vo.id != loginUser.id}">disabled="disabled" title="Unauthorized!"</c:if>
                    onclick="window.location.href='userEditPre?id=${vo.id}'">Edit</button>&nbsp;
                    <button class="btn btn-pill btn-grad btn-primary btn-sm" style="padding: 0px 1px;" <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if> onclick="if(window.confirm('Delete：${vo.realName}？'))window.location.href='userDelete?id=${vo.id}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="float: right;padding-right: 10px;color: #515151;"><jsp:include page="split.jsp"/></div>
</div>
</body>
<script>
    function searchList() {
        window.location.href = "userList?searchColumn="+document.getElementById("searchColumn").value+"&keyword=" + document.getElementById("search_keyword").value;
    }
</script>
</html>
