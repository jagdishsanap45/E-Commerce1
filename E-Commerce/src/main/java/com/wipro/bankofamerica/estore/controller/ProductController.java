package com.wipro.bankofamerica.estore.controller;

import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.service.ProductService;
import com.wipro.bankofamerica.estore.serviceImpl.ProductServiceImpl;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @Autowired
//    private ProductServiceImpl productServiceImpl;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saveProduct = productService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Available");
        }
    }
//    @PutMapping("/update")
//    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
//        Product updatedProduct = productService.updateProduct(product);
//        return ResponseEntity.ok(updatedProduct);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
       }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.ok("Record is deleted.");
//    }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteProduct (@PathVariable Long id){
            try {
                productService.deleteProduct(id);
                return ResponseEntity.ok("Deleted");
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
           }
         }

