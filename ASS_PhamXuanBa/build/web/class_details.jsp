<%-- 
    Document   : class_details
    Created on : Jul 16, 2024, 4:44:20 PM
    Author     : bapxh
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
    <button><a href="#">Home</a></button>
    <h1>PRJ301-SE1871</h1>
    
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
   
    
<!--    <table style="max-width: 1000px;"> 
        <tr>
            <th>SName</th>
            <th>Lab1</th>
            <th>Lab2</th>
            <th>Lab3</th>
            <th>Lab4</th>
            <th>PE</th>
            <th>FE</th>
            <th>Total</th>
        </tr>
        
        <tr>
            <td>Nguyen Van A</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Nguyen Van A</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Nguyen Van B</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Nguyen Van C</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>

        <tr>
            <td>Namsklfjgs sjkgvfdj</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
            <td>6</td>
        </tr>
      </table>-->
</body>
</html>
