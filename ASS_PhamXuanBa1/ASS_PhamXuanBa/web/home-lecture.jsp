<%-- 
    Document   : home-lecture
    Created on : 15 Jul 2024, 23:02:07
    Author     : baophan
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
    
    
</body>
</html>
