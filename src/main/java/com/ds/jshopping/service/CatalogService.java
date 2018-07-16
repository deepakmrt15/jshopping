package com.ds.jshopping.service;

import com.ds.jshopping.model.Catalog;
import com.ds.jshopping.model.CatalogInfo;
import com.ds.jshopping.model.Product;
import com.ds.jshopping.repository.CatalogInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

public class CatalogService {
    private CatalogInfoRepository catalogInfoRepository;
    private RestTemplate restTemplate;

    @Autowired
    public CatalogService(CatalogInfoRepository catalogInfoRepository,
                          RestTemplate restTemplate) {
        this.catalogInfoRepository = catalogInfoRepository;
        this.restTemplate = restTemplate;
    }


    public Catalog getCatalog() {
        Catalog catalog;

        CatalogInfo activeCatalog = catalogInfoRepository.findCatalogByActive(true);

        catalog = restTemplate.getForObject(String.format("http://localhost:8080/jshopping/catalogs/search/findCatalogByCatalogNumber?catalogNumber=%s",
                activeCatalog.getCatalogId()), Catalog.class);

        ProductsResource products = restTemplate.getForObject(String.format("http://localhost:8080/jshopping/catalogs/%s/products",
                catalog.getId()), ProductsResource.class);

        catalog.setProducts(products.getContent().stream().collect(Collectors.toSet()));
        return catalog;
    }


    public Product getProduct(String productId) {
        return restTemplate.getForObject(String.format("http://ilocalhost:8080/jshopping/v1/products/%s",
                productId), Product.class);
    }
}
