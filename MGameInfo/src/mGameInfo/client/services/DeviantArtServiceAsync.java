package mGameInfo.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mGameInfo.shared.domain.da.ResultDA;
import mGameInfo.shared.domain.da.Token;

public interface DeviantArtServiceAsync {

	void searchFanArt(Integer o, String name, AsyncCallback<ResultDA> asyncCallback);
	void getToken(AsyncCallback<Token> asyncCallback);
}
