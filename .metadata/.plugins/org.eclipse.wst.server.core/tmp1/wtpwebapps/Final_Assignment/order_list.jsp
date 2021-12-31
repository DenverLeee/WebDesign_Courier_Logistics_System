<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Order Management</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Order Management</a>
        <br>
        <br>
    </div>
    <br>
    <div class="index-content-operation">
        <button class="btn btn-pill btn-grad btn-default btn-sm" <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if> onclick="window.location.href='order_add.jsp'">Add</button>
        <div class="index-content-operation-search"><input id="search_keyword" placeholder="Receiver" type="text" name="search_keyword"/><input type="hidden" id="searchColumn" name="searchColumn" value="order_name"/><button class="btn btn-pill btn-grad btn-default btn-sm" onclick="searchList()">Search</button></div>
    </div>
    <br>
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr class="index-content-table-th">
            <th>Recipient</th>
            <th>Recipient's Phone</th>
            <th>Recipient's Address</th>
            <th>Sender</th>
            <th>Sender's Phone</th>
            <th>Sender's Address</th>
            <th>Car No.</th>
            <th>Status</th>
            <th>Time</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="vo">
            <tr class="index-content-table-td">
                <td>${vo.orderName}</td>
                <td>${vo.orderPhone}</td>
                <td>${vo.orderAddress}</td>
                <td>${vo.orderJiren}</td>
                <td>${vo.orderJiphone}</td>
                <td>${vo.orderJiaddress}</td>
                <td>${vo.orderCarno}</td>
                <td>${vo.orderStatus}</td>
                <td>${vo.orderDate}</td>
                <td>
                    <button class="btn btn-pill btn-grad btn-info btn-sm" style="padding: 0px 1px;" onclick="window.location.href='orderGet?id=${vo.id}'">Details</button>&nbsp;
                    <button class="btn btn-pill btn-grad btn-warning btn-sm" style="padding: 0px 1px;"
                            <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if>
                    onclick="window.location.href='orderEditPre?id=${vo.id}'">Edit</button>&nbsp;
                    <button class="btn btn-pill btn-grad btn-primary btn-sm" style="padding: 0px 1px;" <c:if test="${loginUser.userType != 'Admin'}">disabled="disabled" title="Unauthorized!"</c:if> onclick="if(window.confirm('Delete：${vo.orderName}？'))window.location.href='orderDelete?id=${vo.id}'">Delete</button>
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
        window.location.href = "orderList?searchColumn="+document.getElementById("searchColumn").value+"&keyword=" + document.getElementById("search_keyword").value;
    }
</script>
</html>
