<%-- 
    Document   : add-mark
    Created on : 15 Jul 2024, 22:59:43
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
    
    
    
    <h2 style="margin-right: 100px;">Nhập điểm :</h2>
    <h4>${mess}</h4>
    <form action="take" method="post">
        <input type="hidden" name="eid" value="${eid}">
        <input type="hidden" name="cid" value="${cid}">
        <table style="max-width: 1000px;"> 
        <tr>
            <th>SName</th>
            <th>Score</th>
            
        </tr>
        
        
        
        
<c:forEach var="s" items="${studentList}">
    <tr>
        <td>${s.name}</td> 
        
        <td><input type="text" name="score" value="${s.grades[0].score}"></td> 
        <td style="display:none;"><input type="hidden" name="sid" value="${s.id}"></td>
</c:forEach>


        
      </table>
        <button type="submit" style="padding: 7px 40px;margin-top: 20px;">Lưu</button>
    </form>
      
</body>
</html>
