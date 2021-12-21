<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添加公告</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">添加公告</a>
        <br>
        <br>
    </div>
    <br>
    <form action="noticeAdd" method="post" onsubmit="return check()">
        <table class="index-content-table-add">
            <tr>
                <td width="12%">标题：</td><td><input class="index-content-table-td-add" type="text" id="noticeName" name="noticeName" value=""/></td>
            </tr>
            <tr>
                    <td width="12%">内容：</td><td><textarea id="noticeText" name="noticeText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="请输入内容......"></textarea></td>
            </tr>
            <tr>
                <td width="12%">类型：</td><td><input class="index-content-table-td-add" type="text" id="noticeType" name="noticeType" value=""/></td>
            </tr>
            <tr>
                <td width="12%">创建时间：</td><td><input class="index-content-table-td-add" type="text" id="createDate" name="createDate" value=""/></td>
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
        if (document.getElementById("noticeName").value.trim().length == 0) {
            alert("标题不能为空!");
            return false;
        }
        if (document.getElementById("noticeType").value.trim().length == 0) {
            alert("类型不能为空!");
            return false;
        }
        if (document.getElementById("createDate").value.trim().length == 0) {
            alert("创建时间不能为空!");
            return false;
        }
        return true;
    }
</script>
</html>
