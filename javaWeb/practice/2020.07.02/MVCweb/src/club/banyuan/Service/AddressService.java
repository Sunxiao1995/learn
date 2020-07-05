package club.banyuan.Service;

import club.banyuan.Entity.Address;
import club.banyuan.Entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface AddressService {
  public Address getAddressByUser(User user) throws SQLException;

  public Address getAddressByRequest(String[] request);

  public int saveAddress (Address address) throws SQLException;

}
