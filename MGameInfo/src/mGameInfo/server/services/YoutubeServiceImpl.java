package mGameInfo.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mGameInfo.client.services.YoutubeService;
import mGameInfo.server.resources.YoutubeResource;
import mGameInfo.shared.domain.yt.Items;

public class YoutubeServiceImpl extends RemoteServiceServlet implements YoutubeService{

	private static final long serialVersionUID = 6934318235827893063L;
	
	private YoutubeResource YoutubeR;
	
	public YoutubeServiceImpl(){
		YoutubeR = new YoutubeResource();
	}

	public Items searchVideos(String name) {
		return YoutubeR.searchVideos(name);
	}
	
	public Items nextPage(String name, String nextPageToken){
		return YoutubeR.nextPage(name, nextPageToken);
	}
	
	public Items prevPage(String name, String prevPageToken){
		return YoutubeR.nextPage(name, prevPageToken);
	}

/*	public void like(String token, String id) {
		YoutubeR.like(token, id);
		
	}
	
	public void dislike(String token, String id) {
		YoutubeR.dislike(token, id);
		
	}*/

}
