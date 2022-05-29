package com.celean.spring3.services;

import com.celean.spring3.model.Product;
import com.celean.spring3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }
    public void increaseCost(Long id){
        productRepository.increaseCost(id);
    }
    public void decreaseCost(Long id){
        productRepository.decreaseCost(id);
    }
}
