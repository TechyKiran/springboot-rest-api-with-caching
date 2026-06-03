package com.example.ECommerce.Service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.Model.Product;
import com.example.ECommerce.Repository.ProductRepo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
//Getting Product list
	@Cacheable(cacheNames = "Products")
	public List<Product> getProducts() {
		
		return repo.findAll();
	}
	
//Inserting the product details
	@CacheEvict(cacheNames = "Products",allEntries = true)
	public Product saveProducts(Product prod) {
	    return repo.save(prod);
	}
	
//Getting the Details of the Single Product

	@Cacheable(cacheNames="Product", key="#id")
	public Product getProductById(int id) {
		
		return repo.findById(id).orElse(null);
	}
//Delete The Product By Id
	@Caching(evict = {
		    @CacheEvict(cacheNames = "Products", allEntries = true),
		    @CacheEvict(cacheNames = "Product", key = "#id")
		})
	public Product deleteProductById(int id) {
	    Product product = repo.findById(id).orElse(null);
	    repo.deleteById(id);
	    return product;
	}

	
//Updating the Product Details
	@Caching(
		    put = {
		        @CachePut(cacheNames = "Product", key = "#id")
		    },
		    evict = {
		        @CacheEvict(cacheNames = "Products", allEntries = true)
		    }
		)
	public Product updateProductById(int id, Product product) {
		Product existingprod = repo.findById(id).orElse(null);
		if(existingprod != null)
		{
			existingprod.setName(product.getName());
			existingprod.setDescription(product.getDescription());
			existingprod.setBrand(product.getBrand());
			existingprod.setPrice(product.getPrice());
			existingprod.setCategory(product.getCategory());
			existingprod.setShortText(product.getShortText());
			existingprod.setAvailability(product.isAvailability());
			existingprod.setStock(product.getStock());
			
			return repo.save(existingprod);
			
		}
		return null;
	}

}
