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

@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
     User user = new User();
     request.setCharacterEncoding("utf-8");
     user.setUserName(request.getParameter("userName"));
     user.setPassword(request.getParameter("password"));
     user.setIdentityNum(request.getParameter("identityNum"));
     user.setPhoneNum(request.getParameter("phoneNum"));
     user.setAddress(request.getParameter("address"));
     user.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));

    UserService userService = new UserServiceImpl();

    try {
      Integer i = userService.register(user);
      if(i>0){
        request.getRequestDispatcher("bidderLogin.jsp").forward(request,response);
      }
    } catch (SQLException throwables) {
      request.setAttribute("error","error");
      request.getRequestDispatcher("bidderRegister.jsp").forward(request,response);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}
