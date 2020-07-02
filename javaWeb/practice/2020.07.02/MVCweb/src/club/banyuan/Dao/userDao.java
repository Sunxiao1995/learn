package club.banyuan.Dao;


import club.banyuan.Entity.User;

public interface userDao extends IBaseDao {
  public int add(User user);
  public User getLoginUser(String loginName,String pwd);
}
