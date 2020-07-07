package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
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
