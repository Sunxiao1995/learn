package club.banyuan.mapper;


import club.banyuan.entity.User;
import java.sql.SQLException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
  public int addUser(User user) throws SQLException;
  public User getLoginUser(User user) throws Exception;
}
