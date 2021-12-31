<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>User Details</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">User Details</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>Username:<b>${vo.username}</b></td>
            </tr>
            <tr>
                <td>Name<b>${vo.realName}</b></td>
            </tr>
            <tr>
                <td>Gender:
                    <b>${vo.userSex}</b>
                </td>
            </tr>
            <tr>
                <td>Phone number:<b>${vo.userPhone}</b></td>
            </tr>
            <tr>
                <td>Notes:<b>${vo.userText}</b></td>
            </tr>
            <tr>
                <td>Types
                    <b>${vo.userType}</b>
                </td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">Back</button>
    </form>
</div>
</body>
</html>
