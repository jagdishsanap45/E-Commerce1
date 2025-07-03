package com.wipro.bankofamerica.estore.serviceImpl;

import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.repository.ProductRepository;
import com.wipro.bankofamerica.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
//    public Product updateProduct(Product product) {
//        return productRepository.save(product);
//    }

    public Product updateProduct(Long id, Product productDetails){
         Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not Found"));
        existingProduct.setProductId(productDetails.getProductId());
        existingProduct.setProductName(productDetails.getProductName());
        existingProduct.setProductDescription(productDetails.getProductDescription());
        existingProduct.setQuantity(productDetails.getQuantity());
        existingProduct.setAmount(productDetails.getAmount());
        return productRepository.save(existingProduct);
    }
}
