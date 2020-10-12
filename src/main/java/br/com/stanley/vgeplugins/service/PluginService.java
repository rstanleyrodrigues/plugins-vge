package br.com.stanley.vgeplugins.service;

import java.util.List;
import java.util.Optional;

import br.com.stanley.vgeplugins.dom.entity.Plugin;

public interface PluginService {

	public Optional<Plugin> buscaPluginPeloNome (String nome);
	
	public List<Plugin> buscaTodosPluginsPeloMaisRecente();
	
}
