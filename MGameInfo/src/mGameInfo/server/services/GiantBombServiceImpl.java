package mGameInfo.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mGameInfo.client.services.GiantBombService;
import mGameInfo.server.resources.GiantBombResource;
import mGameInfo.shared.domain.gb.Result;
import mGameInfo.shared.domain.gb.ResultDetails;

public class GiantBombServiceImpl extends RemoteServiceServlet implements GiantBombService{

	private static final long serialVersionUID = 6588984410225349600L;
	
	private GiantBombResource GiantBombR;
	
	public GiantBombServiceImpl(){
		GiantBombR = new GiantBombResource();
	}

	public Result searchGames(String s) {
		return GiantBombR.searchGames(s);
	}

	public ResultDetails showDetails(String id) {
		return GiantBombR.showDetails(id);
	}

}
