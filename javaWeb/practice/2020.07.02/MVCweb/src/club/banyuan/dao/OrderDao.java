package club.banyuan.dao;


import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.util.List;
import java.util.Map;

public interface OrderDao extends IBaseDao {
  public List<Order> getOrderByLoginName(User user);

  public int saveOrder (Order order);

  public Order buildOrder(User user, Map<Product,Integer> map);



}
