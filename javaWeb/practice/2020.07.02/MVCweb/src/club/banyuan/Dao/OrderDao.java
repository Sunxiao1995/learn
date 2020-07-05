package club.banyuan.Dao;


import club.banyuan.Entity.Order;
import club.banyuan.Entity.Product;
import club.banyuan.Entity.User;
import java.util.List;
import java.util.Map;

public interface OrderDao extends IBaseDao {
  public List<Order> getOrderByLoginName(User user);

  public int saveOrder (Order order);

  public Order buildOrder(User user, Map<Product,Integer> map);



}
