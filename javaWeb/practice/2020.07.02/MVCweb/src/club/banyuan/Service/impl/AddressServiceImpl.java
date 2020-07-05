package club.banyuan.Service.impl;

import club.banyuan.Dao.AddressDao;
import club.banyuan.Dao.impl.AddressDaoImpl;
import club.banyuan.Entity.Address;
import club.banyuan.Entity.User;
import club.banyuan.Service.AddressService;
import club.banyuan.Util.JdbcUtils;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressServiceImpl implements AddressService {


  @Override
  public Address getAddressByUser(User user) throws SQLException {
    AddressDao addressDao = new AddressDaoImpl(JdbcUtils.getConnection());
    Address address = addressDao.getAddressByUserId(user);
    return address;
  }

  @Override
  public Address getAddressByRequest(String[] request) {
    Address address = new Address();
    address.setId(Integer.valueOf(request[0]));
    address.setUserId(Integer.valueOf(request[1]));
    address.setAddress(request[2]);
    address.setCreateTime(Date.valueOf(request[3]));
    address.setIsDefault(Integer.valueOf(request[4]));
    address.setRemake(request[5]);

    return address;
  }

  @Override
  public int saveAddress(Address address) throws SQLException {
    AddressDao addressDao = new AddressDaoImpl(JdbcUtils.getConnection());
    int i =  addressDao.saveAddress(address);
    return i;
  }
}
