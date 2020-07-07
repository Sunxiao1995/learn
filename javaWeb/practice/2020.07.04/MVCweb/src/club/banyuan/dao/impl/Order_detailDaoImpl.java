package club.banyuan.dao.impl;


import club.banyuan.dao.Order_detailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import club.banyuan.entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Order_detailDaoImpl extends BaseDaoImpl implements Order_detailDao {

  public Order_detailDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<Order_detail> getOrder_detailByOrderId(Order order) {
    List<Order_detail> list = new ArrayList<>();
    String sql = "select * from order_detail where orderId = ?";
    Object[] params = new Object[]{order.getId()};
    ResultSet rs = executeQuery(sql, params);
    try {
      list = tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }

  @Override
  public int saveOrder_detail(Order_detail order_detail) {
    String sql="insert into order_detail values (null,?,?,?,?)";
    Object [] params = new Object[]{order_detail.getOrderId(),order_detail.getProductId(),order_detail.getQuantity(),
    order_detail.getCost()};
    return executeInsert(sql,params);

  }

  @Override
  public List<Order_detail> buildOrder_detail(Order order, Map<Product, Integer> map) {
    List<Order_detail> list = new ArrayList<>();
    Iterator<Entry<Product, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Order_detail order_detail = new Order_detail();
      order_detail.setOrderId(order.getId());
      Entry<Product, Integer> entry = iterator.next();
      order_detail.setProductId(entry.getKey().getId());
      order_detail.setQuantity(entry.getValue());
      double cost = entry.getValue()*entry.getKey().getPrice();
      order_detail.setCost(cost);
      list.add(order_detail);
    }
    return list;
  }

  @Override
  public List<Order_detail> tableToClass(ResultSet rs) throws Exception {
    List<Order_detail> list = new ArrayList<>();
    while (rs.next()) {
      Order_detail order_detail = new Order_detail();
      order_detail.setId(rs.getInt(1));
      order_detail.setOrderId(rs.getInt(2));
      order_detail.setProductId(rs.getInt(3));
      order_detail.setQuantity(rs.getInt(4));
      order_detail.setCost(rs.getDouble(5));
      list.add(order_detail);
    }
    return list;
  }
}
