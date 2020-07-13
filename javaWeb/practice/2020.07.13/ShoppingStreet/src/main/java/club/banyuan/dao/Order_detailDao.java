package club.banyuan.dao;


import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import club.banyuan.entity.Product;
import java.util.List;
import java.util.Map;

public interface Order_detailDao{

  public List<Order_detail> getOrder_detailByOrderId(Order order);

  public int saveOrder_detail (Order_detail order_detail);


}
