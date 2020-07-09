package club.banyuan.dao.impl;

import club.banyuan.dao.IAdminDao;
import club.banyuan.entity.Admin;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao {

  public AdminDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Admin getAdmin(String loginName, String pwd) {
    Admin admin = new Admin();
    String sql = "select * from admin where loginName=? and password=?";
    Object [] params = new Object[]{loginName,pwd};
    ResultSet rs = executeQuery(sql,params);
    try {
      admin =  tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return admin;
  }

  @Override
  public Admin tableToClass(ResultSet rs) throws Exception {
    Admin admin = new Admin();
    if (rs.next()){
      admin.setId(rs.getInt(1));
      admin.setLoginName(rs.getString(2));
      admin.setPassword(rs.getString(3));
    }
    return admin;
  }
}
