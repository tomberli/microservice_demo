package com.lmx.microservice.service;


import com.lmx.microservice.entity.Product;

import java.util.List;

public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();

}
