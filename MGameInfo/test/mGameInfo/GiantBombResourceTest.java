package mGameInfo;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import mGameInfo.server.resources.GiantBombResource;
import mGameInfo.shared.domain.gb.Developers;
import mGameInfo.shared.domain.gb.Game;
import mGameInfo.shared.domain.gb.GameDetails;
import mGameInfo.shared.domain.gb.Genres;
import mGameInfo.shared.domain.gb.OriginalRating;
import mGameInfo.shared.domain.gb.Platforms;
import mGameInfo.shared.domain.gb.Result;
import mGameInfo.shared.domain.gb.ResultDetails;

public class GiantBombResourceTest {

	String name = "Pokemon";
	String id = "48161";

	@Test
	public void testSearchGames(){
		GiantBombResource gr = new GiantBombResource();
		Result r = gr.searchGames(name);

		assertNotNull("Response null", r);

		System.out.println("#==============================#");
		System.out.println("#         GAME RESULTS         #");
		System.out.println("#==============================#");
		for(Game g:r.getGames()){
			System.out.println("Game id: " + g.getID());
			System.out.println("Game name: " + g.getName());
			if(g.getImage().getImageUrl()!=null)
				System.out.println("Game cover: " + g.getImage().getImageUrl());
			System.out.println("____________________________________________________________________________________________");
		}
	}

	@Test
	public void testShowDetails(){
		GiantBombResource gr = new GiantBombResource();
		ResultDetails r = gr.showDetails(id);
		GameDetails g = r.getGame();
		List<OriginalRating> ratings = g.getOriginalGameRating();
		String ratString = "Ratings:";
		List<Platforms> platforms = g.getPlatforms();
		String platString = "Platforms:";
		List<Developers> developers = g.getDevelopers();
		String devString = "Developers:";
		List<Genres> genres = g.getGenres();
		String genString = "Genres:";

		System.out.println("#==============================#");
		System.out.println("#         GAME DETAILS         #");
		System.out.println("#==============================#");
		System.out.println("Name: " + g.getName());
		System.out.println("Info: " + g.getDeck());
		for(OriginalRating rat:ratings){
			ratString = ratString + "    "  + rat.getName();
		}
		System.out.println(ratString);
		for(Platforms plat:platforms){
			platString = platString + "    "  + plat.getName();
		}
		System.out.println(platString);
		for(Developers dev:developers){
			devString = devString + "    "  + dev.getName();
		}
		System.out.println(devString);
		for(Genres gen:genres){
			genString = genString + "    "  + gen.getName();
		}
		System.out.println(genString);
	}
}
