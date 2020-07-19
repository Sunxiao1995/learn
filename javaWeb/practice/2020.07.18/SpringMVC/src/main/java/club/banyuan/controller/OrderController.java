package club.banyuan.controller;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.service.impl.OrderServiceImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
  @Autowired
  private OrderService orderService;

  @RequestMapping("confirmOrder")
  public String confirmOrder(HttpSession session){
    Map<Product, Integer> addCar = (Map<Product, Integer>) session.getAttribute("addCar");
    double totalPrice = 0;
    for (Product product : addCar.keySet()) {
      totalPrice += product.getPrice() * addCar.get(product);
    }
    session.setAttribute("totalPrice", totalPrice);
    return  "BuyCar_two";
  }

  @RequestMapping("createOrder")
  public String createOrder(HttpSession session, Model model){
    if (session.getAttribute("user") == null) {
      return "Login";
    } else {
      User user = (User) session.getAttribute("user");

      String address = "南京";
      double totalPrice = Double.parseDouble(session.getAttribute("totalPrice").toString());
      Map<Product, Integer> addCar = (Map<Product, Integer>) session.getAttribute("addCar");
      Order order = orderService.payShoppingCart(addCar, totalPrice, user, address);
      model.addAttribute("order", order);

      session.removeAttribute("addCar");
      session.removeAttribute("totalPrice");
      return "BuyCar_three";
    }
  }

  @RequestMapping("/Member_order")
  public String myOrder(HttpSession session){
    Object obj = session.getAttribute("user");
    User user;
    if(obj != null){
      user = (User)obj;
      try {
        List<Order> orders = orderService.getOrderByUser(user);
        session.setAttribute("orders",orders);

      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      return "Member_Order";
    }else {
      return "Login";
    }
  }
}
