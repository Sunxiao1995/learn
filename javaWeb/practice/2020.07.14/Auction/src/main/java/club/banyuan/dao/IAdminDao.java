package club.banyuan.dao;

import club.banyuan.entity.Admin;
import java.util.Map;


public interface IAdminDao {
  public Admin getAdmin(Map<String,String> map);
}
