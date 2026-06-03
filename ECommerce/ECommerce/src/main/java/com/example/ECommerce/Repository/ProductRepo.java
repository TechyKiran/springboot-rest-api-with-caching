package com.example.ECommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
