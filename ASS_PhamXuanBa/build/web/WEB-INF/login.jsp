<%-- 
    Document   : login
    Created on : Jul 16, 2024, 4:44:50 AM
    Author     : bapxh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="border: 0 ;margin: 0;padding: 0;">
    
    <div style="width: 100vw;height: 100vh; background:#808080;display: flex;justify-content: center;align-items: center;" >
        <h1 style="position: fixed;top: 20px;left: 20px;">LogIn</h1>
        
        <div style="width: 500px;height: 300px; background: #FFC0CB;">
            <form action="login" method="post">
                <div style="text-align: center;margin:25px;">
                    <label for="">User Name</label>
                    <input type="text" name="username" style="padding: 7px 15px;border-radius: 10px;border: none;">
                </div>
                <div style="text-align: center;"> 
                    <label for="">Password</label>
                    <input type="password" name="pass" style="padding: 7px 15px;border-radius: 10px;border: none;">
                </div>
                <div style="text-align: center;"> 
                    <h5>${mess}</h5>
                </div>
               
                <div style="text-align: center;"> 
                    <button type="submit" style="padding: 7px 15px;margin-top: 40px;">Login</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
