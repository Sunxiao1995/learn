package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;
import club.banyuan.vo.PageParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserDao {
    InputStream ins;
    SqlSession session;
    UserDao userDao;
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
        userDao = session.getMapper(UserDao.class);
    }

    @Test
    public void testGetUserById(){
        User user = userDao.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setLogin_name("yyy");
        user.setPassword("123");
        user.setUserName("zxz");
        user.setSex(1);
        user.setMobile("1234678");
        user.setEmail("sdf@dfs.com");

        int i = userDao.addUser(user);
        System.out.println(i);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(46);
        user.setLogin_name("yyy");
        user.setSex(1);
        user.setMobile("1234678");
        user.setEmail("sdf@dfs.com");

        user.setUserName("aabbccdd");
        user.setPassword("098");

        int i = userDao.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void testDelUser(){
        int i = userDao.delUser(44);
        System.out.println(i);
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testGetUserByPage(){
        PageParam pageParam = new PageParam();
        pageParam.setBeginIndex(5);
        pageParam.setRowCount(5);
        List<User> userList = userDao.getUserByPageNo(pageParam);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    @Test
    public void testGetUserByPage2(){
        Map map = new HashMap();
        map.put("beginIndex",10);
        map.put("rowCount",3);
        List<User> userList = userDao.getUserByPageNo2(map);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }


    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }
}
