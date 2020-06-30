package club.banyuan.service;

import club.banyuan.entity.Product;
import club.banyuan.util.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Order {

  private static Connection conn = null;
  private static PreparedStatement pstmt = null;
  private static ResultSet rs = null;
  private static Map<Product, Integer> map = new HashMap();
  private static Integer userId = null;
  private static String loginName = null;

  public static void main(String[] args) throws SQLException {

    conn = JdbcUtils.getConnection("shopping");
    validate();
    queryProduct();
    createOrder();
    searchOrder();
    JdbcUtils.close(conn, pstmt, rs);


  }


  /**
   * 登陆 如果失败则重新输入或者创建新用户
   *
   * @throws SQLException
   */

  public static void validate() throws SQLException {

    Scanner sc = new Scanner(System.in);
    System.out.println("请输入用户名：");
    String name = sc.nextLine();
    System.out.println("请输入密码：");
    String password = sc.nextLine();

    String sql = "select * from user where loginName=? and password=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setString(2, password);

    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
      userId = rs.getInt(1);
      loginName = rs.getString(2);
      System.out.println("验证成功，已登陆");
    } else {
      System.out.println("登录名或密码错误，输入1重新登陆，输入2创建新账号");
      Scanner scanner = new Scanner(System.in);
      String choose = scanner.nextLine();
      if ("2".equals(choose)) {
        register();
      }
      validate();
    }
  }


  /**
   * 创建一个新用户 这里创建新用户名重复会抛出异常 为进行处理
   *
   * @throws SQLException
   */
  public static void register() throws SQLException {
    System.out.println("正在创建新用户");
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入用户名：");
    String name = sc.nextLine();
    System.out.println("请输入密码：");
    String password = sc.nextLine();
    String sql = "insert into user (id,loginName,password) values(null,?,?);";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setString(2, password);
    pstmt.executeUpdate();
    System.out.println("创建用户成功，请重新登陆");
  }


  /**
   * 查询商品 将商品的基本信息保存在map中 作为Key 准备购买的数量作为value
   */
  private static void queryProduct() throws SQLException {
    System.out.println("请输入需要查询的商品名称");
    Scanner sc = new Scanner(System.in);
    String product = "%" + sc.nextLine() + "%";
    String sql = "select * from product where name like ? or description like ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, product);
    pstmt.setString(2, product);
    rs = pstmt.executeQuery();

    while (rs.next()) {
      Product aProduct = new Product();
      aProduct.setId(rs.getInt(1));
      aProduct.setName(rs.getString(2));
      aProduct.setPrice(rs.getFloat(4));
      aProduct.setStock(rs.getInt(5));
      System.out.println(aProduct);
      System.out.println("请输入此种商品购买的数量");
      Scanner scanner = new Scanner(System.in);
      Integer purchaseQuantity = scanner.nextInt();
      map.put(aProduct, purchaseQuantity);
    }
  }

  /**
   * 创建订单
   *
   * @throws SQLException
   */
  private static void createOrder() throws SQLException {
    String sql = "insert into `order` (id,userId,loginName,createTime,cost) values (null,?,?,'2018-02-16 17:31:59',?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, userId);
    pstmt.setString(2, loginName);
    float cost = 0;
    Iterator<Map.Entry<Product, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Product, Integer> entry = iterator.next();
      cost += (entry.getValue()) * (entry.getKey().getPrice());
    }
    pstmt.setFloat(3, cost);
    pstmt.executeUpdate();
  }


  /**
   * 查询订单
   *
   * @throws SQLException
   */
  public static void searchOrder() throws SQLException {
    String sql = "select * from order where loginName = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, "aaa");
    rs = pstmt.executeQuery();
    while (rs.next()) {
      Integer id = rs.getInt(1);
      Integer userId = rs.getInt(2);
      String loginName = rs.getString(3);
      String userAddress = rs.getString(4);
      Date createTime = rs.getDate(5);
      Float cost = rs.getFloat(6);
      String serialNUmber = rs.getString(7);

      System.out
          .println("id:" + id + "  userId:" + userId + "  loginName:" + loginName + "  userAddress"
              + userAddress + "  createTime:" + createTime + "  cost:" + cost + "  serialNUmber:"
              + serialNUmber);
    }
  }


}
