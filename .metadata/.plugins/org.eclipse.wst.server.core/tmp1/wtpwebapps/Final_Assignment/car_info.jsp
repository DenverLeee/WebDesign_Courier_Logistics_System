<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Car's Details</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Car's Details</a>
        <br>
        <br>
    </div>
    <br>
    <form>
        <table class="index-content-table-add" style="font-size: 18px;">
            <tr>
                <td>Car No.<b>${vo.carName}</b></td>
            </tr>
            <tr>
                <td>Driver's Name:<b>${vo.carSiji}</b></td>
            </tr>
            <tr>
                <td>Driver's Phone:<b>${vo.carPhone}</b></td>
            </tr>
            <tr>
                <td>Status:
                    <b>${vo.carStatus}</b>
                </td>
            </tr>
            <tr>
                <td>Comment：<b>${vo.carText}</b></td>
            </tr>
        </table>
        <br>
        <button type="button" class="btn btn-pill btn-grad btn-info btn-sm" onclick="javascript:history.back(-1);">Back</button>
    </form>
</div>
</body>
</html>
