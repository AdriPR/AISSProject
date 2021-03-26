package mGameInfo.shared.domain.yt;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoYT implements Serializable{

	private static final long serialVersionUID = -4355747812613772480L;
	
    @JsonProperty("id")
	private ID videoID;
    @JsonProperty("snippet")
	private Snippet snippet;

	public ID getVideoID() {
		return videoID;
	}
	
	public void setVideoID(ID videoID) {
		this.videoID = videoID;
	}
	
	public Snippet getSnippet() {
		return snippet;
	}
	
	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}

}
