package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.modelos.Produto;

public interface Produtos extends  JpaRepository <Produto,Long> {
	// Para o JPA é preciso informar uma classe que tem modelos de dados Produto.java
	
	
}
