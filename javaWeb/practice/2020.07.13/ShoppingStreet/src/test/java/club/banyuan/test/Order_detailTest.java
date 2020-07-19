package club.banyuan.test;

import club.banyuan.dao.AddressDao;
import club.banyuan.dao.Order_detailDao;
import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Address;
import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Order_detailTest {
  InputStream ins;
  SqlSession session;
  ProductDao product;
  @Before
  public void init() throws IOException {
    // 加载配置文件
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    // 获取用于创建SqlSessionFactory对象的类的对象
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    // 创建SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    // 创建SqlSession对象
    session = sqlSessionFactory.openSession();
    // 获取接口的实现类对象
    // 动态代理设计模式，获取接口的实现类对象
    product = session.getMapper(ProductDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

//  @Test
//  public void testGetOrder_detailByOrderId(){
//    Order order = new Order(1,null,null,null,null,null,null);
//    List<Order_detail> list = order_detailDao.getOrder_detailByOrderId(order);
//    for (Order_detail o:list) {
//      System.out.println(o);
//    }
//  }

//  @Test
//  public void testSaveOrder_detail(){
//    Order_detail order_detail = new Order_detail(null,12,744,1,355.0);
//    int i =  order_detailDao.saveOrder_detail(order_detail);
//    System.out.println(i);
//    System.out.println(order_detail);
//  }
@Test
public void testSql2(){
  List<Product> list = product.getProductByKeyword("%华为%");

  for (Product product1 : list) {
    System.out.println(product1);
  }

}


}
