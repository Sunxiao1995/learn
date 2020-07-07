package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
  public List<Order> getOrderByUser(User user) throws SQLException;

}
