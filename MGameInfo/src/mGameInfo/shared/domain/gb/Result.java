package mGameInfo.shared.domain.gb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable{

	private static final long serialVersionUID = 7476036416426168170L;
	
    @JsonProperty("results")
	private List<Game> results;
	
	public List<Game> getGames(){
		return this.results;
	}
	
	public void setGames(List<Game> game){
		this.results=game;
	}
	

}
