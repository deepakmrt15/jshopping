package com.ds.jshopping.service;

import com.ds.jshopping.model.Product;
import com.ds.jshopping.model.request.CreateProductRequest;
import com.ds.jshopping.repository.CatalogInfoRepository;
import com.ds.jshopping.repository.ProductRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class ProductService {

    private ProductRepository productRepository;
    private RestTemplate restTemplate;


    public String createProduct(CreateProductRequest<Product> productReq) {
       String url = "";//"http://localhost:8080/products/create";
       System.out.println("Service level request len: "+productReq.getProductList().size());
       try {

          productRepository.save(productReq.getProductList());
       }catch (Exception e){
           url=   e.getLocalizedMessage();

       }


//        HttpEntity<Product> request = new HttpEntity<Product>();
//
//        ResponseEntity<Product> response = restTemplate.postForEntity( url, request , Product.class );


        return url;
    }
}
