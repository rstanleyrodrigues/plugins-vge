package br.com.stanley.vgeplugins.service.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.stanley.vgeplugins.dom.entity.Funcionalidade;
import br.com.stanley.vgeplugins.dom.entity.Plugin;
import br.com.stanley.vgeplugins.dom.exception.FuncionalidadeException;
import br.com.stanley.vgeplugins.service.FuncionalidadeService;

@ApplicationScoped
public class FuncionalidadeServiceImpl implements FuncionalidadeService {

	@Override
	public Optional<Funcionalidade> buscaFuncionalidadePeloNome(String nome) {
		return Funcionalidade.buscaPeloNome(nome);
	}

	@Override
	@Transactional
	public Funcionalidade criaFuncionalidade(@Valid Funcionalidade funcionalidade) throws FuncionalidadeException {
//		
//		Plugin pluginUtilizado = (Plugin) Plugin.findByIdOptional(idPlugin).orElseThrow(()-> 
//		new FuncionalidadeException("O Plugin com id " + idPlugin + 
//				" nao foi encontrado"));
		
//		funcionalidade.setPlugin((pluginUtilizado));		
		funcionalidade.persist();
		
//		pluginUtilizado.getListaFuncionalidades().add(funcionalidade);
//		pluginUtilizado.persist();		
		
		return funcionalidade;
	}

//	@Override
//	public List<Funcionalidade> buscaFuncionalidadesPorPlugin(Plugin plugin) throws FuncionalidadeException {
//		return Funcionalidade.buscaTodasPorPlugin(plugin.id);
//	}

	@Override
	public void excluiFuncionalidade(Long idFuncionalidade) throws FuncionalidadeException {
		Funcionalidade.findByIdOptional(idFuncionalidade)
			.orElseThrow(()-> 
			new FuncionalidadeException("A Funcionalidade com id " + idFuncionalidade + 
					" nao foi encontrada")).delete();

	}

}
