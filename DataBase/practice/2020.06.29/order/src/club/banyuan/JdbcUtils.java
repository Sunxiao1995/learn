package club.banyuan;

import java.sql.*;

public class JdbcUtils {
  //    设置jdbc连接数据库的url，登录数据库的用户名和密码
  private static String DB = "db1";
  private static String URLSTR = "jdbc:mysql://127.0.0.1:3306/";
  private static String USER = "root";
  private static String PWD = "Sunxiao919644.";

  public static Connection getConnection(String dbName) throws SQLException {
    String url=URLSTR+DB;
    if (dbName != null && dbName != "") {
      url = URLSTR + dbName;
    }
    Connection conn = DriverManager.getConnection(url, USER, PWD);
    return conn;
  }

  public static void close(Connection conn, Statement stmt) throws SQLException {
    if (stmt != null) {
      stmt.close();
    }
    if (conn != null) {
      conn.close();
    }
  }

  public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
    if(rs !=null){
      rs.close();
    }
    if (stmt != null) {
      stmt.close();
    }
    if (conn != null) {
      conn.close();
    }
  }
}
