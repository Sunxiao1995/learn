package club.banyuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root","rootroot");
            stmt = conn.createStatement();
            String sql = "create table dept(\n" +
                    "\tid int primary key auto_increment,\n" +
                    "    dept_name varchar(20) not null,\n" +
                    "    dept_location varchar(20) not null\n" +
                    ");";
            stmt.executeUpdate(sql);
            System.out.println("ok");
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
