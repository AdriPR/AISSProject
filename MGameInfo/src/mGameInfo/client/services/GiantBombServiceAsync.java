package mGameInfo.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mGameInfo.shared.domain.gb.Result;
import mGameInfo.shared.domain.gb.ResultDetails;

public interface GiantBombServiceAsync {

	void searchGames(String s, AsyncCallback<Result> asyncCallback);

	void showDetails(String id, AsyncCallback<ResultDetails> asyncCallback);
	
}
