package com.prueba.demoyaml.api.service;

import com.prueba.demoyaml.api.ProductRepository;
import com.prueba.demoyaml.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductAsyncService {

    private final ProductRepository repository;
    private final ThreadPoolTaskExecutor getProductsExecutor;


    @Async("asyncExecutor")
    public CompletableFuture<List<Product>> getProducts() throws InterruptedException {
        Thread.sleep(1000);
        List<Product> list = Arrays.asList(new Product(1, "product 1"), new Product(2, "product 2"), new Product(3, "product 3"));
        return CompletableFuture.completedFuture(list);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Product>> getProducts2() throws InterruptedException {
        Thread.sleep(3000);
        List<Product> list = Arrays.asList(new Product(4, "product 4"), new Product(5, "product 5"), new Product(6, "product 6"));

        return CompletableFuture.completedFuture(list);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Product>> getProducts3() throws InterruptedException {
        Thread.sleep(2000);
        List<Product> list = Arrays.asList(new Product(7, "product 7"), new Product(8, "product 8"), new Product(9, "product 9 "));
        return CompletableFuture.completedFuture(list);
    }

    //    @Async("getProductsExecutor")
    public List<Product> getFullProducts() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Product>> productosRepository = getProductosRepository();
        CompletableFuture<List<Product>> productosRepository2 = getProductosRepository2();
        CompletableFuture<List<Product>> productosRepository3 = getProductosRepository3();

        CompletableFuture.allOf(productosRepository, productosRepository2, productosRepository3);
        List<Product> productList = Stream.of(productosRepository.get(), productosRepository2.get(), productosRepository3.get()).flatMap(Collection::stream).toList();
        return productList;
    }


    private CompletableFuture<List<Product>> getProductosRepository() {
        return CompletableFuture.supplyAsync(() -> repository.getProducts(), getProductsExecutor);
    }

    private CompletableFuture<List<Product>> getProductosRepository2() {
        return CompletableFuture.supplyAsync(() -> repository.getProducts2(), getProductsExecutor);
    }

    private CompletableFuture<List<Product>> getProductosRepository3() {
        return CompletableFuture.supplyAsync(() -> repository.getProducts3(), getProductsExecutor);
    }
}
