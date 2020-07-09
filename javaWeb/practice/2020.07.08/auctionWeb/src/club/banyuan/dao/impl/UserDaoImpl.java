package club.banyuan.dao.impl;

import club.banyuan.dao.IBaseDao;
import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

  public UserDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int add(User user) {
    String sql = "insert into user values(null,?,?,?,?,?,?)";
    Object [] params = new Object[]{user.getUserName(),user.getPassword(),
        user.getIdentityNum(),user.getPhoneNum(),user.getAddress(),user.getPostalCode()};
    int i = executeInsert(sql,params);
    return i;
  }

  @Override
  public User getUser(String userName, String pwd) {
    User user = new User();
    String sql = "select * from user where userName=? and password=?";
    Object [] params = new Object[]{userName,pwd};
    ResultSet rs = executeQuery(sql,params);
    try {
      user =  tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public boolean isUserExists(String userName) throws SQLException {
    String sql = "select * from user where userName=?";
    Object [] params = new Object[]{userName};
    ResultSet rs = executeQuery(sql,params);
    if(rs.next()){
      return true;
    }
    return false;
  }

  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User();
    if (rs.next()){
      user.setId(rs.getInt(1));
      user.setUserName(rs.getString(2));
      user.setPassword(rs.getString(3));
      user.setIdentityNum(rs.getString(4));
      user.setPhoneNum(rs.getString(5));
      user.setAddress(rs.getString(6));
      user.setPostalCode(rs.getInt(7));
    }
    return user;
  }
}
