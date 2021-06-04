package com.AskMarinho.app.RedeSocial.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 1, max = 100)
	private String texto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario")
	@JsonIgnoreProperties("comentarios")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "postagem")
	@JsonIgnoreProperties("comentarios")
	private Postagem postagem;

	public long getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

}
