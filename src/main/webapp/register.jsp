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
        <div>Ihre Angaben</div>
        <form action="api/register_api.jsp" method="post">
            Benutzername:<input type="text" name="username"/><br><br/>
            Vorname:<input type="text" name="firstname"/><br><br/>
            Nachname:<input type="text" name="lastname"/><br><br/>
            Email:<input type="text" name="email"/><br><br/>
            Tel. Nummer:<input type="text" name="phone"/><br><br/>
            Passwort:<input type="password" name="password"/><br><br/>
            <input type="submit" value="register"/>
        </form>
    </body>
</html>