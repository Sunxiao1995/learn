package club.banyuan.dao;

import club.banyuan.entity.User;
import java.sql.SQLException;

public interface IUserDao{
  public int addUser(User user);
  public User getUser(String userName,String pwd);
  public boolean isUserExists (String userName) throws SQLException;

}
