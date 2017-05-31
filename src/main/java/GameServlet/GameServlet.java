package GameServlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.csumb.cst438.a1.Game;
import com.csumb.cst438.a1.MyHttpServer;
/**
 *
 * @author Cian
 */
public class GameServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        // print action value to console
        System.out.println("EmailListServlet action: " + action);
        
        if (action == null)
        {
            action = "new_game";  // default action
        }
        
        // perform action and set URL to appropriate page
        if(action.equals("new_game"))
        {
            Game.startNewGame();
        }
        else if(action.equals("correct_guess"))
        {
            Game.playGame();
        }
        else if(action.equals("incorrect_guess"))
        {
            Game.playGame();]
        }
        else if(action.equals("win"))
        {
            Game.playGame();
        }
        else if(action.equals("lose"))
        {
            Game.playGame();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
