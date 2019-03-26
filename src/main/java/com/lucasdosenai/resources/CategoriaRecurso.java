package com.lucasdosenai.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 1° COLOCA ANOTAÇÃO
@RestController
@RequestMapping(value="/categorias")
public class CategoriaRecurso {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST está funcionando!!";
	
	}
	
}
