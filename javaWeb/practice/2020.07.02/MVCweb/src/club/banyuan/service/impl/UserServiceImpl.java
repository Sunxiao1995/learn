package club.banyuan.service.impl;

import club.banyuan.dao.impl.userDaoImpl;
import club.banyuan.dao.userDao;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
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
