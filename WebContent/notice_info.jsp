<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Announcement Management</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Announcement Management</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>Title:<b>${vo.noticeName}</b></td>
            </tr>
            <tr>
                <td>Content:<b>${vo.noticeText}</b></td>
            </tr>
            <tr>
                <td>Type:<b>${vo.noticeType}</b></td>
            </tr>
            <tr>
                <td>Time:<b>${vo.createDate}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">Back</button>
    </form>
</div>
</body>
</html>
