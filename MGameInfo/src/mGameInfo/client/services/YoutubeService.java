package mGameInfo.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import mGameInfo.shared.domain.yt.Items;

@RemoteServiceRelativePath("youtube")
public interface YoutubeService extends RemoteService{

	Items searchVideos(String name);
	Items prevPage(String name, String prevPageToken);
	Items nextPage(String name, String nextPageToken);
/*	void like(String token, String id);
	void dislike(String token, String id);*/
}
