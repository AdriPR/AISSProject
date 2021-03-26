package mGameInfo.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import mGameInfo.api.resources.GameResource;

public class MGameInfoApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public MGameInfoApplication() {
		singletons.add(new GameResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
