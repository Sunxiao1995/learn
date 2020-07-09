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
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String errorUserName = "";
    String errorPassword = "";
    HttpSession session = request.getSession();

    if("".equals(userName) || "".equals(password)){
      if("".equals(userName)){
        errorUserName="用户名不能为空";
        request.setAttribute("errorUserName",errorUserName);
      }else {
        errorPassword = "密码不能为空";
        request.setAttribute("errorPassword",errorPassword);
      }
      request.getRequestDispatcher("bidderLogin.jsp").forward(request,response);
    }else {
      UserService userService = new UserServiceImpl();
      try {
        if(!userService.isUserExists(userName)){
          errorUserName="用户名不存在";
          request.setAttribute("errorUserName",errorUserName);
          request.getRequestDispatcher("bidderLogin.jsp").forward(request,response);
        }else {
          User user = userService.getUser(userName,password);

          if(user.getUserName()==null){
            errorPassword="密码错误";
            request.setAttribute("errorPassword",errorPassword);
            request.getRequestDispatcher("bidderLogin.jsp").forward(request,response);
          }else {
            session.setAttribute("user",user);
            request.getRequestDispatcher("auctionItem_list.jsp").forward(request,response);
          }
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
