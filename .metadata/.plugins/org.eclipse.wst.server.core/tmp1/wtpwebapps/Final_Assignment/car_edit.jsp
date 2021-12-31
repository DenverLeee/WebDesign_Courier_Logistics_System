<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Edit Car</title>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div class="index-content">
    <div class="index-content-operation">
        <a class="info-detail">Edit Car</a>
        <br>
        <br>
    </div>
    <br>
    <form action="carEdit" method="post" onsubmit="return check()">
        <input type="hidden" id="id" name="id" value="${vo.id}"/>
        
        <table class="index-content-table-add">
            <tr>
                <td width="12%">Car No.</td><td><input class="index-content-table-td-add" type="text" id="carName" name="carName" value="${vo.carName}"/></td>
            </tr>
            <tr>
                <td width="12%">Driver's Name:</td><td><input class="index-content-table-td-add" type="text" id="carSiji" name="carSiji" value="${vo.carSiji}"/></td>
            </tr>
            <tr>
                <td width="12%">Driver's Phone:</td><td><input class="index-content-table-td-add" type="text" id="carPhone" name="carPhone" value="${vo.carPhone}"/></td>
            </tr>
            <tr>
                <td width="12%">Status:</td>
                <td>
                   <input name="carStatus" type="radio" value="In transit" ${vo.carStatus=='In transit'?'checked':''}/>&nbsp;&nbsp;&nbsp;In transit&nbsp;&nbsp;&nbsp;&nbsp;
                   <input name="carStatus" type="radio" value="Avaliable" ${vo.carStatus=='Avaliable'?'checked':''}/>&nbsp;&nbsp;&nbsp;Avaliable&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td width="12%">Notes:</td><td><textarea id="carText" name="carText" style="width: 60%; height: 100px;padding: 0px 17px;" placeholder="Enter......">${vo.carText}</textarea></td>
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
        if (document.getElementById("carName").value.trim().length == 0) {
            alert("Car No. cannot be empty!");
            return false;
        }
        if (document.getElementById("carSiji").value.trim().length == 0) {
            alert("Driver's Name cannot be empty!");
            return false;
        }
        if (document.getElementById("carPhone").value.trim().length == 0) {
            alert("Driver's Phone cannot be empty!");
            return false;
        }
        return true;
    }
</script>
</html>
