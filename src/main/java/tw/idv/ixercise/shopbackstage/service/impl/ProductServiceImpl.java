package tw.idv.ixercise.shopbackstage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.shopbackstage.dao.ProductRepository;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(Integer id) {


        return repo.findByProductId(id);
    }

    @Override
    public Core addProduct(Product product){

        if(repo.save(product) != null){
            return new Core(true,"新增成功");
        }
        return new Core(false,"新增失敗");
    }
}
