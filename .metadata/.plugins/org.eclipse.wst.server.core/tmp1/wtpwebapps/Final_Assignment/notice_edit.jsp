<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Edit Announcement</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Edit Announcement</a>
        <br>
        <br>
    </div>
    <br>
    <form action="noticeEdit" method="post" onsubmit="return check()">
        <input type="hidden" id="id" name="id" value="${vo.id}"/>
        
        <table class="index-content-table-add">
            <tr>
                <td width="12%">Title:</td><td><input class="index-content-table-td-add" type="text" id="noticeName" name="noticeName" value="${vo.noticeName}"/></td>
            </tr>
            <tr>
                <td width="12%">Content:</td><td><textarea id="noticeText" name="noticeText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="Enter......">${vo.noticeText}</textarea></td>
            </tr>
            <tr>
                <td width="12%">Type:</td><td><input class="index-content-table-td-add" type="text" id="noticeType" name="noticeType" value="${vo.noticeType}"/></td>
            </tr>
            <tr>
                <td width="12%">Time:</td><td><input class="index-content-table-td-add" type="text" id="createDate" name="createDate" value="${vo.createDate}"/></td>
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
        if (document.getElementById("noticeName").value.trim().length == 0) {
            alert("Title cannot be empty!");
            return false;
        }
        if (document.getElementById("noticeType").value.trim().length == 0) {
            alert("Type cannot be empty!");
            return false;
        }
        if (document.getElementById("createDate").value.trim().length == 0) {
            alert("Time cannot be empty!");
            return false;
        }
        return true;
    }
</script>
</html>
