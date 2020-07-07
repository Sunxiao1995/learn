package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.service.impl.OrderServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Member_orderServlet" ,urlPatterns = "/Member_orderServlet.do")
public class Member_orderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Object obj = session.getAttribute("user");
    User user = null;
    if(obj != null){
       user = (User)obj;
    }
    OrderService orderService = new OrderServiceImpl();
    try {
      List<Order> orders = orderService.getOrderByUser(user);
      session.setAttribute("orders",orders);
      request.getRequestDispatcher("Member_Order.jsp").forward(request,response);
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
