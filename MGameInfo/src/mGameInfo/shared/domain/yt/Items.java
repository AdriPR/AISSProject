package mGameInfo.shared.domain.yt;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable{

	private static final long serialVersionUID = -3450563237757855304L;
	
    @JsonProperty("items")
	private List<VideoYT> videos;
    @JsonProperty("nextPageToken")
    private String nextPageToken;
    @JsonProperty("prevPageToken")
    private String prevPageToken;

	public List<VideoYT> getVideos() {
		return videos;
	}
	
	public void setVideos(List<VideoYT> videos) {
		this.videos = videos;
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}
	
	public String getPrevPageToken() {
		return prevPageToken;
	}

	public void setPrevPageToken(String prevPageToken) {
		this.prevPageToken = prevPageToken;
	}

}
