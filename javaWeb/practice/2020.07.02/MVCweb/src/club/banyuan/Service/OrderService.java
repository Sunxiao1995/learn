package club.banyuan.Service;

import club.banyuan.Entity.Order;
import club.banyuan.Entity.User;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
  public List<Order> getOrderByUser(User user) throws SQLException;

}
