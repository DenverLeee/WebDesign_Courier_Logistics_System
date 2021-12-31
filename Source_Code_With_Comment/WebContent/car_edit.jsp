<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改车辆</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">修改车辆</a>
        <br>
        <br>
    </div>
    <br>
    <form action="carEdit" method="post" onsubmit="return check()">
        <input type="hidden" id="id" name="id" value="${vo.id}"/>
        
        <table class="index-content-table-add">
            <tr>
                <td width="12%">车辆编号：</td><td><input class="index-content-table-td-add" type="text" id="carName" name="carName" value="${vo.carName}"/></td>
            </tr>
            <tr>
                <td width="12%">司机姓名：</td><td><input class="index-content-table-td-add" type="text" id="carSiji" name="carSiji" value="${vo.carSiji}"/></td>
            </tr>
            <tr>
                <td width="12%">司机手机：</td><td><input class="index-content-table-td-add" type="text" id="carPhone" name="carPhone" value="${vo.carPhone}"/></td>
            </tr>
            <tr>
                <td width="12%">车辆状态：</td>
                <td>
                   <input name="carStatus" type="radio" value="在途" ${vo.carStatus=='在途'?'checked':''}/>&nbsp;&nbsp;&nbsp;在途&nbsp;&nbsp;&nbsp;&nbsp;
                   <input name="carStatus" type="radio" value="空闲" ${vo.carStatus=='空闲'?'checked':''}/>&nbsp;&nbsp;&nbsp;空闲&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">备注：</td><td><textarea id="carText" name="carText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="请输入内容......">${vo.carText}</textarea></td>
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
        if (document.getElementById("carName").value.trim().length == 0) {
            alert("车辆编号不能为空!");
            return false;
        }
        if (document.getElementById("carSiji").value.trim().length == 0) {
            alert("司机姓名不能为空!");
            return false;
        }
        if (document.getElementById("carPhone").value.trim().length == 0) {
            alert("司机手机不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
