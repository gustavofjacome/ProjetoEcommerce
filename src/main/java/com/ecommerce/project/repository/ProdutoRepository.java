package com.ecommerce.project.repository;

import com.ecommerce.project.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // para liberar os metodos find all, save, findById, deleteById
}