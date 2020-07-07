package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.service.impl.OrderServiceImpl;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreateOrderServlet" ,urlPatterns = "/createOrder.do")
public class CreateOrderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } else {
      User user = (User) session.getAttribute("user");

      String address = "南京";
      double totalPrice = Double.parseDouble(session.getAttribute("totalPrice").toString());
      Map<Product, Integer> addCar = (Map<Product, Integer>) session.getAttribute("addCar");
      OrderService orderService = new OrderServiceImpl();
      Order order = orderService.payShoppingCart(addCar, totalPrice, user, address);
      request.setAttribute("order", order);

      session.removeAttribute("addCar");
      session.removeAttribute("totalPrice");
      request.getRequestDispatcher("BuyCar_three.jsp").forward(request, response);
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
