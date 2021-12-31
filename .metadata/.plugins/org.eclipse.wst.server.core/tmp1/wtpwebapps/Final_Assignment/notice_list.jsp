<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Announcement Management</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Announcement Management</a>
        <br>
        <br>
    </div>
    <br>
    <div class="index-content-operation">
        <button class="btn btn-pill btn-grad btn-default btn-sm" <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if> onclick="window.location.href='notice_add.jsp'">Add</button>
        <div class="index-content-operation-search"><input id="search_keyword" placeholder="Title" type="text" name="search_keyword"/><input type="hidden" id="searchColumn" name="searchColumn" value="notice_name"/><button class="btn btn-pill btn-grad btn-default btn-sm" onclick="searchList()">Search</button></div>
    </div>
    <br>
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr class="index-content-table-th">
            <th>Title</th>
            <th>Type</th>
            <th>Time</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="vo">
            <tr class="index-content-table-td">
                <td>${vo.noticeName}</td>
                <td>${vo.noticeType}</td>
                <td>${vo.createDate}</td>
                <td>
                    <button class="btn btn-pill btn-grad btn-info btn-sm" style="padding: 0px 1px;" onclick="window.location.href='noticeGet?id=${vo.id}'">Details</button>&nbsp;
                    <button class="btn btn-pill btn-grad btn-warning btn-sm" style="padding: 0px 1px;"
                            <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="No Authority！！！"</c:if>
                    onclick="window.location.href='noticeEditPre?id=${vo.id}'">Edit</button>&nbsp;
                    <button class="btn btn-pill btn-grad btn-primary btn-sm" style="padding: 0px 1px;" <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if> onclick="if(window.confirm('Delete：${vo.noticeName}？'))window.location.href='noticeDelete?id=${vo.id}'">Delete</button>
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
        window.location.href = "noticeList?searchColumn="+document.getElementById("searchColumn").value+"&keyword=" + document.getElementById("search_keyword").value;
    }
</script>
</html>
