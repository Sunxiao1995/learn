package club.banyuan.service;

import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import java.sql.SQLException;

public interface AddressService {
  public Address getAddressByUser(User user) throws SQLException;


  public int saveAddress (Address address) throws SQLException;

}
