<%-- 
    Document   : home-lecture
    Created on : Jul 16, 2024, 4:53:53 AM
    Author     : bapxh
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h2>
        Fap-lecture
    </h2>
    <h3>
        Giao vien ${displayName}
    </h3>
    <h3>
        This semester
    </h3>
    <ul>
        <c:forEach var="s" items="${listcourse}">
            <li><a href="${pageContext.request.contextPath}/class?cid=${s.id}">${s.name}</a></li>
        </c:forEach>

        
        
    </ul>
    <h3>
        History
    </h3>
    <ul>
        
        
       
        
        
         <c:forEach var="se" items="${semesterList}">
            <li><a href="#">${se.getSeasons()} - ${se.getYear()}</a></li>
        </c:forEach>
        
        

    </ul>
    <button>Logout</button>
</body>
</html>
