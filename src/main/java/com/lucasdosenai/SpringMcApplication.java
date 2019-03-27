package com.lucasdosenai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasdosenai.domain.Categoria;
import com.lucasdosenai.domain.Produto;
import com.lucasdosenai.repository.CategoriaRepository;
import com.lucasdosenai.repository.ProdutoRepository;

@SpringBootApplication
public class SpringMcApplication implements CommandLineRunner{
	
	@Autowired // <- Essa anotação é responsável por instancia a class abaixo
	private CategoriaRepository repo;
	@Autowired // <- Essa anotação é responsável por instancia a class abaixo
	private ProdutoRepository pRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Populando DB
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Refetorio");
		
		// Populando Produtos, sem categoria
		Produto pro1 = new Produto(null, "Computador", 2000.00);
		Produto pro2 = new Produto(null, "Navegador", 100.00);
		Produto pro3 = new Produto(null, "Mouse", 20.00);
		
		// Associações de mão dupla ! Pegando o Produto preenchido, e colocando em uma categoria
		cat1.getProdutos().addAll(Arrays.asList(pro1,pro2));
		cat2.getProdutos().addAll(Arrays.asList(pro3,pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat2));
		
		repo.saveAll(Arrays.asList(cat1,cat2));
		pRepo.saveAll(Arrays.asList(pro1,pro2,pro3));
	}

}
