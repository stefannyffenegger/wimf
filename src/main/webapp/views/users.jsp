<jsp:useBean id="obj" class="main.java.ch.wimf.user.User"/>
<%@page import="main.java.ch.wimf.user.UserDao"%>
<%@page import="main.java.ch.wimf.user.User"%>
<%@page import="java.util.List"%>
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
        <h1>Registered Users</h1>
        <%
            List users = main.java.ch.wimf.user.UserDao.getUsers();
            if (users != null && users.size() > 0) {
                out.print("You are successfully registered");
                User usr = (User)users.get(1);
                out.print(usr.getFirstname());
            }
        %>  
    </body>
</html>