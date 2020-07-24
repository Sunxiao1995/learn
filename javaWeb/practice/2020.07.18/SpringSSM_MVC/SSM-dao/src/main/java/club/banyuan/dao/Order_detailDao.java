package club.banyuan.dao;


import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import java.util.List;

public interface Order_detailDao{

  public List<Order_detail> getOrder_detailByOrderId(Order order);

  public int saveOrder_detail (Order_detail order_detail);


}
