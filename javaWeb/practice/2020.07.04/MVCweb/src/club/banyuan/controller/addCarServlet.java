package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.ProductServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addCarServlet",urlPatterns = "/addCar.do")
public class addCarServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession httpSession = request.getSession();
    Integer productId =Integer.valueOf(request.getParameter("productId"));
    Integer quantity =Integer.valueOf(request.getParameter("quantity"));
    ProductService productService = new ProductServiceImpl();
//    Map<Product,Integer> addCar = new HashMap<>();



    Map<Product,Integer> addCar ;
    Object obj = httpSession.getAttribute("addCar");
    if(obj == null){
      addCar = new HashMap<>();
    }else {
      addCar = (Map<Product,Integer>)obj;
    }
    try {
      Product product = productService.getProductById(productId);

      if(addCar.containsKey(product)){
        quantity = addCar.get(product)+quantity;
      }

      addCar.put(product,quantity);

      httpSession.setAttribute("addCar",addCar);
      request.getRequestDispatcher("BuyCar.jsp").forward(request,response);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}
