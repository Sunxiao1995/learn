package club.banyuan.Dao;


import club.banyuan.Entity.Product;
import java.util.List;

public interface ProductDao extends IBaseDao {

    public List<Product> getProductByKeyword(String keyword);
}
