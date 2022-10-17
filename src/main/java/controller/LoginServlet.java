package controller;

import java.io.IOException;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(
  urlPatterns = "/login",
  name = "LoginServlet"
)
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private UserDao userDao = new UserDao();
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    User user;
    try {
      user = userDao.getUser(email);
      if(BCrypt.checkpw(password, user.getPassword())) {
        // resp.getWriter().append("Welcome " + user.getName()).append("\nemail: " + email);
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user.getName());
        resp.sendRedirect("dashboard.jsp");
      } else {
        resp.getWriter().append("Incorrect credentials");
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      resp.getWriter().append("Sorry an error occured");
    }
  }
}
