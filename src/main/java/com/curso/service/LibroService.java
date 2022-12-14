package com.curso.service;

import java.util.List;

import com.curso.model.Libro;

public interface LibroService {

	List<Libro> libros(); //GET
	
	Libro libroIsbn(int isbn); //GET
	
	void altaLibro(Libro libro); //POST
	
	void actualizarLibro(Libro libro); //PUT
	
	List<Libro>eliminar(int isbn); //DELETE
	
	
}
