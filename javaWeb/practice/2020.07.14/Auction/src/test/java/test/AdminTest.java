package test;


import club.banyuan.dao.IAdminDao;
import club.banyuan.dao.IAuctionItemDao;
import club.banyuan.entity.Admin;
import club.banyuan.entity.AuctionItem;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminTest {
  InputStream ins;
  SqlSession session;
  IAdminDao adminDao;
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
   adminDao = session.getMapper(IAdminDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }



  @Test
  public void testGetAdmin() throws ParseException {
    Map<String,String> map = new HashMap<>();
    map.put("loginName","admin");
    map.put("password","123456789");
    Admin admin = adminDao.getAdmin(map);
    System.out.println(admin);
  }

}
