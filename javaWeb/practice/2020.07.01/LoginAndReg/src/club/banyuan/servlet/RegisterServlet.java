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

@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    User user = new User();
    user.setLoginName(request.getParameter("loginName"));
    user.setPassword(request.getParameter("password"));
    user.setEmail(request.getParameter("email"));
    user.setMobile(request.getParameter("mobile"));
    boolean flag = false;
    try {
      userDao userDao = new userDaoImpl(JdbcUtils.getConnection());
      int id = userDao.add(user);
      if(id>0){
        flag = true;
      }
      System.out.println(id);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
//    response.setCharacterEncoding("utf-8");
//    PrintWriter writer = response.getWriter();
//    writer.println("<html>");
//    writer.println("<meta charset='UTF-8'/>");
//    writer.println("<body>");
//    writer.println(flag==true?"成功":"失败");
//    writer.println("<br/>");
//    writer.println("请选择注册或登陆");
//    writer.println("<br/>");
//    writer.println("<a href=\"Regist.html\"><button>注册</button></a>");
//    writer.println("<a href=\"Login.html\"><button>登陆</button></a>");
//    writer.println("</body>");
//    writer.println("</html>");
//    writer.flush();
//    writer.close();

    if(flag){
      response.sendRedirect("success.html");
    } else {
      response.sendRedirect("filed.html");
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
