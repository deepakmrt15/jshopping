package com.ds.jshopping.product;


import com.ds.jshopping.model.Product;
import com.ds.jshopping.model.request.CreateProductRequest;
import com.ds.jshopping.service.ProductService;
import com.ds.jshopping.util.JsonUtils;
import com.ds.jshopping.util.TestDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Component
public class CreateProductTest {

    @Autowired  ProductService productService;



@Test(groups = "product",enabled = true, dataProvider="createProduct", dataProviderClass=TestDataProvider.class)
public void testCreateProducts(Product[] createProduct){

//System.out.println("createProduct len: "+createProduct.length);
    
CreateProductRequest<Product> request=   createProductRequestPayload(createProduct);
 System.out.println("request : "+JsonUtils.converToJson(request));

//System.out.println("request len: "+request.getProductList().size());
productService = new ProductService();
productService.createProduct(createProductRequestPayload(createProduct));


}

public CreateProductRequest<Product> createProductRequestPayload(Product [] createProduct){

 List<Product> prdList =  Arrays.asList(createProduct);


    CreateProductRequest<Product> request = new CreateProductRequest<Product>();
    request.setProductList(Arrays.asList((Product[])createProduct));
     return request;
}

}
