package club.banyuan.test;

import club.banyuan.dao.AddressDao;
import club.banyuan.dao.OrderDao;
import club.banyuan.dao.Order_detailDao;
import club.banyuan.entity.Address;
import club.banyuan.entity.Order;
import club.banyuan.entity.Order_detail;
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

public class OrderTest {
  InputStream ins;
  SqlSession session;
  OrderDao orderDao;
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
    orderDao = session.getMapper(OrderDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void testGetOrderByLoginName(){
    User user = new User(null,"shangzezhong",null,null,null,null,null,null,null);
    List<Order> list= orderDao.getOrderByLoginName(user);
    for (Order o:list) {
      System.out.println(o);
    }
  }

  @Test
  public void testSaveOrder(){
    Order order = new Order(null,18,"shangzezhong",null,null,null,null);
    int i =  orderDao.saveOrder(order);
    System.out.println(i);
    System.out.println(order);
  }



}
