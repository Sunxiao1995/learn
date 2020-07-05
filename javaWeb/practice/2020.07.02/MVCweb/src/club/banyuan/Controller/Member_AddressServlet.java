package club.banyuan.Controller;

import club.banyuan.Entity.Address;
import club.banyuan.Entity.User;
import club.banyuan.Service.AddressService;
import club.banyuan.Service.impl.AddressServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Member_AddressServlet",urlPatterns = "/Member_Address.do")
public class Member_AddressServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Object obj = session.getAttribute("user");
    User user = null;
    if(obj != null){
      user = (User)obj;
    }
    AddressService addressService =new AddressServiceImpl();
    try {
      Address address = addressService.getAddressByUser(user);
      session.setAttribute("address",address);
      request.getRequestDispatcher("Member_Address.jsp").forward(request,response);

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
