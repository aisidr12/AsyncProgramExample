package com.prueba.demoyaml.api;

import com.prueba.demoyaml.model.Product;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    public List<Product> getProducts() {
        try {
            Thread.sleep(6000);

        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }
        List<Product> list = Arrays.asList(new Product(1, "product 1"), new Product(2, "product 2"), new Product(3, "product 3"));
        return list;
    }

    public List<Product> getProducts2() {
        try {
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }
        List<Product> list = Arrays.asList(new Product(4, "product 4"), new Product(5, "product 5"), new Product(6, "product 6"));
        return list;
    }

    public List<Product> getProducts3() {
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }
        List<Product> list = Arrays.asList(new Product(7, "product 7"), new Product(8, "product 8"), new Product(9, "product 9 "));
        return list;
    }

}
