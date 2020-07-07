package club.banyuan.controller;

import club.banyuan.entity.Product;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConfirmOrderServlet",urlPatterns = "/confirmOrder.do")
public class ConfirmOrderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } else {

      Map<Product, Integer> addCar = (Map<Product, Integer>) session.getAttribute("addCar");
      double totalPrice = 0;
      for (Product product : addCar.keySet()) {
        totalPrice += product.getPrice() * addCar.get(product);
      }
      session.setAttribute("totalPrice", totalPrice);
      request.getRequestDispatcher("BuyCar_two.jsp").forward(request, response);
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
     doPost(request,response);
  }
}
