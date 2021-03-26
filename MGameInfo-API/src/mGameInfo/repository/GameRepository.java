package mGameInfo.repository;

import java.util.Collection;

import mGameInfo.domain.Game;

public interface GameRepository {

	public Collection<Game> getAll();
	public Game get(String name);
	public void put(Game game);
	public void remove(String name);

}
