package tw.idv.ixercise.shopbackstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductManagementService;
import tw.idv.ixercise.shopbackstage.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("Shop")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductManagementService managementService;

    @GetMapping("Manage")
    public List<Product> manage() {
        return service.findAll();
    }

    @GetMapping("Manage/{id}")
    public Product findProductByIdFullInfo(@PathVariable Integer id) {
        Product pd = service.findById(id);

        if (pd == null) {
            Product pdNotFind = new Product();
            pdNotFind.setMessage("查無商品資料");
            pdNotFind.setSuccessful(false);
            return pdNotFind;
        } else {
            pd.setSuccessful(true);
            return pd;
        }
    }

    @DeleteMapping("Manage/{id}")
    public Core remove(@PathVariable Integer id) {
        Core core = new Core();
        if (id == null) {
            core.setMessage("無商品Id");
            core.setSuccessful(false);
        } else {
            boolean success = managementService.removeProduct(id);
            if (success) {
                core.setMessage("刪除成功");
                core.setSuccessful(true);
            } else {
                core.setMessage("刪除失敗");
                core.setSuccessful(false);
            }
        }
        return core;
    }

    @PutMapping("Manage")
    public Core save(@RequestBody Product product) {
        Core core = new Core();
        if (product == null) {
            core.setMessage("無商品資訊");
            core.setSuccessful(false);
        } else {
            managementService.saveProduct(product);
            core.setMessage("修改成功");
            core.setSuccessful(true);
        }
        return core;
    }
}
