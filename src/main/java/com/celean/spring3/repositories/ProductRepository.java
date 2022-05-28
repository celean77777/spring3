package com.celean.spring3.repositories;

import com.celean.spring3.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(123L, "Pen", 10.30),
                new Product(313L, "Pencil", 10.40),
                new Product(678L, "Eraser", 5.20),
                new Product(876L, "Ruler", 67.40),
                new Product(234L, "Touch", 160.0)
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public void save(Product anyProduct) {
        products.add(anyProduct);
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}
