package mGameInfo.server.services;

import java.io.IOException;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mGameInfo.client.services.TwitterService;
import mGameInfo.server.resources.TwitterResource;
import mGameInfo.shared.domain.tw.Tweets;

public class TwitterServiceImpl extends RemoteServiceServlet implements TwitterService{

	private static final long serialVersionUID = -5665694641666099171L;

	private TwitterResource TwitterR;
	
	public TwitterServiceImpl(){
		TwitterR = new TwitterResource();
	}
	
	public String authURL(){
		String res = null;
		try {
			res = TwitterR.authURL();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public String accessToken(String oauthVerifier){
		String res = null;
		try {
			res = TwitterR.accessToken(oauthVerifier);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Tweets> searchTweets(String game){
		return TwitterR.searchTweets(game);
	}
	
	public void retweet(String id){
		TwitterR.retweet(id);
	}
	
	public void unretweet(String id){
		TwitterR.unretweet(id);
	}
	
	public void fav(String id){
		TwitterR.fav(id);
	}
	
	public void unfav(String id){
		TwitterR.unfav(id);
	}
	
	public void post(String tweet){
		TwitterR.post(tweet);
	}

}
