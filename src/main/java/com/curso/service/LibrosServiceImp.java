package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Libro;

//Anotación necesario para que Spring nos instancie esta clase mediante el patrón
//Inyección de dependencias

@Service //Esta es la capa de nuestra lógica de negocio
public class LibrosServiceImp implements LibroService {

	
	List<Libro> libros;
	
	public LibrosServiceImp() {
		libros = new ArrayList<>(); //Declarar las referencias al nivel más alto de la gerarquía
		libros.add(new Libro(11, "La lluvia", "Terror"));
		libros.add(new Libro(22, "El son de la música", "Ocio"));
		libros.add(new Libro(33, "Java", "Programación"));
		libros.add(new Libro(44, "linux", "Sistemas"));
		libros.add(new Libro(55, "Paris", "Viaje"));
	}

	@Override
	public List<Libro> libros() {
		
		return libros;
	}

	@Override
	public Libro libroIsbn(int isbn) {
		for(Libro libro:libros) {
			if(libro.getIsbn() == isbn) {
				return libro;
			}
		}
		return null;
	}

	@Override
	public void altaLibro(Libro libro) {
		
		libros.add(libro);
	}

	@Override
	public void actualizarLibro(Libro libro) {
			
		for(Libro libroEle:libros) {
			if(libro.getIsbn() == libroEle.getIsbn()) {
				libroEle.setTematica(libro.getTematica());
				libroEle.setTitulo(libro.getTitulo());
			}
		}
//		libroIsbn(libro.getIsbn()).setTematica(libro.getTematica());
//		libroIsbn(libro.getIsbn()).setTitulo(libro.getTitulo());
	}

	@Override
	public List<Libro> eliminar(int isbn) {
		
		for(Libro libro:libros) {
			if(libro.getIsbn() == isbn) {
				libros.remove(libro);
				return libros;
			}
		}
		return null;
	}

	

}


