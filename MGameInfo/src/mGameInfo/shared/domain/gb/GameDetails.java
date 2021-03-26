package mGameInfo.shared.domain.gb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDetails implements Serializable{
	
	private static final long serialVersionUID = 3431558495773834779L;
	
	private String name;
	private String deck;
	private String description;
	private String original_release_date;

	private ImageURL image;
    @JsonProperty("original_game_rating")
	private List<OriginalRating> original_game_rating;
    @JsonProperty("platforms")
	private List<Platforms> platforms;
	private List<Developers> developers;
	private List<Genres> genres;
	private List<Publishers> publishers;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ImageURL getImage(){
		return image;
	}
	
	public void setImage(ImageURL image){
		this.image=image;
	}
	
	public List<OriginalRating> getOriginalGameRating() {
		return original_game_rating;
	}

	public void setOriginalGameRating(List<OriginalRating> original_game_rating) {
		this.original_game_rating = original_game_rating;
	}

	public List<Platforms> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<Platforms> platforms) {
		this.platforms = platforms;
	}
	
	public List<Developers> getDevelopers(){
		return developers;
	}
	
	public void setDevelopers(List<Developers> developers){
		this.developers=developers;
	}
	
	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriginal_release_date() {
		return original_release_date;
	}

	public List<Genres> getGenres() {
		return genres;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

	public List<Publishers> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publishers> publishers) {
		this.publishers = publishers;
	}
}
