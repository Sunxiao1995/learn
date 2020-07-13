package club.banyuan.test;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {
  InputStream ins;
  SqlSession session;
  AddressDao addressDao;
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
    addressDao = session.getMapper(AddressDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void testGetAddressByUserId(){
    User user = new User(2,null,null,null,null,null,null,null,null);
    Address address = addressDao.getAddressByUserId(user);
    System.out.println(address);
  }

  @Test
  public void testSaveAddress(){
    Address address = new Address(null ,1,null,null,1,null);
    int i = addressDao.saveAddress(address);
    System.out.println(address);
    System.out.println(i);
  }

}
