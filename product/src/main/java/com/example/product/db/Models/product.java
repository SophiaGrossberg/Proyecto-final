package com.example.product.db.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Document(collection="products")
public class product {
	@Id
	private int codigo;
	@NotBlank(message="El nombre no puede estar vacio")
	private String nombre;
	@NotBlank(message="La decripción no puede estar vacia")
	private String descripcion;
	@NotBlank(message="El precio no puede estar vacio")
	private int precio;
	@NotBlank(message="El stock no puede estar vacio")
	private String stock;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public product(int codigo, String nombre, @NotBlank(message = "El nombre no puede estar vacio") String descripcion,
			@NotBlank(message = "La descripción no puede estar vacio") int precio,
			@NotBlank(message = "El precio no puede estar vacio") String stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	
	}
	
	public product() {
		super();
	}
}
