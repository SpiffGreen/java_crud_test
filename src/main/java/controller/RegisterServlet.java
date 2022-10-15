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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  private UserDao userDao = new UserDao();

  public RegisterServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // resp.getWriter().append("Well hello motherfucker!");
    req.getRequestDispatcher("register.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    User user = new User();
    user.setName(name);
    user.setEmail(email);
    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
    user.setPassword(hashed);

    int result = 0;

    try {
      result = userDao.registerUser(user);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    if (result > 0) {
      resp.getWriter().append("User successfully added");
    } else {
      resp.getWriter().append("User not added");
    }
  }
}
