<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改订单</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">修改订单</a>
        <br>
        <br>
    </div>
    <br>
    <form action="orderEdit" method="post" onsubmit="return check()">
        <input type="hidden" id="id" name="id" value="${vo.id}"/>
        
        <table class="index-content-table-add">
            <tr>
                <td width="12%">收件人：</td><td><input class="index-content-table-td-add" type="text" id="orderName" name="orderName" value="${vo.orderName}"/></td>
            </tr>
            <tr>
                <td width="12%">收件人手机：</td><td><input class="index-content-table-td-add" type="text" id="orderPhone" name="orderPhone" value="${vo.orderPhone}"/></td>
            </tr>
            <tr>
                <td width="12%">收件地址：</td><td><input class="index-content-table-td-add" type="text" id="orderAddress" name="orderAddress" value="${vo.orderAddress}"/></td>
            </tr>
            <tr>
                <td width="12%">寄件人：</td><td><input class="index-content-table-td-add" type="text" id="orderJiren" name="orderJiren" value="${vo.orderJiren}"/></td>
            </tr>
            <tr>
                <td width="12%">寄件人手机：</td><td><input class="index-content-table-td-add" type="text" id="orderJiphone" name="orderJiphone" value="${vo.orderJiphone}"/></td>
            </tr>
            <tr>
                <td width="12%">寄件人地址：</td><td><input class="index-content-table-td-add" type="text" id="orderJiaddress" name="orderJiaddress" value="${vo.orderJiaddress}"/></td>
            </tr>
            <tr>
                <td width="12%">车辆编号：</td><td><input class="index-content-table-td-add" type="text" id="orderCarno" name="orderCarno" value="${vo.orderCarno}"/></td>
            </tr>
            <tr>
                <td width="12%">状态：</td>
                <td>
                   <input name="orderStatus" type="radio" value="已送达" ${vo.orderStatus=='已送达'?'checked':''}/>&nbsp;&nbsp;&nbsp;已送达&nbsp;&nbsp;&nbsp;&nbsp;
                   <input name="orderStatus" type="radio" value="配送中" ${vo.orderStatus=='配送中'?'checked':''}/>&nbsp;&nbsp;&nbsp;配送中&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">订单时间：</td><td><input class="index-content-table-td-add" type="text" id="orderDate" name="orderDate" value="${vo.orderDate}"/></td>
            </tr>
            <tr>
                <td width="12%">备注：</td><td><textarea id="orderText" name="orderText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="请输入内容......">${vo.orderText}</textarea></td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        &nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-pill btn-grad btn-default btn-sm">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">取消</button>
    </form>
</div>

</body>
<script type="text/javascript">
    //提交之前进行检查，如果return false，则不允许提交
    function check() {
        //根据ID获取值
        if (document.getElementById("orderName").value.trim().length == 0) {
            alert("收件人不能为空!");
            return false;
        }
        if (document.getElementById("orderPhone").value.trim().length == 0) {
            alert("收件人手机不能为空!");
            return false;
        }
        if (document.getElementById("orderAddress").value.trim().length == 0) {
            alert("收件地址不能为空!");
            return false;
        }
        if (document.getElementById("orderJiren").value.trim().length == 0) {
            alert("寄件人不能为空!");
            return false;
        }
        if (document.getElementById("orderJiphone").value.trim().length == 0) {
            alert("寄件人手机不能为空!");
            return false;
        }
        if (document.getElementById("orderJiaddress").value.trim().length == 0) {
            alert("寄件人地址不能为空!");
            return false;
        }
        if (document.getElementById("orderCarno").value.trim().length == 0) {
            alert("车辆编号不能为空!");
            return false;
        }
        if (document.getElementById("orderDate").value.trim().length == 0) {
            alert("订单时间不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
