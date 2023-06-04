package tw.idv.ixercise.shopbackstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("Shop")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("Manage")
    public List<Product> manage() {

        return service.findAll();
    }
    @GetMapping({"Manage/{id}"})
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

//    @DeleteMapping("{accountId}")
//    public Core remove(@PathVariable Integer accountId) {
//        final Core core = new Core();
//        if (accountId == null) {
//            core.setMessage("無會員Id");
//            core.setSuccessful(false);
//        } else {
//            core.setSuccessful(service.remove(accountId));
//        }
//        return core;
//    }
//
//    @PutMapping
//    public Core save(@RequestBody Account account) {
//        final Core core = new Core();
//        if (account == null) {
//            core.setMessage("無會員資訊");
//            core.setSuccessful(false);
//        } else {
////           如何判斷是否修改成功??
//            service.save(account);
//            core.setMessage("修改成功");
//            core.setSuccessful(true);
//        }
//        return core;
//    }

}


