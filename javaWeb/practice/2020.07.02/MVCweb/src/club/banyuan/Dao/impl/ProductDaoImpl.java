package club.banyuan.Dao.impl;



import club.banyuan.Dao.ProductDao;
import club.banyuan.Entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

  public ProductDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<Product> getProductByKeyword(String keyword) {
    List<Product> list = new ArrayList<>();
    String sql = "select * from product where name like ? or description like ?";
    Object [] params = new Object[]{"%"+keyword+"%","%"+keyword+"%"};
    ResultSet rs = executeQuery(sql,params);
    try {
      list = tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public List<Product> tableToClass(ResultSet rs) throws Exception {
    List<Product> list = new ArrayList<>();
    while (rs.next()){
      Product product = new Product();
      product.setId(rs.getInt(1));
      product.setName(rs.getString(2));
      product.setDescription(rs.getString(3));
      product.setPrice(rs.getDouble(4));
      product.setStock(rs.getInt(5));
      product.setCategoryLevel1Id(rs.getInt(6));
      product.setCategoryLevel2Id(rs.getInt(7));
      product.setCategoryLevel3Id(rs.getInt(8));
      product.setFileName(rs.getString(9));
      product.setIsDelete(rs.getInt(10));
      list.add(product);
    }
    return list;
  }


}
