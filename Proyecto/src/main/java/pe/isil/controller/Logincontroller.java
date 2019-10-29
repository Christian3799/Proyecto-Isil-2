package pe.isil.controller;
import pe.isil.dao.Daocontext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1, name = "login")
public class Logincontroller extends HttpServlet {


    @Override
    public void init() throws ServletException {
        Daocontext.init(this.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("login", "");
        req.setAttribute("password", "");
        req.setAttribute("errorMessage", "");

        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("txtLogin");
        String password = req.getParameter("txtPassword");

        req.setAttribute("login", login);
        req.setAttribute("password", password);

        if(login.equalsIgnoreCase("usuario") &&
                password.equalsIgnoreCase("123")){

            HttpSession session = req.getSession();
            session.setAttribute("userName", "Rodrigo");
            req.getRequestDispatcher("/home.jsp").forward(req, resp);

        }else{

            req.setAttribute("errorMessage","error en la contraseña");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}