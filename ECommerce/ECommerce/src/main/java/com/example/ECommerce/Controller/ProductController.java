package com.example.ECommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.Model.Product;
import com.example.ECommerce.Service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
//Inserting the Product details	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProducts(@RequestBody Product prod)
	{
	//	Product savedproduct = service.saveProducts(prod);
		
		return ResponseEntity.ok(service.saveProducts(prod));		
	}

// Getting all product Details
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts()
	{
//		List<Product> products = service.getProducts();
		
		return ResponseEntity.ok(service.getProducts());	
		
	}
	
//Getting the Product Details By ID
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getById(@PathVariable int id)
	{
		Product product = service.getProductById(id);
		if(product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Product Id"+" "+ id+" "+"Not Found");
							
		}
		return ResponseEntity.ok(product);
	}
	
	
//Delete The Product By ID
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {

		Product product = service.deleteProductById(id);
		
		if(product == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Product with ID"+" "+id+"Not Found");
		}
	    return ResponseEntity.ok("Deleted Successfully");
	}
	
	
// Updating the Product Details
	@PutMapping("/prod/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable int id, @RequestBody Product product)
	{
		
		Product prod = service.updateProductById(id, product);
		if(prod != null)
		{
			return ResponseEntity.ok(prod);
		}
		return ResponseEntity.notFound().build();
	}

}
