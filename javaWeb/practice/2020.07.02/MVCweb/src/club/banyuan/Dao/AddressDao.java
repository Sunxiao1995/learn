package club.banyuan.Dao;

import club.banyuan.Entity.Address;
import club.banyuan.Entity.Order;
import club.banyuan.Entity.User;

public interface AddressDao extends IBaseDao {
  public Address getAddressByUserId (User user);

  public int saveAddress (Address address);

}
