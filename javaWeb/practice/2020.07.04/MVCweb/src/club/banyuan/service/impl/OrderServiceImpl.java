package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.Order_detailDao;
import club.banyuan.dao.impl.OrderImpl;
import club.banyuan.dao.impl.Order_detailDaoImpl;
import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.util.JdbcUtils;
import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

public class OrderServiceImpl implements OrderService {

  @Override
  public List<Order> getOrderByUser(User user) throws SQLException {
    OrderDao orderDao = new OrderImpl(JdbcUtils.getConnection());
    List<Order> list = orderDao.getOrderByLoginName(user);
    return list;
  }

  @Override
  public Order payShoppingCart(Map<Product, Integer> addCar, double totalPrice, User user,
      String address) {

    Connection connection = null;
    Order order = new Order();
    try {
      connection = JdbcUtils.getConnection();
      connection.setAutoCommit(false);

      OrderDao orderDao = new OrderImpl(connection);
      Order_detailDao order_detailDao = new Order_detailDaoImpl(connection);

      order.setUserId(user.getId());
      order.setLoginName(user.getLoginName());
      order.setUserAddress(address);
      java.util.Date date = new java.util.Date();
      java.sql.Date transDate = new java.sql.Date(date.getTime());
      order.setCreateTime(transDate);
      order.setCost(totalPrice);
      order.setSerialNumber("1111");
      int i = orderDao.saveOrder(order);
      System.out.println(i);

      for (Product product : addCar.keySet()) {
        Order_detail order_detail = new Order_detail();
        order_detail.setOrderId(i);
        order_detail.setCost(product.getPrice());
        order_detail.setProductId(product.getId());
        order_detail.setQuantity(addCar.get(product));
        int j = order_detailDao.saveOrder_detail(order_detail);
        System.out.println(j);
        connection.commit();
      }
    } catch (Exception e) {

      e.printStackTrace();
      try {
        connection.rollback();
        System.out.println("错误");
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      order = null;
    } finally {
      try {
        connection.setAutoCommit(true);

      } catch (SQLException e) {
        e.printStackTrace();
      }
      return order;
    }
  }

}
