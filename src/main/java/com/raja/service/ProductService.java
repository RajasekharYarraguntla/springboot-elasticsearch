package com.raja.service;

import com.raja.entity.Product;
import com.raja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Iterable<Product> getAll() {
        return  repository.findAll();
    }

    public Iterable<Product> saveProduct(Product product) {
        List<Product> products = new ArrayList<>();

        IntStream.range(1,1000).forEach(value -> {
            final Product pro = new Product();
            pro.setName(product.getName() + " : " + value);
            pro.setDescription(product.getDescription());
            pro.setPrice(product.getPrice());
            products.add(pro);
        });
        return repository.saveAll(products);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public Product updateProduct(Product product, Long id) {
        Product product1  = repository.findById(id).get();
        product1.setPrice(product.getPrice());
        return product1;
    }

    public void deleteProduct(Long id ) {
        repository.deleteById(id);
    }
}
