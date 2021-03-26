package mGameInfo.domain;

public class Game {
	
	private String name;
	private String cover;
	private String details;
	
	public Game(){}
	
	public Game(String name, String cover, String details){
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}

}
