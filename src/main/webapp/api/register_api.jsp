<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <h1>Register</h1>
        <%@page import="main.java.ch.wimf.user.registration.UserDao"%>
        <jsp:useBean id="obj" class="main.java.ch.wimf.user.User"/>
        <jsp:setProperty property="*" name="obj"/>  

        <%
            int i = main.java.ch.wimf.user.UserDao.register(obj);
            if (i > 0) {
                out.print("You are successfully registered");
            }
        %>  
    </body>
</html>