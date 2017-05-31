<%-- 
    Document   : index
    Created on : May 30, 2017, 7:56:23 PM
    Author     : Cian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //Trying to inlude or package to make Game recognizable results in error
    Game game = new Game();
    String cookie = "0";
    String u, letters = "abcdefghijklmnopqrstuvwxyz";
    boolean flag = false;
    String code = "";
    int x = 0;
%>

<!DOCTYPE html>
<html><head><title>MyHttpServer</title></head>
    <body>
        <h2>Hangman J2EE</h2>
        <img src="h<%game.getState();%>.gif">
        <h2 style="font-family:'Lucida Console', monospace"> <%game.getDisplayWord();%>
        <%
        if(x == 3)
        {
            code = "<h2>You lost!  The word is " + game.getWord() + "</h2>";
        }
        else if(x == 1)
        {
            code = "<h2>Congratulations you win!</h2>";
        }
        else if(x == 4)
        {
            code = "<form action=\"/\" method=\"get\"> "
                    + "Incorrect input. Try another character <input type=\"text\" name=\"guess\"><br>"
                    + "<input type=\"submit\" value=\"Submit\">" + "</form>";
        }
        else
        {
            code = "<form action=\"/\" method=\"get\"> "
                    + "Guess a character <input type=\"text\" name=\"guess\"><br>"
                    + "<input type=\"submit\" value=\"Submit\">" + "</form>";
        }
        out.println(code);
        %>
    </body>
</html>

<%
    //After user sumbits, game.playGame() will be called from here based on user input, stored in uri
    //Old code used HttpExchange t to find input. What should this code use...
    String uri = t.getRequestURI().toString();
    u = uri.toLowerCase();
    u = u.replace("/", "");
    u = u.replace("?guess=", "");
    if ((u.length() == 0 || u.length() > 1 || letters.contains(u) == false) && uri.contains(".gif") == false)
    {
	flag = true;
    }
    x = game.playGame(u, flag);
%>