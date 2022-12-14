package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Libro;
import com.curso.service.LibroService;
//import com.curso.service.LibrosServiceImp;



@RestController
public class LibrosController {

	@Autowired //Con esta anotación Spring es capaz de utilizar el service
	//LibrosServiceImp service; 
	LibroService service;
	
	
	//Get libros
	@GetMapping(value = "libros", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> libros(){ //Este método se debe de relacionar con el que tengo en la clase de servicios
		
		return service.libros();
	}
	
	//Get libros por isbn
	@GetMapping(value = "libros/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Libro librosIsbn(@PathVariable ("isbn") int isbn){
		
		return service.libroIsbn(isbn);
	}
	
	//Post
	@PostMapping(value = "librosAlta", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaLibro(@RequestBody Libro libro) {
		
		service.altaLibro(libro);
	}
	
	//Delete
	@DeleteMapping(value = "librosDelete/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> eliminar(@PathVariable ("isbn") int isbn){
		
		return service.eliminar(isbn);
	}
	
	//Update
	@PutMapping(value = "librosActualizar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarLibro(@RequestBody Libro libro) {
		
		service.actualizarLibro(libro);
	}
}
