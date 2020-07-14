package test;


import club.banyuan.dao.IAuctionItemDao;
import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuctionItemTest {
  InputStream ins;
  SqlSession session;
  IAuctionItemDao auctionItemDao;
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
    auctionItemDao = session.getMapper(IAuctionItemDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }



  @Test
  public void testGetAuctionItemBySearch() throws ParseException {
    String a = "2020-03-10 12:12:12";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = simpleDateFormat.parse(a);
    AuctionItem auctionItem = new AuctionItem( 1,"%中%",null,null,date,null,"%嘿%",null);
    List<AuctionItem> list = auctionItemDao.getAuctionItemBySearch(auctionItem);

    for (AuctionItem aa: list) {
      System.out.println(aa);
    }
  }

}
