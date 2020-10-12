package br.com.stanley.vgeplugins.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import br.com.stanley.vgeplugins.dom.entity.Funcionalidade;
import br.com.stanley.vgeplugins.dom.entity.Plugin;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PluginServiceTest {
	
	@Inject	
	PluginService pluginService;
	
	@Test
	@Order(1)
	void buscaPluginsInseridosComSucesso() {
		
		assertEquals(2, pluginService.buscaTodosPluginsPeloMaisRecente().size());
		assertEquals("ADMIN", pluginService.buscaTodosPluginsPeloMaisRecente().get(0).getNome());
		
	}
	
	@Test
	@Order(2)
	@Transactional
	void deveIncluirPluginSemFuncComSucesso () {
		
		Plugin novoPlugin = new Plugin("NovoPlugin1", "Descricao do Plugin1");
		
		novoPlugin.persist();
		
		assertTrue(pluginService.buscaPluginPeloNome("NovoPlugin1").isPresent());
	}
	
//	@Test
//	@Order(3)
//	@Transactional
//	void insereFuncionalidadeNoPluginComSucesso() {
//		
//		Funcionalidade novaFunc = new Funcionalidade("ACAO", "ACIONA");
//		Plugin plugin1 = pluginService.buscaPluginPeloNome("NovoPlugin1").get();
//		novaFunc.setPlugin(plugin1);
//		novaFunc.persist();
//		
//		plugin1.setListaFuncionalidades(Arrays.asList(novaFunc));
//		
//		plugin1.persist();
//		
//		assertFalse(pluginService.buscaPluginPeloNome("NovoPlugin1").get().getListaFuncionalidades().isEmpty());
//		
//	}
	
	
}
