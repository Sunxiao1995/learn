package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Override
  public List<Product> getProductByKeyword(String keyword) throws SQLException {

    return productDao.getProductByKeyword(keyword);
  }

  @Override
  public Product getProductById(Integer id) throws Exception {

    return productDao.getProductById(id);
  }
}
