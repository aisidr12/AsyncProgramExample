package com.prueba.demoyaml.controller;

import com.prueba.demoyaml.api.service.ProductAsyncService;
import com.prueba.demoyaml.api.service.ProductService;
import com.prueba.demoyaml.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@RequestMapping("/api/controller")
@RestController
@Slf4j
public class ProductController {


    private final ProductService service;
    private final ProductAsyncService asyncService;

    public ProductController(ProductService service, ProductAsyncService asyncService) {
        this.service = service;
        this.asyncService = asyncService;
    }


    @GetMapping
    public List<Product> getAllProducts() throws InterruptedException {
        long start = System.currentTimeMillis();

        List<Product> lista1 = service.getProducts();
        List<Product> lista2 = service.getProducts2();
        List<Product> lista3 = service.getProducts3();
        List<Product> lista4 = Stream.of(lista1, lista2, lista3).flatMap(Collection::stream).toList();
        long end = System.currentTimeMillis();
        log.info("tiempo ejecutrado {}", end - start);
        return lista4;
    }

    @GetMapping("/async")
    public List<Product> getAllProductAsync() throws Exception {
        CompletableFuture<List<Product>> products = asyncService.getProducts();
        CompletableFuture<List<Product>> products2 = asyncService.getProducts2();
        CompletableFuture<List<Product>> products3 = asyncService.getProducts3();
        CompletableFuture.allOf(products, products2, products3).join();
        List<Product> list4 = Stream.of(products.get(), products2.get(), products3.get()).flatMap(Collection::stream).toList();
        return list4;
    }

    @GetMapping("/test")
    public List<Product> testing() throws ExecutionException, InterruptedException {
        List<Product> fullProducts = asyncService.getFullProducts();
        return fullProducts;
    }
}
