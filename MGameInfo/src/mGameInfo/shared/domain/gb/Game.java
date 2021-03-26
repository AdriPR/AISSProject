package mGameInfo.shared.domain.gb;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game implements Serializable{
	
	private static final long serialVersionUID = -3482398853044700019L;

    @JsonProperty("id")
	private Integer id;
	private String name;

	private ImageURL image;
	
	public Game(){}
	
	public Integer getID(){
		return this.id;
	}
	
	public void setID(Integer id){
		this.id=id;
	}
	
	public ImageURL getImage(){
		return this.image;
	}
	
	public void setImage(ImageURL image){
		this.image=image;
	}
	
	public String getName(){
		return this.name;	
	}
	
	public void setName(String name){
		this.name=name;
	}

	
}
