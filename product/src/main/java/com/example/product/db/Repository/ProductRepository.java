package com.example.product.db.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.product.db.Models.product;


@Repository
public interface ProductRepository extends MongoRepository<product,Integer>{
	boolean existsByCodigo (int Codigo);
}
