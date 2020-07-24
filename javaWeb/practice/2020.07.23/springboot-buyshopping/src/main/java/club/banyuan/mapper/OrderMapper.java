package club.banyuan.mapper;


import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
  public List<Order> getOrderByLoginName(User user);

  public int saveOrder (Order order);




}
