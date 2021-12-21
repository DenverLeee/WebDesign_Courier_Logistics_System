<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>订单详情</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">订单详情</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>收件人：<b>${vo.orderName}</b></td>
            </tr>
            <tr>
                <td>收件人手机：<b>${vo.orderPhone}</b></td>
            </tr>
            <tr>
                <td>收件地址：<b>${vo.orderAddress}</b></td>
            </tr>
            <tr>
                <td>寄件人：<b>${vo.orderJiren}</b></td>
            </tr>
            <tr>
                <td>寄件人手机：<b>${vo.orderJiphone}</b></td>
            </tr>
            <tr>
                <td>寄件人地址：<b>${vo.orderJiaddress}</b></td>
            </tr>
            <tr>
                <td>车辆编号：<b>${vo.orderCarno}</b></td>
            </tr>
            <tr>
                <td>状态：
                    <b>${vo.orderStatus}</b>
                </td>
            </tr>
            <tr>
                <td>订单时间：<b>${vo.orderDate}</b></td>
            </tr>
            <tr>
                <td>备注：<b>${vo.orderText}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">返回</button>
    </form>
</div>
</body>
</html>
