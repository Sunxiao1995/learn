package club.banyuan.service.impl;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import club.banyuan.service.AddressService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
private AddressDao addressDao;

  @Override
  public Address getAddressByUser(User user) throws SQLException {

    return addressDao.getAddressByUserId(user);
  }


  @Override
  public int saveAddress(Address address) throws SQLException {

    return 0;
  }
}
