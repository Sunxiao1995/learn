package club.banyuan.dao;


import club.banyuan.entity.User;

public interface userDao{
  public int addUser(User user);
  public User getLoginUser(User user);
}
