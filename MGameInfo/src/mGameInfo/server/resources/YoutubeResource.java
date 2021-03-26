package mGameInfo.server.resources;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import mGameInfo.shared.domain.yt.Items;

public class YoutubeResource {
	
	private String YT_Search1 = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=";
	private String YT_Search2 = "&type=video&maxResults=20&videoCategoryId=20&key=AIzaSyCmiSFLLKIbYrNs46qilHZ9Wadcpg4eDcE";
//	private String YT_Rate = "https://www.googleapis.com/youtube/v3/videos/rate?access_token=";
	
	public YoutubeResource(){}
	
	public Items searchVideos(String name){
		Items videos = null;
		try {
			ClientResource cr = new ClientResource(YT_Search1 + name + YT_Search2);
			videos = cr.get(Items.class);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
		return videos;
	}
	
	public Items nextPage(String name, String nextPageToken){
		Items videos = null;
		try {
			ClientResource cr = new ClientResource(YT_Search1 + name + "&pageToken=" + nextPageToken + YT_Search2);
			videos = cr.get(Items.class);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
		return videos;
	}
	
	public Items prevPage(String name, String prevPageToken){
		Items videos = null;
		try {
			ClientResource cr = new ClientResource(YT_Search1 + name + "&pageToken=" + prevPageToken + YT_Search2);
			videos = cr.get(Items.class);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
		return videos;
	}
	
/*	public void like(String token, String id){
		try {
			ClientResource cr = null;
			cr = new ClientResource(YT_Rate + token + "&id=" + id + "&rating=like");
			cr.post(null);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
	}
	
	public void dislike(String token, String id){
		try {
			ClientResource cr = null;
			cr = new ClientResource(YT_Rate + token + "&id=" + id + "&rating=dislike");
			cr.post(null);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
	}*/

}
