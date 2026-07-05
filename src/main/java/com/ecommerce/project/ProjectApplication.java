package com.ecommerce.project;

import com.ecommerce.project.model.Produto;
import com.ecommerce.project.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProdutoRepository produtoRepository) {
		return args -> {
			Produto p = new Produto();
			p.setNome("Notebook Gamer");
			p.setPreco(new BigDecimal("4500.00"));
			p.setQuantidadeEstoque(10);

			produtoRepository.save(p);
			System.out.println(">>> Produto salvo com sucesso: " + p.getNome());
		};
	}
}