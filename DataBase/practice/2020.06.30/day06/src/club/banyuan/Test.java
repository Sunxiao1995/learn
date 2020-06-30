package club.banyuan;

import club.banyuan.dao.impl.userDaoImpl;
import club.banyuan.dao.userDao;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {

  public static void main(String[] args) throws SQLException {
    Connection conn = JdbcUtils.getConnection();
    userDao userDao = new userDaoImpl(conn);
    User newUser = new User(null,"kkkk","realName","123",1,"14022529231991992","dfs@sdf.com","12345666673",1);
    int id = userDao.add(newUser);
    System.out.println(id);
  }
}
