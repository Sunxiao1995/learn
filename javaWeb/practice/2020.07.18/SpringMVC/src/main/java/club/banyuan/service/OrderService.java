package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OrderService {
  public List<Order> getOrderByUser(User user) throws SQLException;

  public Order payShoppingCart(Map<Product, Integer> addCar, double totalPrice, User user, String address);
}
