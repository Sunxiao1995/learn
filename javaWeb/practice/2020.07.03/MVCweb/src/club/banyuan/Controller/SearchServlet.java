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

@WebServlet(name = "SearchServlet",urlPatterns = "/Search.do")
public class SearchServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
     String keyword = request.getParameter("search");
    ProductService productService = new ProductServiceImpl();

    try {
      List<Product> list = productService.getProductByKeyword(keyword);
      if(list != null){
        request.setAttribute("product",list);
        request.getRequestDispatcher("CategoryList.jsp").forward(request,response);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
