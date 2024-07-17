<%-- 
    Document   : student-home
    Created on : 15 Jul 2024, 23:03:09
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
    <h1>Báo cáo điểm của ${user.displayName}</h1>
    <table style="max-width: 1000px;"> 
        <tr>
           
            <th>Subject</th>
            <th>Semester</th>
            <th>Everage</th>
            <th>Status</th>
            
        </tr>
        <c:forEach var="s" items="${list}">
            
            <tr>
            
            <td>${s.getCname()}</td>
            <td>${s.getSeason()} - ${s.getYear()}</td>
            <td>${s.getEverage()}</td>
            <td>${s.getEverage()>5?"pass":"not pass"}</td>
           
            </tr>
            
            
        </c:forEach>
        
        
      </table>
     
</body>
</html>
