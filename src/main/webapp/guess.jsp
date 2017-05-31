<%-- 
    Document   : word
    Created on : May 30, 2017, 7:56:33 PM
    Author     : Cian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guess</title>
    </head>
    <body>
        <h2>Hangman J2EE</h2>
        <%if(game.getState);%>
        <img src="h<%game.getState();%>.gif">
        <h2 style="font-family:'Lucida Console', monospace"> <%game.getDisplayWord();%>
        <form action="/" method="get">
            Guess a character <input type="text" name="guess"><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
