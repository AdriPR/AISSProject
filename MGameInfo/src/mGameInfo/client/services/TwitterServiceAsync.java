package mGameInfo.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mGameInfo.shared.domain.tw.Tweets;

public interface TwitterServiceAsync {

	void authURL(AsyncCallback<String> asyncCallback);
	void accessToken(String oauthVerifier, AsyncCallback<String> asyncCallback);
	void searchTweets(String game, AsyncCallback<List<Tweets>> asyncCallback);
	void retweet(String id, AsyncCallback<Void> asyncCallback);
	void unretweet(String id, AsyncCallback<Void> asyncCallback);
	void fav(String id, AsyncCallback<Void> asyncCallback);
	void unfav(String id, AsyncCallback<Void> asyncCallback);
	void post(String tweet, AsyncCallback<Void> asyncCallback);
}