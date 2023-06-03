package tw.idv.ixercise.shopbackstage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductService;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    List<ProductEntity> findAll();

    @Query(
            value = "select * from PRODUCT where id = :id",
            nativeQuery = true
    )
    Product findByProductId(Integer id);
}
