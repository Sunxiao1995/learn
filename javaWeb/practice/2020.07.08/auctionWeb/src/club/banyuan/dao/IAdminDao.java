package club.banyuan.dao;

import club.banyuan.entity.Admin;


public interface IAdminDao extends IBaseDao{
  public Admin getAdmin(String loginName,String pwd);
}
