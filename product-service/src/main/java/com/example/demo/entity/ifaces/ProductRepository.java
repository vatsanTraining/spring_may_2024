package com.example.demo.entity.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// DSl QUERY
	//syntax us findByPropertyName   => findBy =>propertyName first Character in cap
	Product findByProductName(String srchValue);
	
	// No need to follow naming pattern because a custom query is written using SQL Syntax
	
	// NATIVE QUERY
	@Query(value = "select * from dbs_product where rate_per_unit>:srchValue",nativeQuery = true)	
	List<Product> getAllProductByRate(@Param("srchValue") double value);

	
	// JPQL QUREY
	// No need to follow naming pattern because a custom query is written using JPQL Syntax
	// instead using table name and column name we use class name and field name
	
	
	@Query(value = "update Product set ratePerUnit=:revisedValue where id=:srchId",nativeQuery = false)
	@Modifying   //to indicate the query modifies the table instead of returning the rows
	@Transactional  // queries are executed in a default transaction boundary for modifying query user 
	// sets the transaction boundary
	int updateRatePerUnit(@Param("srchId") long id, @Param("revisedValue") double revisedValue);
	
	
	
}
