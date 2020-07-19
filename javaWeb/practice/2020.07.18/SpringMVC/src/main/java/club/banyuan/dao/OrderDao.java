package club.banyuan.dao;


import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import java.util.List;

public interface OrderDao{
  public List<Order> getOrderByLoginName(User user);

  public int saveOrder (Order order);




}
