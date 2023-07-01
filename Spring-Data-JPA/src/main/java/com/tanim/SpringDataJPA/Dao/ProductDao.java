package com.tanim.SpringDataJPA.Dao;

import com.tanim.SpringDataJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends  JpaRepository<Product,Integer> {

    public List<Product> findByNameOrDes(String name, String des);
}
