package br.com.stanley.vgeplugins.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import br.com.stanley.vgeplugins.dom.entity.Plugin;
import br.com.stanley.vgeplugins.dom.exception.FuncionalidadeException;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FuncionalidadeServiceTest {
	
	@Inject
	FuncionalidadeService funcionalidadeService;
	
	@Test
	void buscaTodosAsFuncionalidades () throws FuncionalidadeException {
				
		//assertFalse(funcionalidadeService.buscaFuncionalidadesPorPlugin(Plugin.findById(Long.valueOf(12345))).isEmpty());
		
	}

}
