package mGameInfo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import mGameInfo.server.resources.DeviantArtResource;
import mGameInfo.shared.domain.da.FanArt;
import mGameInfo.shared.domain.da.ResultDA;

public class DeviantArtResourceTest {
	
	String name = "Overwatch";
	Integer offset = 0;
	
	@Test
	public void testSearchFanArt(){
		DeviantArtResource dr = new DeviantArtResource();
		ResultDA r = dr.searchFanArt(0,name);
		
		assertNotNull("Response null", r);
		
		System.out.println("#==============================#");
		System.out.println("#         GAME FANART          #");
		System.out.println("#==============================#");
		for(FanArt d:r.getFanArts()){
			System.out.println("FanArt id: " + d.getDeviationid());
			System.out.println("FanArt Title: " + d.getTitle());
			System.out.println("FanArt Author: " + d.getAuthor().getUsername());
			System.out.println("FanArt Source: " + d.getContent().getSrc());
			System.out.println("____________________________________________________________________________________________");
		}
	}
}
