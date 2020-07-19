package club.banyuan.dao;


import club.banyuan.entity.User;
import java.sql.SQLException;

public interface userDao{
  public int addUser(User user) throws SQLException;
  public User getLoginUser(User user) throws Exception;
}
