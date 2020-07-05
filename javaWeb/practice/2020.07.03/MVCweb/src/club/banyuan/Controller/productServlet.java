package club.banyuan.Controller;

import club.banyuan.Entity.Product;
import club.banyuan.Service.ProductService;
import club.banyuan.Service.impl.ProductServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "productServlet",urlPatterns = "/product.do")
public class productServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      Integer id = Integer.valueOf(request.getParameter("productId")) ;
      ProductService productService = new ProductServiceImpl();

    try {
      Product product = productService.getProductById(id);
      if(product != null){
        request.setAttribute("product",product);
        request.getRequestDispatcher("Product.jsp").forward(request,response);
      }
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
