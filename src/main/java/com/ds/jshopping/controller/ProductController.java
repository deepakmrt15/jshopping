package com.ds.jshopping.controller;

import com.ds.jshopping.model.Product;
import com.ds.jshopping.model.request.CreateProductRequest;
import com.ds.jshopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return productRepository.findOne(blogId);
    }

   // @PostMapping(value ="/productReq/create")
   // @RequestMapping(value="/productReq/create", method = RequestMethod.POST)

    @RequestMapping(value = "/products/create", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity createProduct(@RequestBody CreateProductRequest<Product> productReq) {

       List<Product> productList = productReq.getProductList();
        productRepository.save(productList);

//       productRepository.save(new Product(productReq.getProduct().getName(),
//               productReq.getProduct().getCategory(), productReq.getProduct().getImagepath(),
//               productReq.getProduct().getPrice()));
      // return productRepository.findAll();

        return new ResponseEntity("message: ", HttpStatus.OK);
    }


}
