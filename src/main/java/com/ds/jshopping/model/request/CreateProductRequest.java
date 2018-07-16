package com.ds.jshopping.model.request;

import com.ds.jshopping.model.Product;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("hiding")
@Component
public class CreateProductRequest<Product> implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String payLoad;

  //  Product product;

    List<Product> productList;

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }






}
