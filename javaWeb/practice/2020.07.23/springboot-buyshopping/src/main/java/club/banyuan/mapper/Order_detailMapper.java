package club.banyuan.mapper;


import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Order_detailMapper {

  public List<Order_detail> getOrder_detailByOrderId(Order order);

  public int saveOrder_detail (Order_detail order_detail);


}
