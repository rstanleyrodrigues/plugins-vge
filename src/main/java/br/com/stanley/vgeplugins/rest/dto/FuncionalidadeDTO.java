package br.com.stanley.vgeplugins.rest.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.stanley.vgeplugins.dom.entity.Funcionalidade;

public class FuncionalidadeDTO {
	
	private String nome;
	
	private String descricao;
	
//	@JsonBackReference
//	private PluginDTO plugin;
	
	@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
	private LocalDate dataCriacao;
	
	public FuncionalidadeDTO() {
		// padrao
	}
	
	public FuncionalidadeDTO(String nome, String descricao) {
		
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public FuncionalidadeDTO(Funcionalidade funcionalidade) {		
		this(funcionalidade.getNome(), funcionalidade.getDescricao());
		this.dataCriacao = funcionalidade.getDataCriacao();
//		
//		if(Objects.nonNull(funcionalidade.getPlugin())) {
//			this.plugin = new PluginDTO(funcionalidade.getPlugin());
//		}

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

//	public PluginDTO getPlugin() {
//		return plugin;
//	}
//
//	public void setPlugin(PluginDTO plugin) {
//		this.plugin = plugin;
//	}
	
	

}
