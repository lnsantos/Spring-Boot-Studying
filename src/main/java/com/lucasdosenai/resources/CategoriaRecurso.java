package com.lucasdosenai.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdosenai.domain.Categoria;

// 1° COLOCA ANOTAÇÃO
@RestController
@RequestMapping(value="/categorias")
public class CategoriaRecurso {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria ctg1 = new Categoria(1, "Informática");
		Categoria ctg2 = new Categoria(2, "Escritório");
		
		List<Categoria> listaC = new ArrayList<>();
		listaC.add(ctg1);
		listaC.add(ctg2);
		
		return listaC;
	}
	
}
