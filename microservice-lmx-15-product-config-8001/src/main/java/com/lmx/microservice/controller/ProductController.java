package com.lmx.microservice.controller;


import com.lmx.microservice.entity.Product;
import com.lmx.microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope //使用配置文件里面的变量，postman请求后，代码里面的变量才会改变
@RestController
public class ProductController {
    @Value("${emp.name}")
    private String name;
    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String hello(){
        return name;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

}
