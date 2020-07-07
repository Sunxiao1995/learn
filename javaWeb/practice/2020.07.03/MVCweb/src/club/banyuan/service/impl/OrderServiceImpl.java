package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.impl.OrderImpl;
import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

  @Override
  public List<Order> getOrderByUser(User user) throws SQLException {
    OrderDao orderDao =new OrderImpl(JdbcUtils.getConnection()) ;
    List<Order> list =  orderDao.getOrderByLoginName(user);
    return list;
  }
}
