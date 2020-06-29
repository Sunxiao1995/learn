package club.banyuan;

import java.sql.*;
import java.util.Date;

public class Jdbc3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root","rootroot");
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from dept");
            while(rs.next()){
                int id = rs.getInt(1);
                String deptName = rs.getString(2);
                String location = rs.getString(3);
                Date setupDate = rs.getDate(4);

                System.out.println("id:"+id+"\t deptName:"+deptName
                        +"\tlocation:"+location+"\tsetupDate="+setupDate);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
