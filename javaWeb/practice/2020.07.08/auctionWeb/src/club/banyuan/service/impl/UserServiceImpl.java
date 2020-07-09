package club.banyuan.service.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.util.JdbcUtils;
import com.mysql.cj.jdbc.JdbcConnection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {


  @Override
  public User getUser(String username, String password) throws SQLException {
    IUserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
    return userDao.getUser(username,password);
  }

  @Override
  public int register(User user) throws SQLException {
    IUserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
    return userDao.add(user);
  }

  @Override
  public boolean isUserExists(String userName) throws SQLException {
    IUserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
    return userDao.isUserExists(userName);
  }
}
