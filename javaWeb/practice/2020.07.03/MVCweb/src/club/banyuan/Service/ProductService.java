package club.banyuan.Service;

import club.banyuan.Entity.Product;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {
  public List<Product> getProductByKeyword(String keyword) throws SQLException;
  public Product getProductById(Integer id) throws Exception;
}
