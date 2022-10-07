package logic;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Req -> (S -> S) -> jsp

public class LoginServlet extends HttpServlet {

    private static Map<String, String> userData = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(!userData.containsKey(login)){
            userData.put(login, password);
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
        }
        if(userData.containsKey(login)){
            if(userData.get(login).equals(password)){
                HttpSession session = request.getSession(true);
                session.setAttribute("user_login", login);
            }else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("wrongPass.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");

        response.sendRedirect("index.jsp");
    }
}
