package com.AskMarinho.app.RedeSocial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AskMarinho.app.RedeSocial.models.Postagem;
import com.AskMarinho.app.RedeSocial.repositories.PostagemRepository;

@RestController 
@RequestMapping ("/postagens")
@CrossOrigin (origins = "*", allowedHeaders = "*")

public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping("/todas")
	public ResponseEntity<List<Postagem>> todasPostagens () {
		List<Postagem> listaDePostagem = repository.findAll();
		return ResponseEntity.status(200).body(listaDePostagem);
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> tituloPostagem (@PathVariable String titulo) {
		return ResponseEntity.status(200).body(repository.findAllByTituloContainingIgnoreCase(titulo));

	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Postagem> idPostagem (@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	
	}
	



}
