package mGameInfo.shared.domain.tw;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweets implements Serializable{

	private static final long serialVersionUID = -6900766006246287108L;
	
	public Tweets(){}
	
    @JsonProperty("id")
	private String id;
    @JsonProperty("text")
	private String text;
    @JsonProperty("user")
	private User user;
    @JsonProperty("retweet_count")
	private Integer retweet_count;
    @JsonProperty("favorite_count")
	private Integer favorite_count;
    @JsonProperty("favorited")
	private Boolean favorited;
    @JsonProperty("retweeted")
	private Boolean retweeted;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getRetweet_count() {
		return retweet_count;
	}
	
	public void setRetweet_count(Integer retweet_count) {
		this.retweet_count = retweet_count;
	}
	
	public Integer getFavorite_count() {
		return favorite_count;
	}
	
	public void setFavorite_count(Integer favorite_count) {
		this.favorite_count = favorite_count;
	}
	
	public Boolean getFavorited() {
		return favorited;
	}
	
	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}
	
	public Boolean getRetweeted() {
		return retweeted;
	}
	
	public void setRetweeted(Boolean retweeted) {
		this.retweeted = retweeted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
