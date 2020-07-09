package club.banyuan.service.impl;

import club.banyuan.dao.IAdminDao;
import club.banyuan.dao.impl.AdminDaoImpl;
import club.banyuan.entity.Admin;
import club.banyuan.service.AdminService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {


  @Override
  public Admin getAdmin(String loginName, String password) throws SQLException {
    IAdminDao adminDao = new AdminDaoImpl(JdbcUtils.getConnection());
    Admin admin = adminDao.getAdmin(loginName,password);
    return admin;
  }
}
