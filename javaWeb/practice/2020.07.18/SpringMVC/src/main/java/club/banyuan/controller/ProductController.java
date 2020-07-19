package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.ProductService;
import com.mysql.cj.Session;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
  @Autowired
  private ProductService productService;

  @RequestMapping("/productSearch")
  public String productSearch(String search, Model model){

    String keyword = "%"+search+"%";
    List<Product> list = null;
    try {
      list = productService.getProductByKeyword(keyword);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    model.addAttribute("product",list);
    return "CategoryList";
  }

  @RequestMapping("/productDetail")
  public String productDetail(Integer productId,Model model){
    Product product = null;
    try {
      product = productService.getProductById(productId);
    } catch (Exception e) {
      e.printStackTrace();
    }
    model.addAttribute("product",product);
    return "Product";
  }

  @RequestMapping("/addCar")
  public String addCar(Integer productId,Integer quantity,HttpSession session){
    Object user = session.getAttribute("user");
    User user1 = (User) user;
    System.out.println(user1);
    if(user == null){
      return "Login";
    }

    Map<Product,Integer> addCar ;
    Object obj = session.getAttribute("addCar");
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
      session.setAttribute("addCar",addCar);
      return "BuyCar";
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Product";
  }

}
