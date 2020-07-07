package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegServlet", urlPatterns = "/Register.do")
public class RegServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    User user = new User();
    user.setLoginName(request.getParameter("loginName"));
    user.setPassword(request.getParameter("password"));
    user.setMobile(request.getParameter("mobile"));
    user.setEmail(request.getParameter("email"));

    UserService userService = new UserServiceImpl();
    try {
      Integer i =  userService.register(user);
      if(i > 0 ){
        request.setAttribute("user",user);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        return;
      }
    } catch (SQLException throwables) {
      request.setAttribute("error","error");
      request.getRequestDispatcher("Regist.jsp").forward(request,response);
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
