<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Add User</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Add User</a>
        <br>
        <br>
    </div>
    <br>
    <form action="userAdd" method="post" onsubmit="return check()">
        <table class="index-content-table-add">
            <tr>
                <td width="12%">Username:</td><td><input class="index-content-table-td-add" type="text" id="username" name="username" value=""/></td>
            </tr>
            <tr>
                <td width="12%">Password:</td><td><input class="index-content-table-td-add" type="text" id="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td width="12%">Name:</td><td><input class="index-content-table-td-add" type="text" id="realName" name="realName" value=""/></td>
            </tr>
            <tr>
                <td width="12%">Gender:</td>
                <td>
                        <input name="userSex" type="radio" value="Male" checked="checked"/>&nbsp;&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="userSex" type="radio" value="Female"/>&nbsp;&nbsp;&nbsp;Female&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">Phone Number:</td><td><input class="index-content-table-td-add" type="text" id="userPhone" name="userPhone" value=""/></td>
            </tr>
            <tr>
                    <td width="12%">Notes:</td><td><textarea id="userText" name="userText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="Enter......"></textarea></td>
            </tr>
            <tr>
                <td width="12%">Types:</td>
                <td>
                        <input name="userType" type="radio" value="Admin" checked="checked"/>&nbsp;&nbsp;&nbsp;Admin&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="userType" type="radio" value="General users"/>&nbsp;&nbsp;&nbsp;General users&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
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
        if (document.getElementById("username").value.trim().length == 0) {
            alert("Username cannot be empty!");
            return false;
        }
        if (document.getElementById("password").value.trim().length == 0) {
            alert("Password cannot be empty!");
            return false;
        }
        if (document.getElementById("realName").value.trim().length == 0) {
            alert("Name cannot be empty!");
            return false;
        }
        if (document.getElementById("userPhone").value.trim().length == 0) {
            alert("Phone cannot be empty!");
            return false;
        }
        return true;
    }
</script>
</html>
