package mGameInfo.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import mGameInfo.shared.domain.tw.Tweets;

@RemoteServiceRelativePath("twitter")
public interface TwitterService extends RemoteService{

	String authURL();
	String accessToken(String oauthVerifier);
	List<Tweets> searchTweets(String game);
	void retweet(String id);
	void unretweet(String id);
	void fav(String id);
	void unfav(String id);
	void post(String tweet);
}
