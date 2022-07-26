package com.flipkartclone.orders.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flipkartclone.orders.model.Product;


@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:9091")
public interface ProductClient {

    @GetMapping(value = "/find/{productId}")
    public Product getProductById(@PathVariable int productId);

}
