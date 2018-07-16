package com.ds.jshopping.util;

import com.ds.jshopping.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

public static void main(String [] args){
    try {
        readCSV ();
    }catch (IOException e){
        e.getMessage();
    }


}
    public static void readCSV ()throws IOException{

        Product product = new Product();
        List<Product> productList = new ArrayList<>();

        String csvFile = "/Users/deepaksharma/myproject/jshopping/server/src/main/resources/testData/productData.csv";
        String line = "";
        String cvsSplitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String[] prdTokens = null;
        try  {

            while ((line = br.readLine()) != null) {
                prdTokens = line.split(cvsSplitBy);
             //   System.out.println("Prouct [name= " + prdTokens[0] + " , Category=" + prdTokens[1] + "]");
                product = new Product();
                product.setName(prdTokens[0]);
                product.setCategory(prdTokens[1]);
                product.setPrice(prdTokens[2]);
                product.setImagepath(prdTokens[3]);
                productList.add(product);
            }
            System.out.println("Prouct List Size: " + productList.size());
            System.out.println("Prouct Array Size: " + productList.toArray().length);
            for (Product p :productList){
                System.out.println("Prouct [name= " + p.getName() + " , Price=" + p.getPrice() + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
          br.close();
        }

    }
}
