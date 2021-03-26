package mGameInfo.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import mGameInfo.shared.domain.yt.Items;

public interface YoutubeServiceAsync {

	void searchVideos(String name, AsyncCallback<Items> asyncCallback);
	void prevPage(String name,String prevPageToken, AsyncCallback<Items> asyncCallback);
	void nextPage(String name,String nextPageToken, AsyncCallback<Items> asyncCallback);
/*	void like(String token, String id, AsyncCallback<Void> asyncCallback);
	void dislike(String token, String id, AsyncCallback<Void> asyncCallback);*/
}
