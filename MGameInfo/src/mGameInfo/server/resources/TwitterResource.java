package mGameInfo.server.resources;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

import mGameInfo.shared.domain.tw.Statuses;
import mGameInfo.shared.domain.tw.Tweets;

public class TwitterResource {

	private static String apiKey = "mWT4IqAQNsxd0iW6v2ggyvr8N";
	private static String apiSecret = "Hl5ivisSevu9IZT5cZupY9WRFde9t97V2uGySKcNVdAfImnkha";

	private static String search = "https://api.twitter.com/1.1/search/tweets.json?";
	private static String retweet = "https://api.twitter.com/1.1/statuses/retweet/";
	private static String unretweet = "https://api.twitter.com/1.1/statuses/unretweet/";
	private static String fav = "https://api.twitter.com/1.1/favorites/create.json?";
	private static String unfav = "https://api.twitter.com/1.1/favorites/destroy.json?";
	private static String post = "https://api.twitter.com/1.1/statuses/update.json?";

	final OAuth10aService service = new ServiceBuilder()
			.apiKey(apiKey)
			.apiSecret(apiSecret)
			.build(TwitterApi.instance());
	OAuth1RequestToken requestToken; 
	OAuth1AccessToken accessToken;

	public String authURL() throws IOException{
		requestToken = service.getRequestToken();
		String authorizationURL = service.getAuthorizationUrl(requestToken);
		return authorizationURL;
	}

	public String accessToken(String verifier) throws IOException{
		accessToken = service.getAccessToken(requestToken, verifier);
		return accessToken.getRawResponse();
	}

	public List<Tweets> searchTweets(String game){
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		List<Tweets> tweets = new ArrayList<Tweets>();
		Statuses aux = null;
		final OAuthRequest request = new OAuthRequest(Verb.GET, search + "q=" + tweetString(game) + "%2Dfilter%3Aretweets&count=100", service);
		service.signRequest(accessToken, request);
		final Response response = request.send();
		try {
			json = response.getBody();
			aux = mapper.readValue(json, Statuses.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tweets = aux.getTweets();
		return tweets;	
	}

	public void retweet(String id){
		final OAuthRequest request = new OAuthRequest(Verb.POST, retweet + id + ".json", service);
		service.signRequest(accessToken, request);
		request.send();
	}

	public void unretweet(String id){
		final OAuthRequest request = new OAuthRequest(Verb.POST, unretweet + id + ".json", service);
		service.signRequest(accessToken, request);
		request.send();
	}

	public void fav(String id){
		final OAuthRequest request = new OAuthRequest(Verb.POST, fav + "id=" + id, service);
		service.signRequest(accessToken, request);
		request.send();
	}

	public void unfav(String id){
		final OAuthRequest request = new OAuthRequest(Verb.POST, unfav + "id=" + id, service);
		service.signRequest(accessToken, request);
		request.send();
	}
	
	public void post(String tweet){
		String t = tweetString(tweet);
		final OAuthRequest request = new OAuthRequest(Verb.POST, post + "status=" + t, service);
		service.signRequest(accessToken, request);
		request.send();
	}
	
	public static String tweetString(String str){
		try {
			str = URLEncoder.encode(str, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
