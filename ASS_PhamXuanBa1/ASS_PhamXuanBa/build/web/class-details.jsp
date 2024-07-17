<%-- 
    Document   : class-details
    Created on : 15 Jul 2024, 23:01:02
    Author     : baophan
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
    </head>
    <body>
    
    
    
    <h2 style="margin-right: 100px;">Chọn bài kiểm tra để nhập điểm:</h2>
    <c:if test="${requestScope.exams eq null}">
            <c:if test="${requestScope.courses.size() > 0}">
            <form action="lecturer" method="POST">
                <input type="hidden" name="lid" value="${param.lid}"/>
                course: <select name="cid">
                    <c:forEach items="${requestScope.courses}" var="c">
                        <option value="${c.id}">
                            ${c.name}
                        </option>
                    </c:forEach>
                </select>
                <input type="submit" value="view"/>
            </form>
                </c:if>
        </c:if>
        <c:if test="${requestScope.exams ne null}">
            <form action="take" method="get">
                <input type="hidden" name="cid" value="${param.cid}"/>
                <c:forEach items="${requestScope.exams}" var="e">
                    <input type="checkbox" name="eid" value="${e.id}" /> 
                    ${e.assessment.name}-(${e.from}:${e.assessment.weight}%) <br/>
                </c:forEach>
                <input type="submit" value="take"/>
            </form>
            
        </c:if>
   
    

</body>
</html>
