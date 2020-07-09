package club.banyuan.controller;

import club.banyuan.entity.Admin;
import club.banyuan.entity.User;
import club.banyuan.service.AdminService;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.AdminServiceImpl;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminLoginServlet" ,urlPatterns = "adminLogin.do")
public class AdminLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");

    HttpSession session = request.getSession();

    AdminService adminService = new AdminServiceImpl();
    try {
       Admin admin = adminService.getAdmin(loginName,password);
       if(admin.getLoginName()==null){
         request.setAttribute("error","error");
         request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
       }else {
         session.setAttribute("admin",admin);
         request.getRequestDispatcher("").forward(request,response);
       }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
     doPost(request,response);
  }
}
