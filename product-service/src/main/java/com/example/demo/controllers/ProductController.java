package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public List<Product> findAll(){
		
		return this.service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") long id){
		
		return this.service.getProductById(id);
	}
	
	@GetMapping("/sort/{propName}")
	public List<Product> getSortedList(@PathVariable("propName") String propName){
		
		return this.service.getProductSorted(propName);
	}
	@GetMapping("/srch/name/{name}")
	public Product findByName(@PathVariable("name") String name){
		
		return this.service.getProductByName(name);
	}
	
	@GetMapping("/srch/rate/{rpu}")
	public List<Product> findByRatePerUnit(@PathVariable("rpu") double rpu){
		
		return this.service.getProductByRate(rpu);
	}
	
	@PostMapping(produces = "application/json",consumes = "application/json")
	@ApiResponses(@ApiResponse(responseCode = "201",content =@Content(mediaType = "application/json")))
	public ResponseEntity<Product> save(@RequestBody Product entity){
		
		Product saved = this.service.saveProduct(entity);
		
		URI location = ServletUriComponentsBuilder
		          .fromCurrentRequest()
		          .path("/{id}")
		           .buildAndExpand(entity.getId())
		           .toUri();  


		
		return ResponseEntity.created(location).body(saved);
	}
	
	@PutMapping()
	public Product update(@RequestBody Product entity){
		
		return this.service.saveProduct(entity);
	}
	
	
	@PatchMapping("/{id}/{rpu}")
	public ResponseEntity<Integer> update(@PathVariable long id ,@PathVariable  double rpu){
		
		var rowsUpdated = this.service.updateRatePerUnit(id, rpu);
		
		return ResponseEntity.ok(rowsUpdated);
		
	}
	
	
	@DeleteMapping("/{id}")
	public Product deleteById(@PathVariable("id") long id){
		
		return this.service.removeProduct(id);
	}


	
}
