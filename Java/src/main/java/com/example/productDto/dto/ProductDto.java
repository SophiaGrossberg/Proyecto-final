package com.example.productDto.dto;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
	@Id
	@NotNull(message="no puede ser vacio")
	private int codigo;
	@NotBlank(message = "El tipo de identifiacion es obligatorio")
	private String nombre;
	@NotBlank(message = "La fecha es obligatoria")
	private String descripcion;
	@NotNull(message = "La edad no puede estar vacia")
	private int precio;
	@NotNull
	private String stock;
	@Email(message = "Debe ser una dirección de correo electrónico válida")

	
	public ProductDto() {
		super();
	}

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
	public ProductDto(int codigo, String nombre, @NotBlank(message = "El nombre no puede estar vacio") String descripcion,
			@NotBlank(message = "La descripción no puede estar vacio") int precio,
			@NotBlank(message = "El precio no puede estar vacio") String stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	
	}
	
	
}
