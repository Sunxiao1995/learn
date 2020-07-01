package club.banyuan.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testServlet",urlPatterns = "/test.do")
public class testServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
        System.out.println("doPost...");
        doGet(request,response);
  }

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("doPost...");
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    System.out.println(loginName+password);

  }
}
