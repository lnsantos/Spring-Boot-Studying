package com.lucasdosenai.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdosenai.domain.Categoria;
import com.lucasdosenai.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

// 1° COLOCA ANOTAÇÃO
@RestController
@RequestMapping(value="/categorias")
public class CategoriaRecurso {
	
	@Autowired
	private CategoriaService SERVICE;
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<?>procurar(@PathVariable Integer id) throws ObjectNotFoundException {
		
		Categoria obj = SERVICE.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
