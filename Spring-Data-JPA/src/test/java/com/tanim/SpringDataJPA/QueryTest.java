package com.tanim.SpringDataJPA;

import com.tanim.SpringDataJPA.Dao.ProductDao;
import com.tanim.SpringDataJPA.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class QueryTest {

    @Autowired
    public ProductDao productDao;

    @Test
    void saveProducts()
    {
        Product p1=new Product(1,"CoCaCola","EnergyDrink");
        Product p2=new Product(2,"Sprite","EnergyDrink");
        Product p3=new Product(3,"Fanta","EnergyDrink");

        List<Product>products=new ArrayList<>();

        products.add(p2);
        products.add(p3);
        productDao.saveAll(products);

    }
    @Test
   void findingProducts() {
       List<Product> products = productDao.findByNameOrDes("CoCaCola","EnergyDrink");

       products.forEach(product ->
       {
           System.out.println(product.getName());
           System.out.println(product.getDes());
       });
   }
}
