package br.com.stanley.vgeplugins.service;

import java.util.List;
import java.util.Optional;

import br.com.stanley.vgeplugins.dom.entity.Funcionalidade;
import br.com.stanley.vgeplugins.dom.entity.Plugin;
import br.com.stanley.vgeplugins.dom.exception.FuncionalidadeException;

public interface FuncionalidadeService {
	
	public Optional<Funcionalidade> buscaFuncionalidadePeloNome (String nome);
	
	public Funcionalidade criaFuncionalidade (Funcionalidade funcionalidade) throws FuncionalidadeException;
	
//	public List<Funcionalidade> buscaFuncionalidadesPorPlugin (Plugin plugin) throws FuncionalidadeException;
	
	public void excluiFuncionalidade (Long idFuncionalidade) throws FuncionalidadeException;

}
