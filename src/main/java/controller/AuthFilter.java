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
  urlPatterns = { "/dashboard.jsp" },
  filterName = "AuthFilter",
  description = "Filter all protected URLs"
)
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    HttpSession session = req.getSession(false);
    if(session.getAttribute("user") == null) {
      // Unauthorized access
      System.out.println("Unauthorized access"); // TODO: replace with right log
      res.sendRedirect("login");
    } else {
      chain.doFilter(request, response);
    }
  }
  
}
