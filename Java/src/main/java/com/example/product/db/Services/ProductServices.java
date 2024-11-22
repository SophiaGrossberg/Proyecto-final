package com.example.product.db.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.product.db.Models.product;
import com.example.product.db.Repository.ProductRepository;
import com.example.product.global.exceptions.AttributeException;
import com.example.product.global.exceptions.ResourceNotFoundException;
import com.example.productDto.dto.ProductDto;



@Service
public class ProductServices {
	@Autowired
	ProductRepository productRepository;
	
	public List<product> getAll(){
		
		return productRepository.findAll();
	}
	
	public product getOne(int codigo) throws ResourceNotFoundException {
		
		return productRepository.findById(codigo)
				.orElseThrow(()-> new ResourceNotFoundException(""));
	}
	
	public product save(ProductDto dto) throws AttributeException {
		
		//int id = autoIncrementar();
		
		if (productRepository.existsByCodigo(dto.getCodigo()))
			throw new AttributeException("El numero ya existe");
	
		product products = new product(dto.getCodigo(),dto.getNombre(),
				dto.getDescripcion(),dto.getPrecio(),
				dto.getStock());
	
		return productRepository.save(products);
	
		
	}
	
	public product update(int codigo, ProductDto dto) throws ResourceNotFoundException {
		
		
		product products = productRepository.findById(codigo)
				.orElseThrow(()-> new ResourceNotFoundException(""));
		
		products.setNombre(dto.getNombre());
		products.setDescripcion(dto.getDescripcion());
		products.setPrecio(dto.getPrecio());
		products.setStock(dto.getStock());
		
		
		
		return productRepository.save(products);
	}
	
	public product delete(int codigo) throws ResourceNotFoundException{
		
		product products = productRepository.findById(codigo)
				.orElseThrow(()-> new ResourceNotFoundException("No Encontrado"));
		productRepository.delete(products);
		
		return products;
	}
	
	//Metodos
	/*
	private int autoIncrementar() {
		
		List <Usuario> usuarios = usuarioRepository.findAll();
		
		return usuarios.isEmpty()? 1 :
			usuarios.stream().max(Comparator.comparing(Usuario::getNumIdentificacion)).get().getNumIdentificacion() + 1;	
	}
	*/
}
