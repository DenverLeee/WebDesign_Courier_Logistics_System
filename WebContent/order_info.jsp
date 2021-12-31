<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Order Details</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Order Details</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>Recipient:<b>${vo.orderName}</b></td>
            </tr>
            <tr>
                <td>Recipient's Phone:<b>${vo.orderPhone}</b></td>
            </tr>
            <tr>
                <td>Recipient's Address:<b>${vo.orderAddress}</b></td>
            </tr>
            <tr>
                <td>Sender:<b>${vo.orderJiren}</b></td>
            </tr>
            <tr>
                <td>Sender's Phone:<b>${vo.orderJiphone}</b></td>
            </tr>
            <tr>
                <td>Sender's Address:<b>${vo.orderJiaddress}</b></td>
            </tr>
            <tr>
                <td>>Car No.<b>${vo.orderCarno}</b></td>
            </tr>
            <tr>
                <td>Status:
                    <b>${vo.orderStatus}</b>
                </td>
            </tr>
            <tr>
                <td>Time:<b>${vo.orderDate}</b></td>
            </tr>
            <tr>
                <td>Notes:<b>${vo.orderText}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">Back</button>
    </form>
</div>
</body>
</html>
