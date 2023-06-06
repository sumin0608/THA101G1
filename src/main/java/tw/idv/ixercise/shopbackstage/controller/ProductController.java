package tw.idv.ixercise.shopbackstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.shopbackstage.entity.Product;
import tw.idv.ixercise.shopbackstage.service.ProductManagementService;
import tw.idv.ixercise.shopbackstage.service.ProductService;

import java.io.File;
import java.io.IOException;
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
    public Core remove(@PathVariable("id") Integer id) {
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
//上傳圖片===================================================================================
    @PostMapping("uploadshopphoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上傳的文件為空";
        }
        try {
            String projectRootPath = System.getProperty("user.dir");
            String relativePath = "src/main/webapp/lib/img/";
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            // 建存储路径
            String filePath = projectRootPath + "/" + relativePath + "/" + fileName;
            // 创建目标文件对象
            File destFile = new File(filePath);
            System.out.println("儲存位置>>" + destFile);
            file.transferTo(destFile);
            // 返回存储的文件路径，可以在保存评论的控制器中使用?
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "文件上傳失敗";
        }
    }
    @PostMapping("AddProduct")
    public Core addPd(@RequestBody Product product){
        if (product == null){
            return new Core(false,"請填寫商品資訊");
        }
        return service.addProduct(product);
    }
}
