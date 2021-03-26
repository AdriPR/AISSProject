package mGameInfo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import mGameInfo.server.resources.YoutubeResource;
import mGameInfo.shared.domain.yt.Items;
import mGameInfo.shared.domain.yt.VideoYT;

public class YoutubeResourceTest {
	
	String name = "Overwatch";
	String next = "CBQQAA";
	
	@Test
	public void testSearchVideos(){
		YoutubeResource yr = new YoutubeResource();
		Items r = yr.searchVideos(name);
		
		assertNotNull("Response null", r);
		
		System.out.println("#==============================#");
		System.out.println("#         VIDEO RESULTS        #");
		System.out.println("#==============================#");
		for(VideoYT v:r.getVideos()){
			System.out.println("Video id: " + v.getVideoID().getVideoId());
			System.out.println("Title: " + v.getSnippet().getTitle());
			System.out.println("Thumbnail: " + v.getSnippet().getThumbnails().getDefault_img().getUrl());
			System.out.println("____________________________________________________________________________________________");
		}
		System.out.println("Next Page Token: " + r.getNextPageToken());
		System.out.println("Prev Page Token: " + r.getPrevPageToken());
	}
	
	@Test
	public void testNextPage(){
		YoutubeResource yr = new YoutubeResource();
		Items r = yr.nextPage(name, next);
		
		assertNotNull("Response null", r);
		
		System.out.println("#==============================#");
		System.out.println("#         VIDEO RESULTS        #");
		System.out.println("#==============================#");
		for(VideoYT v:r.getVideos()){
			System.out.println("Video id: " + v.getVideoID().getVideoId());
			System.out.println("Title: " + v.getSnippet().getTitle());
			System.out.println("Thumbnail: " + v.getSnippet().getThumbnails().getDefault_img().getUrl());
			System.out.println("____________________________________________________________________________________________");
		}
		System.out.println("Next Page Token: " + r.getNextPageToken());
		System.out.println("Prev Page Token: " + r.getPrevPageToken());
	}

}
