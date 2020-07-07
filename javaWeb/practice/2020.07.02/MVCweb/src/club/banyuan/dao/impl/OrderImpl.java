package club.banyuan.dao.impl;


import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OrderImpl extends BaseDaoImpl implements OrderDao {

  public OrderImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<Order> getOrderByLoginName(User user) {
    List<Order> list =new ArrayList<>();
    String sql = "select * from `order` where loginName = ?";
    Object [] params = new Object[]{user.getLoginName()};
    ResultSet rs = executeQuery(sql,params);
    try {
      list = tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }

  @Override
  public int saveOrder(Order order) {
    String sql="insert into order values (null,?,?,?,?,?,?)";
    Object [] params = new Object[]{order.getUserId(),order.getLoginName(),order.getUserAddress(),
    order.getCreateTime(),order.getCost(),order.getSerialNumber()};
    int i = executeInsert(sql,params);

    return i;
  }


  @Override
  public Order buildOrder(User user, Map<Product,Integer> map) {
    Order order = new Order();
    Date date = new Date();
    java.sql.Date transDate = new java.sql.Date(date.getTime());

    order.setUserId(user.getId());
    order.setLoginName(user.getLoginName());
    order.setUserAddress(null);
    order.setCreateTime(transDate);

    double cost = 0;
    Iterator<Entry<Product, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<Product, Integer> entry = iterator.next();
      cost += (entry.getValue()) * (entry.getKey().getPrice());
    }

    order.setCost(cost);
    order.setSerialNumber("s7abidjan8wq82");
    return order;
  }


  @Override
  public List<Order> tableToClass(ResultSet rs) throws Exception {
    List<Order> list = new ArrayList<>();
    while (rs.next()){
      Order order = new Order();
      order.setId(rs.getInt(1));
      order.setUserId(rs.getInt(2));
      order.setLoginName(rs.getString(3));
      order.setUserAddress(rs.getString(4));
      order.setCreateTime(rs.getDate(5));
      order.setCost(rs.getDouble(6));
      order.setSerialNumber(rs.getString(7));
      list.add(order);
    }
    return list;
  }
}
