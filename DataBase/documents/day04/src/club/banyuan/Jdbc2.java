package club.banyuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root","rootroot");
            stmt = conn.createStatement();
//            int i = stmt.executeUpdate("insert into dept values(null,'销售一部','南京')");
//            i += stmt.executeUpdate("insert into dept values(null,'销售二部','南京')");
//            i +=i stmt.executeUpdate("insert into dept values(null,'人事部','南京')");

            int i = stmt.executeUpdate("update dept set dept_location='上海' where dept_name='销售二部'");
            System.out.println(i>0 ? "ok" : "faile");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
