package club.banyuan.Dao;


import club.banyuan.Entity.Order;
import club.banyuan.Entity.Order_detail;
import club.banyuan.Entity.Product;
import java.util.List;
import java.util.Map;

public interface Order_detailDao extends IBaseDao {

  public List<Order_detail> getOrder_detailByOrderId(Order order);

  public int saveOrder_detail (Order_detail order_detail);

  public List<Order_detail> buildOrder_detail (Order order, Map<Product,Integer> map);

}
