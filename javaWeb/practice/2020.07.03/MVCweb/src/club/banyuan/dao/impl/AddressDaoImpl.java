package club.banyuan.dao.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;

public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

  public AddressDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Address getAddressByUserId(User user) {
    String sql = "select * from user_address where userId = ? and isDefault = 1";
    Object [] params = new Object[]{user.getId()};
    ResultSet rs = executeQuery(sql, params);
    Address address = new Address();

    try {
      address = tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return address;
  }

  @Override
  public int saveAddress(Address address) {

    String sql="insert into user_address values (null,?,?,?,?,?)";
    Object [] params = new Object[]{address.getUserId(),address.getAddress(),address.getCreateTime(),
        address.getIsDefault(),address.getRemake()};
    int i = executeInsert(sql,params);

    return i;

  }

  @Override
  public Address tableToClass(ResultSet rs) throws Exception {
    Address address = new Address();
    if(rs.next()){
      address.setId(rs.getInt(1));
      address.setUserId(rs.getInt(2));
      address.setAddress(rs.getString(3));
      address.setCreateTime(rs.getDate(4));
      address.setIsDefault(rs.getInt(5));
      address.setRemake(rs.getString(6));
    }
    return address;
  }
}
