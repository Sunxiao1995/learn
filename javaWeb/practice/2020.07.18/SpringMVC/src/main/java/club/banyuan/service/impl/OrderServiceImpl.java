package club.banyuan.service.impl;


import club.banyuan.dao.OrderDao;
import club.banyuan.dao.Order_detailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private Order_detailDao order_detailDao;

  @Override
  public List<Order> getOrderByUser(User user) throws SQLException {

    return orderDao.getOrderByLoginName(user);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Order payShoppingCart(Map<Product, Integer> addCar, double totalPrice, User user,
      String address) {

    Order order = new Order();
    order.setUserId(user.getId());
    order.setLoginName(user.getLoginName());
    order.setUserAddress(address);
    java.util.Date date = new java.util.Date();
    Date transDate = new Date(date.getTime());
    order.setCreateTime(transDate);
    order.setCost(totalPrice);
    order.setSerialNumber("1111");
    orderDao.saveOrder(order);

    for (Product product : addCar.keySet()) {
      Order_detail order_detail = new Order_detail();
      order_detail.setOrderId(order.getId());
      order_detail.setCost(product.getPrice());
      order_detail.setProductId(product.getId());
      order_detail.setQuantity(addCar.get(product));
      order_detailDao.saveOrder_detail(order_detail);
    }
    return order;


  }
}
