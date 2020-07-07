package club.banyuan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet",urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie : cookies){
      if(cookie.getName().equals("loginNameCookie")) {
        cookie.setMaxAge(0);
      }
    }
    session.invalidate();
    response.sendRedirect("index.jsp");
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}
