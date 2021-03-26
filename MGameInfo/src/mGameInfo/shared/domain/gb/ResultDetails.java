package mGameInfo.shared.domain.gb;

import java.io.Serializable;
import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResultDetails implements Serializable{

	private static final long serialVersionUID = 6103269566053323315L;
	
    @JsonProperty("results")
	private GameDetails results;
	
	public GameDetails getGame(){
		return this.results;
	}
	
	public void setGame(GameDetails game){
		this.results=game;
	}
	
	

}
