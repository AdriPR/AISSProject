package mGameInfo.shared.domain.gb;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageURL implements Serializable{

	private static final long serialVersionUID = 5748792086514096454L;
	
    @JsonProperty("medium_url")
	private String medium_url;

	public String getImageUrl(){
		return this.medium_url;
	}
	
	public void setImageUrl(String medium_url){
		this.medium_url=medium_url;
	}

}
