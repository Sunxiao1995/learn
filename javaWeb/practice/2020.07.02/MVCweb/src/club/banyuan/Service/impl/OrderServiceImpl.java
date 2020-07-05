package club.banyuan.Service.impl;

import club.banyuan.Dao.OrderDao;
import club.banyuan.Dao.impl.OrderImpl;
import club.banyuan.Dao.impl.Order_detailDaoImpl;
import club.banyuan.Entity.Order;
import club.banyuan.Entity.User;
import club.banyuan.Service.OrderService;
import club.banyuan.Util.JdbcUtils;
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
