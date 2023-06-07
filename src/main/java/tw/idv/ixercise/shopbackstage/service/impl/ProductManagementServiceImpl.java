package tw.idv.ixercise.shopbackstage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.ixercise.shopbackstage.dao.ProductRepository;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductManagementService;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductManagementServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean removeProduct(Integer id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}