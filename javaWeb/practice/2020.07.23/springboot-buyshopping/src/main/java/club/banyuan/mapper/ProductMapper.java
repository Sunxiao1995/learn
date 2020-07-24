package club.banyuan.mapper;


import club.banyuan.entity.Product;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    public List<Product> getProductByKeyword(String keyword);
    public Product getProductById(Integer id);
}
