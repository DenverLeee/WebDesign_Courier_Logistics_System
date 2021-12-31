<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Edit Order</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Edit Order</a>
        <br>
        <br>
    </div>
    <br>
    <form action="orderEdit" method="post" onsubmit="return check()">
        <input type="hidden" id="id" name="id" value="${vo.id}"/>
        
        <table class="index-content-table-add">
            <tr>
                <td width="12%">Recipient:</td><td><input class="index-content-table-td-add" type="text" id="orderName" name="orderName" value="${vo.orderName}"/></td>
            </tr>
            <tr>
                <td width="12%">Recipient's Phone:</td><td><input class="index-content-table-td-add" type="text" id="orderPhone" name="orderPhone" value="${vo.orderPhone}"/></td>
            </tr>
            <tr>
                <td width="12%">Recipient's Address:</td><td><input class="index-content-table-td-add" type="text" id="orderAddress" name="orderAddress" value="${vo.orderAddress}"/></td>
            </tr>
            <tr>
                <td width="12%">Sender:</td><td><input class="index-content-table-td-add" type="text" id="orderJiren" name="orderJiren" value="${vo.orderJiren}"/></td>
            </tr>
            <tr>
                <td width="12%">Sender's Phone:</td><td><input class="index-content-table-td-add" type="text" id="orderJiphone" name="orderJiphone" value="${vo.orderJiphone}"/></td>
            </tr>
            <tr>
                <td width="12%">Sender's Address:</td><td><input class="index-content-table-td-add" type="text" id="orderJiaddress" name="orderJiaddress" value="${vo.orderJiaddress}"/></td>
            </tr>
            <tr>
                <td width="12%">Car No.</td><td><input class="index-content-table-td-add" type="text" id="orderCarno" name="orderCarno" value="${vo.orderCarno}"/></td>
            </tr>
            <tr>
                <td width="12%">Status</td>
                <td>
                   <input name="orderStatus" type="radio" value="Delivered" ${vo.orderStatus=='Delivered'?'checked':''}/>&nbsp;&nbsp;&nbsp;Delivered&nbsp;&nbsp;&nbsp;&nbsp;
                   <input name="orderStatus" type="radio" value="Delivering." ${vo.orderStatus=='Delivering.'?'checked':''}/>&nbsp;&nbsp;&nbsp;Delivering.&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">Order Date：</td><td><input class="index-content-table-td-add" type="text" id="orderDate" name="orderDate" value="${vo.orderDate}"/></td>
            </tr>
            <tr>
                <td width="12%">Comment：</td><td><textarea id="orderText" name="orderText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="Enter......">${vo.orderText}</textarea></td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        &nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-pill btn-grad btn-default btn-sm">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">Cancel</button>
    </form>
</div>

</body>
<script type="text/javascript">
    function check() {
        if (document.getElementById("orderName").value.trim().length == 0) {
            alert("Recipient cannot be empty!");
            return false;
        }
        if (document.getElementById("orderPhone").value.trim().length == 0) {
            alert("Recipient's Phone cannot be empty!");
            return false;
        }
        if (document.getElementById("orderAddress").value.trim().length == 0) {
            alert("Recipient's Address cannot be empty!");
            return false;
        }
        if (document.getElementById("orderJiren").value.trim().length == 0) {
            alert("Sender cannot be empty!");
            return false;
        }
        if (document.getElementById("orderJiphone").value.trim().length == 0) {
            alert("Sender's Phone cannot be empty!");
            return false;
        }
        if (document.getElementById("orderJiaddress").value.trim().length == 0) {
            alert("Sender's Address cannot be empty!");
            return false;
        }
        if (document.getElementById("orderCarno").value.trim().length == 0) {
            alert("Car No. cannot be empty!");
            return false;
        }
        if (document.getElementById("orderDate").value.trim().length == 0) {
            alert("Time cannot be empty!");
            return false;
        }
        return true;
    }
</script>
</html>
