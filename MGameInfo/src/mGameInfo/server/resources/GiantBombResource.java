package mGameInfo.server.resources;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import mGameInfo.shared.domain.gb.Result;
import mGameInfo.shared.domain.gb.ResultDetails;

public class GiantBombResource {
	
	private String GB_URL = "http://www.giantbomb.com/api/search/?api_key=73d4e4ad38d386f5a79ef226efc901b9780d074a&format=json&resources=game&query=";
	private String GB_GAME_DETAILS = "http://www.giantbomb.com/api/game/3030-";
	public GiantBombResource(){}
	

	public Result searchGames(String s) {
		Result games = null;
		try {
			ClientResource cr = new ClientResource(GB_URL + s);
			games = cr.get(Result.class);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
		return games;
	}
	
	public ResultDetails showDetails(String id){
		ResultDetails gameDetails = null;
		try{
			ClientResource cr = new ClientResource(GB_GAME_DETAILS + id + "?api_key=73d4e4ad38d386f5a79ef226efc901b9780d074a&format=json&field_list=name%2Cimage%2Cdeck%2Cdescription%2Cdevelopers%2Cgenres%2Coriginal_game_rating%2Coriginal_release_date%2Cplatforms%2Cpublishers");
			gameDetails = cr.get(ResultDetails.class);
		}catch(ResourceException re){
			System.err.println("Error.");
		}
		return gameDetails;
	}
	
}
