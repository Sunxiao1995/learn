package club.banyuan.service;

import club.banyuan.entity.User;
import java.sql.SQLException;

public interface UserService {
  public User getUser(String username, String password) throws SQLException;
  public int register(User user) throws SQLException;
  public boolean isUserExists(String userName) throws SQLException;

}
