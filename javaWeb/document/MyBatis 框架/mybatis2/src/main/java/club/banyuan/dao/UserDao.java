package club.banyuan.dao;

import club.banyuan.entity.User;
import club.banyuan.vo.PageParam;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> getAll();
    public User getUserById(int id);
    public int addUser(User user);
    public int updateUser(User user);
    public int delUser(int id);
    public int findTotal();
    public List<User> getUserByPageNo(PageParam param);
    public List<User> getUserByPageNo2(Map map);
}
