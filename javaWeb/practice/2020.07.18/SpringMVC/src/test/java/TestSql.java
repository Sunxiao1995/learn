import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSql {

  @Autowired
  private ProductDao productDao;

  @Test
  public void testSql(){
   List<Product> list =  productDao.getProductByKeyword("香奈儿");
    for (Product product : list) {
      System.out.println(product.getName());
    }
  }

  @Test
  public void testSql2(){
    Product product = productDao.getProductById(733);
    System.out.println(product);
  }

}
