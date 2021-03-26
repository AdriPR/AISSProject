package mGameInfo.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import mGameInfo.domain.Game;
import mGameInfo.repository.GameRepositoryImpl;

@Path("/games")
public class GameResource {

	GameRepositoryImpl repository;

	public GameResource() {
		repository=new GameRepositoryImpl();
	}

	@GET
	@Produces("application/json")
	public Collection<Game> getGames(){
		return repository.getAll();
	}

	@GET
	@Path("/{name}")
	@Produces("application/json")
	public Game get(@PathParam("name") String name){
		Game game = repository.get(name);
		if(game == null){
			throw new NotFoundException("The game " + name + " was not found");
		}
		return game;
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game){
		if(game.getName() == null || game.getName().isEmpty())
			throw new BadRequestException("The name of the game must not be null");

		repository.put(game);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(game.getName());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(game);

		return resp.build();
	}

	@PUT
	@Path("/{name}")
	@Consumes("application/json")
	public Response updateGame(@PathParam("name") String name, Game game){
		Game oldGame = repository.get(name);
		if(oldGame.getName() == null || oldGame == null || oldGame.getName().isEmpty()){
			throw new NotFoundException("The game" + name + " was not found");
		}
		
		repository.remove(name);
		repository.put(game);

		return Response.noContent().build();
	}

	@DELETE
	@Path("/{name}")
	public void removeGame(@PathParam("name") String name) {
		Game toberemoved=new Game();
		toberemoved=repository.get(name);
		if (toberemoved == null)
			throw new NotFoundException("The game " + name + " was not found");
		else
			repository.remove(name);
	}

}
