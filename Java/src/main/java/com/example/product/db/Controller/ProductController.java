package com.example.product.db.Controller;
import com.example.product.db.Services.ProductServices;
import com.example.product.global.exceptions.AttributeException;
import com.example.product.global.exceptions.ResourceNotFoundException;
import com.example.productDto.dto.ProductDto;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.product.db.Models.product;


import jakarta.validation.Valid;
@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	 ProductServices productServices;
	
	@GetMapping
    public ResponseEntity<List<product>> getAll() {
        return ResponseEntity.ok(productServices.getAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<product> getOne(@PathVariable("codigo") int codigo) throws ResourceNotFoundException {
        return ResponseEntity.ok(productServices.getOne(codigo));
    }

    @PostMapping
    public ResponseEntity<product> save(@Valid @RequestBody ProductDto dto) throws AttributeException {
        return ResponseEntity.ok(productServices.save(dto));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<product> update(@Valid @PathVariable("codigo") int codigo, @RequestBody ProductDto dto)
    		throws ResourceNotFoundException{
        return ResponseEntity.ok(productServices.update(codigo, dto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<product> delete(@PathVariable("codigo") int codigo)
    		throws ResourceNotFoundException{
        return ResponseEntity.ok(productServices.delete(codigo));
    }
}
