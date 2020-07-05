package club.banyuan.Service.impl;

import club.banyuan.Dao.impl.userDaoImpl;
import club.banyuan.Dao.userDao;
import club.banyuan.Entity.User;
import club.banyuan.Service.UserService;
import club.banyuan.Util.JdbcUtils;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

  @Override
  public User login(String username, String password) throws SQLException {

    userDao userDao = new userDaoImpl(JdbcUtils.getConnection());
    return userDao.getLoginUser(username,password);
  }

  @Override
  public int register(User user) throws SQLException {
    userDao userDao = new userDaoImpl(JdbcUtils.getConnection());
    return userDao.add(user);
  }
}
