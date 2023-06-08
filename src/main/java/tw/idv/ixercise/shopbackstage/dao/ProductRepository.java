package tw.idv.ixercise.shopbackstage.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductService;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    List<ProductEntity> findAll();

    // 添加新增、删除和修改的方法定义
    void deleteById(Integer id);
    Product save(Product product);
    @Query(
            value = "select * from PRODUCT where id = :id",
            nativeQuery = true
    )
    Product findByProductId(Integer id);

}
