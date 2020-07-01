package club.banyuan.servlet;

import club.banyuan.dao.impl.userDaoImpl;
import club.banyuan.dao.userDao;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet",urlPatterns = "/login.do")

public class loginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    boolean flag = false;
    try {
      userDao userDao = new userDaoImpl(JdbcUtils.getConnection());
      User user = userDao.getLoginUser(loginName,password);
      if(user.getLoginName() != null){
        flag = true;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    response.setCharacterEncoding("utf-8");
    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    writer.println("<meta charset='UTF-8'/>");
    writer.println("<body>");
    writer.println(flag==true?"登陆成功":"登陆失败");
    writer.flush();
    writer.close();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
     doPost(request,response);

  }
}
