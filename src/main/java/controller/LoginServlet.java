package controller;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/login")
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
        resp.getWriter().append("Welcome " + user.getName()).append("\nemail: " + email);
      } else {
        resp.getWriter().append("Incorrect credentials");
      }
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      resp.getWriter().append("Sorry an error occured");
    }
  }
}
