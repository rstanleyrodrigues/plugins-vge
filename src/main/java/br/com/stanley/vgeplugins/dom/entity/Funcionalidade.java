package br.com.stanley.vgeplugins.dom.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.stanley.vgeplugins.dom.exception.FuncionalidadeException;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name="funcionalidade")
public class Funcionalidade extends PanacheEntity {
	
	@NotEmpty(message = "o nome da funcionalidade eh obrigatorio")
	@Column(name = "nome_funcionalidade")
	private String nome;
	
	@NotEmpty(message = "a descricao da funcionalidade eh obrigatoria")
	@Column(name = "descricao_funcionalidade")
	private String descricao;
	
	@Column(name = "data_criacao", columnDefinition = "DATE")
	@NotNull
	private LocalDate dataCriacao;
	
//	@ManyToOne
//	@JoinColumn(name = "id_plugin", nullable = false)
//	private Plugin plugin;
	
	public Funcionalidade (String nome, String descricao){
		
		this.nome = nome;
		this.descricao = descricao;
		dataCriacao = LocalDate.now();
	}
	
	public Funcionalidade () {
		// Construtor default para fins de serializacao 
	}
	
	public static Optional<Funcionalidade> buscaPeloNome(String nome){
		
		return Funcionalidade.find("nome_funcionalidade", nome).firstResultOptional();		
	}
	
	public static List<Funcionalidade> buscaTodasPorPlugin(Long idPlugin) throws FuncionalidadeException{
		
		Plugin plugin = (Plugin) Plugin.findByIdOptional(idPlugin).orElseThrow(()-> 
		new FuncionalidadeException("Nao foi encontrado Plugin com o id: " + idPlugin));
		
		
		return Funcionalidade.find("id_plugin", plugin.id).list();		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
//
//	public Plugin getPlugin() {
//		return plugin;
//	}
//
//	public void setPlugin(Plugin plugin) {
//		this.plugin = plugin;
//	}
	
	
	
}
