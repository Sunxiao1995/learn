package club.banyuan.mapper;

import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
  public Address getAddressByUserId (User user);

  public int saveAddress (Address address);

}
