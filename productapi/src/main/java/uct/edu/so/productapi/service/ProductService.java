package uct.edu.so.productapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uct.edu.so.productapi.model.ProductModel;
import uct.edu.so.productapi.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductModel getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public ProductModel getProductByName(String name){
        return productRepository.findByName(name);
    }

    public List<ProductModel> insertProducts(List<ProductModel> productModel){
        return productRepository.saveAll(productModel);
    }

    public ProductModel insertProduct(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public ProductModel updateProduct(ProductModel productModel){
       ProductModel exitsproductModel = productRepository.findById(productModel.getId()).orElse(null);
       exitsproductModel.setName(productModel.getName());
       exitsproductModel.setQuantity(productModel.getQuantity());
       exitsproductModel.setPrice(productModel.getPrice());
       return productRepository.save(exitsproductModel);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product deleted successfully! " + id;
    }
}
