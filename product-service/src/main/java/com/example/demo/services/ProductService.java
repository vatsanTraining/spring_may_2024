package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ifaces.ProductRepository;

@Service
public class ProductService {

	
	private ProductRepository repo;

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public Product getProductById(long id) {
		
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Element With given "+id+"Not found") );
	}
	
	
   public List<Product> getAllProducts() {
		
		return this.repo.findAll();
	}
	
   public Product getProductByName(String productName) {
		
		return this.repo.findByProductName(productName);
	}
	
   
   public List<Product> getProductByRate(double rate){
	   
	   return this.repo.getAllProductByRate(rate);
   }
   

 public Product saveProduct(Product entity){
	   
	   return this.repo.save(entity);
   }
 

 public Product updateProduct(Product entity){
	   
	   return this.saveProduct(entity);
 }

 public Product removeProduct(long  id){
	   
	 Product productDeleted = null;
	   if(this.repo.existsById(id)) {
		   
		   productDeleted = this.repo.findById(id).get();
		   
		   this.repo.deleteById(id);
	   } 
	   return productDeleted;
 }
 
 public int updateRatePerUnit(long id,double revisedRate ){
	   
	   return this.updateRatePerUnit(id, revisedRate);
 }


 

   
   
	
	
}
