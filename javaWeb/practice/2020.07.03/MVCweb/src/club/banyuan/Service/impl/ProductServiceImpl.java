package club.banyuan.Service.impl;

import club.banyuan.Dao.ProductDao;
import club.banyuan.Dao.impl.ProductDaoImpl;
import club.banyuan.Entity.Product;
import club.banyuan.Service.ProductService;
import club.banyuan.Util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

  public List<Product> getProductByKeyword(String keyword) throws SQLException {
    ProductDao productDao =new ProductDaoImpl(JdbcUtils.getConnection());

    return productDao.getProductByKeyword(keyword);
  }

  @Override
  public Product getProductById(Integer id) throws Exception {
    ProductDao productDao =new ProductDaoImpl(JdbcUtils.getConnection());
    return productDao.getProductById(id);
  }
}
