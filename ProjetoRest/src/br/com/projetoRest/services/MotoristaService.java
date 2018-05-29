package br.com.projetoRest.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.projetoRest.dao.MotoristaDao;
import br.com.projetoRest.entidade.EMotorista;
import br.com.projetoRest.model.NivelPermissao;
import br.com.projetoRest.seguranca.Seguro;

@Path("/motorista")
public class MotoristaService {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	private MotoristaDao motoristaDao;
	
	@PostConstruct
	private void init(){motoristaDao = new MotoristaDao();}
	
	@Seguro({NivelPermissao.NIVEL_1})
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response listar() {
		List<EMotorista> lista = null;
		String saida="";
		try {
			lista = motoristaDao.listar();
			saida = new Gson().toJson(lista);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		return Response.status(201).entity(saida).build();
	}
		
	@Seguro({NivelPermissao.NIVEL_1})
	@GET
	@Path("/buscar/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Response buscarPorId(@PathParam("id") int idAssociado) {
		EMotorista obj = null;
		String saida="";
		try {
			obj = motoristaDao.consultar(idAssociado);
			saida = new Gson().toJson(obj);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		return Response.status(201).entity(saida).build();
	}
	
	@Seguro({NivelPermissao.NIVEL_1})
	@POST
	@Path("/adicionar")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public Response adicionar(EMotorista obj) {
		int idGerado = 0;
		try {
			idGerado = motoristaDao.incluir(obj);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		return Response.status(201).entity(idGerado).build();
	}
	
	@Seguro({NivelPermissao.NIVEL_1})
	@POST
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public Response atualizar(EMotorista obj) {
		int resultado = 0;
		if(obj.getId() >0) {
			try {
				resultado = motoristaDao.atualizar(obj);
			} catch (Exception e) {
				return Response.status(500).entity(e.getMessage()).build();
			}
		}
		return Response.status(201).entity(resultado).build();
	}
	
	@Seguro({NivelPermissao.NIVEL_1})
	@GET
	@Path("/remover/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response removerPorId(@PathParam("id") int idCliente) {
		int resp=-1;
		try {
			resp = motoristaDao.excluir(idCliente);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		return Response.status(201).entity(resp).build();
	}
	
}

