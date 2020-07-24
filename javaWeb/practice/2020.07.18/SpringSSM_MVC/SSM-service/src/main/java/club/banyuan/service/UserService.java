package club.banyuan.service;

import club.banyuan.entity.User;


public interface UserService {
  public User login(User user) throws Exception;
  public int register(User user) throws Exception;

}
