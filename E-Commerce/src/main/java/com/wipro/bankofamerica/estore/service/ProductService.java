package com.wipro.bankofamerica.estore.service;

import com.wipro.bankofamerica.estore.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    public Iterable<Product> getAllProduct();

    public Product saveProduct(Product product);

     public Optional<Product> getProductById(Long id);

    public void deleteProduct(Long id);

    public Product updateProduct(Long id, Product productDetails);

}
