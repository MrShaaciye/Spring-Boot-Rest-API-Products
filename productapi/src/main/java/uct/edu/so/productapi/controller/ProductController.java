package uct.edu.so.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uct.edu.so.productapi.model.ProductModel;
import uct.edu.so.productapi.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public List<ProductModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getproductbyid/{id}")
    public ProductModel getProductByid(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/getproductbyname/{name}")
    public ProductModel getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PostMapping("/insertproducts")
    public List<ProductModel> insertProducts(@RequestBody List<ProductModel> productModels){
        return productService.insertProducts(productModels);
    }

    @PostMapping("/insertproduct")
    public ProductModel insertProduct(@RequestBody ProductModel productModels){
        return productService.insertProduct(productModels);
    }

    @PutMapping("/updateproduct")
    public ProductModel updateProduct(@RequestBody ProductModel productModel){
        return productService.updateProduct(productModel);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}

