package tw.idv.ixercise.shopbackstage.service;

import tw.idv.ixercise.shopbackstage.entity.Product;

public interface ProductManagementService {
    boolean removeProduct(Integer id);

    void saveProduct(Product product);
}
