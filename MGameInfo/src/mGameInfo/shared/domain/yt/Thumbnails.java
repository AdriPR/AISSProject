package mGameInfo.shared.domain.yt;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnails implements Serializable{

	private static final long serialVersionUID = -2487639927053427131L;
	
    @JsonProperty("default")
	private DefaultIMG default_img;

	public DefaultIMG getDefault_img() {
		return default_img;
	}

	public void setDefault_img(DefaultIMG default_img) {
		this.default_img = default_img;
	}
	
}
