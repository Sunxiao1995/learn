package club.banyuan.controller;

import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidateRegisterServlet",urlPatterns = "/validateRegister.do")
public class ValidateRegisterServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    UserServiceImpl userService = new UserServiceImpl();
    String result = "true";
    String userName = request.getParameter("userName");
    if(!userName.equals("") &&userName!=null){
      try {
        if(userService.isUserExists(userName)){
          result = "false";
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    PrintWriter writer = response.getWriter();
    writer.print(result);
    writer.flush();
    writer.close();
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}
