package com.wipro.bankofamerica.estore.repository;

import com.wipro.bankofamerica.estore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    Product findById(Integer Id);
//    Product deleteById(Integer id);
}
