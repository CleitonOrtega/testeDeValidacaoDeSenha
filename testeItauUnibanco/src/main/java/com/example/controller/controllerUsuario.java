package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.example.model.modelUsuario;
import com.example.repository.repositoryUsuario;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
public class controllerUsuario {
	
	//Acessar a pagina 
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
		
	//Injetando o repositorio do Usuario (repositoryUsuario)
	@Autowired
	private repositoryUsuario repository;
	
	//Para consultar os dados no banco de dados endereço( http://localhost:8080/usuario )
	@GetMapping
	public List<modelUsuario> buscarTodos(){
		return repository.findAll();
	}

	//função para colocar os dados no banco de dados
	@PostMapping
	public ResponseEntity<modelUsuario> post (@RequestBody modelUsuario Usuario){
		
		//Variavel que será usada para fazer as comparações de caracteres
		char[] arraySenha = Usuario.getSenha().toCharArray();
		
		//Variaveis que retornarão verdadeiro ou falso em cada situação para fazer a verificação final e ver se a senha é valida
		boolean digito = false,minusculo = false,maiusculo = false,especial = false,repetidos = false,senha = false;
		
		//Laço de repetição para verificar se tem caracter maiuscula, minuscula etc...
		for(int x = 0; x < Usuario.getSenha().length();x++) {
			
			//Função para retornar se existe algum numero se existir retorna true (verdadeiro)
			if((arraySenha[x] >= '0') && (arraySenha[x] <= '9')) {
				digito = true;
			}
			
			//Função para retornar se existe alguma letra minuscula se existir retorna true (verdadeiro)
			if((arraySenha[x] >= 'a') && (arraySenha[x] <= 'z')) {
				minusculo = true;
			}

			//Função para retornar se existe alguma letra maiuscula se existir retorna true (verdadeiro)
			if((arraySenha[x] >= 'A') && (arraySenha[x] <= 'Z')) {
				maiusculo = true;
			}

			//Função para retornar se existe alguma caracter especial se existir retorna true (verdadeiro)
			if(arraySenha[x] == '!' || arraySenha[x] == '@' || arraySenha[x] == '#' || arraySenha[x] == '$' || arraySenha[x] == '%' || arraySenha[x] == '^' || arraySenha[x] == '&' || arraySenha[x] == '*' || arraySenha[x] == '(' || arraySenha[x] == ')' || arraySenha[x] == '-' || arraySenha[x] == '+') {
				especial = true;
			}

			//Função para fazer comparação de caracteres
			for(int y = 0;y < Usuario.getSenha().length();y++) {

			//Função para retornar se existe alguma letra repetida se existir retorna true (verdadeiro)
			if( (Usuario.getSenha().toUpperCase().charAt(x) == Usuario.getSenha().toUpperCase().charAt(y)) && (x != y)) {
					repetidos = true;
			 }
			}
		}

		//Função para verificar se as condições foram atendidas se foram atendidas retorna (verdadeiro)
		if( digito == true && minusculo == true && maiusculo == true && especial == true && repetidos == false) {
			senha = true;
		}

		//Função para verificar se o output (senha) é verdadeiro caso for verdadeiro ele salva os dados no banco de dados se não retorna Não Autorizado
		if(senha == true) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Usuario));
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	//Metodo para atualizar dados em uma possivel atualização
	@PutMapping
	public ResponseEntity<modelUsuario> put (@RequestBody modelUsuario Usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Usuario));
	}
	
	//Metodo para deletar algum usuario pelo ID
	@DeleteMapping("/delete.{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
