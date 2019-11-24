<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>What's in my Fridge?!</title>
    </head>
    <body>
        <h1>Hibernate</h1>
        <div>Hibernate</div>
        <%@page import="main.user.UserDao"%>  
        <jsp:useBean id="obj" class="user.User"></jsp:useBean>  
        <jsp:setProperty property="*" name="obj"/>  

        <%  
        int i=main.user.UserDao.register(obj);  
        if(i>0)  
        out.print("You are successfully registered");
        %>  
    </body>
</html>