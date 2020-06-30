package club.banyuan.dao;

import club.banyuan.entity.Product;
import java.util.List;

public interface ProductDao extends IBaseDao {

    public List<Product> getProductByKeyword(String keyword);
}
