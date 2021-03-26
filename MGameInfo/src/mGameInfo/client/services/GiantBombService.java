package mGameInfo.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import mGameInfo.shared.domain.gb.Result;
import mGameInfo.shared.domain.gb.ResultDetails;

@RemoteServiceRelativePath("giantbomb")
public interface GiantBombService extends RemoteService{

	Result searchGames(String s);
	ResultDetails showDetails(String id);
}
