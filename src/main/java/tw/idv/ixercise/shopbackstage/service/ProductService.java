package tw.idv.ixercise.shopbackstage.service;

import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.shopbackstage.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    Core addProduct(Product product);
}
