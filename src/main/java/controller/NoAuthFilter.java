package controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(
  servletNames = { "LoginServlet", "RegisterServlet" }, 
  filterName = "NoAuthFilter", 
  description = "Filter noauth URLs"
)
public class NoAuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException, NullPointerException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    try {
      HttpSession session = req.getSession();
      String user = (String) session.getAttribute("user");
      if (user.isEmpty()) {
        chain.doFilter(request, response);
      } else {
        res.sendRedirect("index.jsp");
      }
    } catch (Exception e) {
      // e.printStackTrace();
      chain.doFilter(request, response);
    }
  }
}
