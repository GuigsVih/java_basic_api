package br.com.vesmos.Controllers;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.vesmos.Models.User;
import br.com.vesmos.Repositories.UserRepository;

@Path("/auth")
/**
 * Auth Controller
 * @author Guilherme Vilela Oliveira <guivo11@gmail.com>
  Teste de Atualização Git
 */
public class AuthController 
{
	private ObjectMapper mapper;
	private UserRepository repository;
	
	public AuthController()
	{
		this.repository = new UserRepository();
		this.mapper = new ObjectMapper();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response auth(String request)
	{
		try {
			User user = this.mapper.readValue(request, User.class);
			Boolean authenticated = this.repository.authenticate(user);
			if (authenticated) {
				return Response.status(201).build();				
			}
			return Response.status(401).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Produces("application/json")
	public Response me()
	{
		try {
			return Response.status(201).entity(this.repository.getUser(1)).build();			
		} catch (SQLException e) {
			return Response.status(500).entity("SQLException").build();
		} catch (Exception e) {
			return Response.status(401).build();
		}
	}
}
