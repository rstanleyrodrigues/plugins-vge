package br.com.stanley.vgeplugins.dom.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;

@Entity(name = "plugin")
public class Plugin extends PanacheEntity {

	@NotEmpty(message = "o nome do plugin eh obrigatorio")
	@Column(name = "nome_plugin")
	private String nome;
	
	@NotEmpty(message = "a descricao do plugin eh obrigatoria")
	@Column(name = "descricao_plugin")
	private String descricao;
	
	@Column(name = "data_criacao", columnDefinition = "DATE")
	private LocalDate dataCriacao;
	
//	@OneToMany(mappedBy = "plugin", cascade = CascadeType.REMOVE)
//	private List<Funcionalidade> listaFuncionalidades;
	
	public Plugin (String nomePlugin, String descricaoPlugin){
		
		this.nome = nomePlugin;
		this.descricao = descricaoPlugin;
		this.dataCriacao = LocalDate.now();
		
	}
	
	public Plugin () {
		// Construtor default para fins de serializacao 
	}
	
	public static Optional<Plugin> buscaPluginPeloNome(String nome) {
		return Plugin.find("nome_plugin", nome).firstResultOptional();
	}
	
	public static List<Plugin> retornaPluginsPeloMaisRecente (){
		return Plugin.list("ORDER BY data_criacao DESC");
	}
	
//	public static Optional<Plugin> buscaPluginPelaFuncionalidade (Long idFuncionalidade) {
//		
//		Funcionalidade funcionalidade = Funcionalidade.findById(idFuncionalidade);
//		if (Objects.nonNull(funcionalidade)) {
//			return Optional.of(funcionalidade.getPlugin());
//		}		
//		return Optional.empty();
//	}

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

//	public List<Funcionalidade> getListaFuncionalidades() {
//		return listaFuncionalidades;
//	}
//
//	public void setListaFuncionalidades(List<Funcionalidade> listaFuncionalidades) {
//		this.listaFuncionalidades = listaFuncionalidades;
//	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
	
	
}
