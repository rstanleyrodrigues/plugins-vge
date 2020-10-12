package br.com.stanley.vgeplugins.service.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

import br.com.stanley.vgeplugins.dom.entity.Plugin;
import br.com.stanley.vgeplugins.service.PluginService;

@ApplicationScoped
public class PluginServiceImpl implements PluginService{

	@Override
	public Optional<Plugin> buscaPluginPeloNome(String nome) {		
		return Plugin.buscaPluginPeloNome(nome);
	}

	@Override
	public List<Plugin> buscaTodosPluginsPeloMaisRecente() {
		return Plugin.retornaPluginsPeloMaisRecente();
	}


}
