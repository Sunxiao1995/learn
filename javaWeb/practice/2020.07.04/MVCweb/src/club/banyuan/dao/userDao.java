package club.banyuan.dao;


import club.banyuan.entity.User;

public interface userDao extends IBaseDao {
  public int add(User user);
  public User getLoginUser(String loginName,String pwd);
}
