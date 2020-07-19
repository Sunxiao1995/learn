package club.banyuan.service.impl;


import club.banyuan.dao.userDao;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private userDao userDao;

  @Override
  public User login(User user) throws Exception {

  return userDao.getLoginUser(user);
  }

  @Override
  public int register(User user) throws Exception {

    return userDao.addUser(user);
  }
}
