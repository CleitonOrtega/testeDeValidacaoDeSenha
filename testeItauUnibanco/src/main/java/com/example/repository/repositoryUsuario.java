package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.*;

public interface repositoryUsuario extends JpaRepository<modelUsuario, Long> {

	public List<modelUsuario> findAllByNomeContainingIgnoreCase(String nome);
	
}
