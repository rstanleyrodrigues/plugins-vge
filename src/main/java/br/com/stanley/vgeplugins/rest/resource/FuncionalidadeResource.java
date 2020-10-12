package br.com.stanley.vgeplugins.rest.resource;

import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpStatus;

import br.com.stanley.vgeplugins.dom.entity.Funcionalidade;
import br.com.stanley.vgeplugins.dom.exception.FuncionalidadeException;
import br.com.stanley.vgeplugins.rest.dto.FuncionalidadeDTO;
import br.com.stanley.vgeplugins.service.FuncionalidadeService;
import br.com.stanley.vgeplugins.service.PluginService;

@Path("/funcionalidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionalidadeResource {
	
	@Inject
	PluginService pluginService;
	
	@Inject
	FuncionalidadeService funcService;
	
	@GET
	@Path("/{id}") 
	public FuncionalidadeDTO obtemFuncionalidadePorId (@PathParam("id") Long id) {		
		
		Funcionalidade func = Funcionalidade.findById(id);
		if(Objects.isNull(func)) {
			throw new WebApplicationException
			("Funcionalidade de id: "+ id + " Nao encontrada", HttpStatus.SC_NOT_FOUND);
		}
		
		return new FuncionalidadeDTO(func);
	}
	
	@POST
	public FuncionalidadeDTO criaFuncionalidadePorId (FuncionalidadeDTO funcionalidade) {		
		
		Funcionalidade funcNew = new Funcionalidade(funcionalidade.getNome(), 
				funcionalidade.getDescricao());
		
		try {
			funcNew = funcService.criaFuncionalidade(funcNew);
		} catch (FuncionalidadeException e) {
			throw new WebApplicationException
			("Funcionalidade Inválida", HttpStatus.SC_NOT_ACCEPTABLE);
		}
		
		return new FuncionalidadeDTO(funcNew);
	}
	
	

}
