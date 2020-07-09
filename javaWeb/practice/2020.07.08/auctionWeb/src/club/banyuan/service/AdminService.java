package club.banyuan.service;

import club.banyuan.entity.Admin;
import club.banyuan.entity.User;
import java.sql.SQLException;

public interface AdminService {
  public Admin getAdmin(String username, String password) throws SQLException;
}
