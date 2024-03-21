package com.Projetoavl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projetoavl.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
