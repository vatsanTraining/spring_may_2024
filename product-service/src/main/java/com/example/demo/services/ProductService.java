package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ifaces.ProductRepository;
import com.example.demo.exceptions.ElementNotFoundException;

@Service
public class ProductService {

	
	private ProductRepository repo;

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public Product getProductById(long id) {
		
		return this.repo.findById(id).orElseThrow(() -> new ElementNotFoundException("Element With given "+id+" Not found") );
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
	   
	   return this.repo.updateRatePerUnit(id, revisedRate);
 }


 
public List<Product>  getProductSorted(String sortProp) {
	
	 return this.repo.findAll(Sort.by(sortProp));
			 
}
   
   
	
	
}
