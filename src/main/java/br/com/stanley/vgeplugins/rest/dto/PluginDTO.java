package br.com.stanley.vgeplugins.rest.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.stanley.vgeplugins.dom.entity.Plugin;

public class PluginDTO {
	
	private String nome;
	
	private String descricao;
	
	@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
	private LocalDate dataCriacao;
	
//	@JsonManagedReference
//	private List<FuncionalidadeDTO> funcionalidades;
	
	public PluginDTO() {
		this.dataCriacao = LocalDate.now();
	}
	
	public PluginDTO(Plugin plugin) {
		
		this.nome = plugin.getNome();
		this.descricao = plugin.getDescricao();
		this.dataCriacao = plugin.getDataCriacao();		

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
//
//	public List<FuncionalidadeDTO> getFuncionalidades() {
//		return funcionalidades;
//	}
//
//	public void setFuncionalidades(List<FuncionalidadeDTO> funcionalidades) {
//		this.funcionalidades = funcionalidades;
//	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
	

}
