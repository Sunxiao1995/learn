package club.banyuan.Service;

import club.banyuan.Entity.User;
import java.sql.SQLException;

public interface UserService {
  public User login(String username, String password) throws SQLException;
  public int register(User user) throws SQLException;

}
