package club.banyuan.Dao.impl;


import club.banyuan.Dao.userDao;
import club.banyuan.Entity.User;
import java.sql.Connection;
import java.sql.ResultSet;

public class userDaoImpl extends BaseDaoImpl implements userDao {


  public userDaoImpl(Connection connection) {
    super(connection);
  }

  /**
   * 用户注册
   * @param user
   * @return
   */
  @Override
  public int add(User user) {
    String sql = "insert into user(id,loginName,userName,password,sex,email,mobile) values(null,?,?,?,?,?,?)";
    Object [] params = new Object[]{user.getLoginName(),user.getUserName(),
        user.getPassword(),user.getSex(),user.getEmail(),user.getMobile()};
    int i = executeInsert(sql,params);
    return i;
  }


  /**
   * 登陆
   * @param loginName
   * @param pwd
   * @return
   */
  @Override
  public User getLoginUser(String loginName, String pwd) {
    User user = new User();
    String sql = "select * from user where loginName=? and password=?";
    Object [] params = new Object[]{loginName,pwd};
    ResultSet rs = executeQuery(sql,params);
    try {
      user =  tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User();
    if (rs.next()){
      user.setId(rs.getInt(1));
      user.setLoginName(rs.getString(2));
      user.setUserName(rs.getString(3));
      user.setSex(rs.getInt(5));
      user.setIdentityCode(rs.getString(6));
      user.setEmail(rs.getString(7));
      user.setMobile(rs.getString(8));
      user.setType(rs.getInt(9));
    }
    return user;
  }
}
