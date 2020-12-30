package com.example.model;

import javax.persistence.*;

import javax.validation.constraints.*;

@Entity
@Table(name = "tb_usuario")
public class modelUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column
	@NotNull
	private String nome;
	
	@Column
	@NotNull
	@Size(min = 9,max = 20)
	private String senha;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
