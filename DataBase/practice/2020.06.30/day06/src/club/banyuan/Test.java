package club.banyuan;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.OrderImpl;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.dao.impl.userDaoImpl;
import club.banyuan.dao.userDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Test {

  public static void main(String[] args) throws SQLException {
    Connection conn = JdbcUtils.getConnection();
//    userDao userDao = new userDaoImpl(conn);
//    User newUser = new User(null,"kkkk","realName","123",1,"14022529231991992","dfs@sdf.com","12345666673",1);
//    int id = userDao.add(newUser);
//    System.out.println(id);
//    ProductDao product = new ProductDaoImpl(conn);
//      List<Product> list =  product.getProductByKeyword("华为");
//    for (Product a:list) {
//      System.out.println(a);
//    }

    User user = new User(null,"admin",null,null,null,null,null,null,null);
    OrderDao orderDao = new OrderImpl(conn);
    List<Order> list =  orderDao.getOrderByLoginName(user);
    for (Order a:list) {
      System.out.println(a);
   }

    


  }
}
