package mGameInfo.shared.domain.tw;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statuses implements Serializable{

	private static final long serialVersionUID = 3865801780438372671L;

	public Statuses(){}
	
    @JsonProperty("statuses")
	private List<Tweets> statuses;

	public List<Tweets> getTweets() {
		return statuses;
	}

	public void setTweets(List<Tweets> statuses) {
		this.statuses = statuses;
	}
	
}
