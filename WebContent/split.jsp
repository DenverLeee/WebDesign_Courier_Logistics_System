<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
Total：${pageBean.totalRecord}&nbsp;&nbsp;&nbsp;&nbsp;Pages：${pageBean.totalPage }&nbsp;&nbsp;&nbsp;&nbsp;Pages${pageBean.pageNum}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=1">First</a>
<c:if test="${pageBean.pageNum ==1 && pageBean.totalPage > 1}">
    <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
        <c:if test="${pageBean.pageNum == i}">
            ${i}
        </c:if>
        <c:if test="${pageBean.pageNum != i}">
            <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${pageBean.pageNum+1}">Next</a>
</c:if>


<c:if test="${pageBean.pageNum > 1 && pageBean.pageNum < pageBean.totalPage}">
    <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${pageBean.pageNum-1}">Previous</a>
    <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
        <c:if test="${pageBean.pageNum == i}">
            ${i}
        </c:if>
        <c:if test="${pageBean.pageNum != i}">
            <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${pageBean.pageNum+1}">Next</a>
</c:if>


<c:if test="${pageBean.pageNum == pageBean.totalPage && pageBean.totalPage > 1}">
    <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${pageBean.pageNum-1}">Previous</a>
    <c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" var="i">
        <c:if test="${pageBean.pageNum == i}">
            ${i}
        </c:if>
        <c:if test="${pageBean.pageNum != i}">
            <a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${i}">${i}</>
        </c:if>
    </c:forEach>
</c:if>

<a href="${pageBean.servlet}?action=list&searchColumn=${pageBean.searchColumn}&keyword=${pageBean.keyword}&pageNum=${pageBean.totalPage}">Last</a>
