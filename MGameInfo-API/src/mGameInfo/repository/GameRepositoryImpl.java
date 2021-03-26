package mGameInfo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mGameInfo.domain.Game;


public class GameRepositoryImpl implements GameRepository {
	
	private Map<Game,String> games;
	
	public GameRepositoryImpl() {
		games=new HashMap<Game,String>();
		Game overwatch = new Game();
		overwatch.setName("Overwatch");
		overwatch.setCover("http://www.giantbomb.com/api/image/scale_medium/2852990-overwatch.jpg");
		overwatch.setDetails("Many years prior to the events of the game, the Omnica Corporation, a leading robotics manufacturer and AI developer, found that its Omnic robots became somewhat sentient. The Omnics organized themselves and started attacking their human masters in a global war that became known as the Omnic Crisis. To counter this threat, an international task force called Overwatch was formed under the United Nations to combine those with special powers, technology, and other abilities into a fighting force capable of countering the Omnics. Eventually, Overwatch managed to fight off the Omnics enough to end the war, and reach a peace accord with the remaining synthetic beings.");
		games.put(overwatch,overwatch.getName());
		
		Game zelda = new Game();
		zelda.setName("The Legend of Zelda");
		zelda.setCover("http://www.giantbomb.com/api/image/scale_medium/10169-legendofzelda-goldbox.png");
		zelda.setDetails("The Legend of Zelda takes place in the land of Hyrule. The evil sorcerer, Ganon, has ravaged the land with his armies in searching for and acquiring the Triforce of Power. In order to keep Ganon from also gaining the Triforce of Wisdom, Princess Zelda divided it into eight pieces and scattered them in hidden dungeons throughout Hyrule.");
		games.put(zelda, zelda.getName());
		
		Game bioshock = new Game();
		bioshock.setName("BioShock");
		bioshock.setCover("http://www.giantbomb.com/api/image/scale_medium/2584146-bioshock.jpg");
		bioshock.setDetails("Set in 1960, BioShock begins with a plane crash, with the player character, named Jack, being the only survivor. The player takes refuge in a lone lighthouse in the middle of the ocean. A bathysphere leads down into the bowels of the underwater city of Rapture. A message from the city's creator, Andrew Ryan, talks of his vision for Rapture, a utopia without ethical or moral barriers. However, from the looks of things, Ryan has failed in realizing his vision.");
		games.put(bioshock, bioshock.getName());
		
		Game pokemon = new Game();
		pokemon.setName("Pokémon Yellow: Special Pikachu Edition");
		pokemon.setCover("http://www.giantbomb.com/api/image/scale_medium/2171295-box_pkmnyv.png");
		pokemon.setDetails("Pokémon Yellow: Special Pikachu Edition is the fourth installment in the Pokémon series. It was developed by Game Freak for the Nintendo Game Boy, and is essentially an updated version of the Pokémon Red/Blue titles, with changes made in order for the game to more closely follow the events of the Pokémon anime series.");
		games.put(pokemon, pokemon.getName());
		
		Game ff = new Game();
		ff.setName("Final Fantasy VII");
		ff.setCover("http://www.giantbomb.com/api/image/scale_medium/1814630-box_ff7.png");
		ff.setDetails("Final Fantasy VII revolves around a company named Shinra that is drawing from the very life of the planet to create energy called Mako to power its technology. This process is causing widespread ecological problems. The main character, Cloud Strife, is a mercenary. He is hired by a rebel group, AVALANCHE , to destroy Shinra's Mako reactors in an attempt to slow down the planet's decay. Fellow Avalanche members Tifa Lockhart and Barret Wallace join Cloud even after his quest takes his focus away from Shinra. Along the way, Cloud and his group discover that Mako comes from the life energy of the planet, called the Lifestream. When the planet is injured, the energy from the Lifestream focuses on that injury to heal the planet. To make things even more troubling, Sephiroth, Cloud's former partner and the most powerful SOLDIER on the planet, plans to cause a planet-wide catastrophe by summoning Meteor to crash into the earth so he can draw all the Mako energy released to himself and gain god-like power.");
		games.put(ff, ff.getName());
	}
	
	public Collection<Game> getAll() {
		return games.keySet();
}
	
	public Game get(String name) {
		Game res = new Game();
		Collection<Game> aux = getAll();
		for(Game g: aux){
			if(g.getName().equals(name))
				res=g;
		}
		return res;
	}

	public void put(Game game) {
		games.put(game, game.getName());	
	}
	
	public void remove(String name) {	
		games.remove(get(name));
	}
}
