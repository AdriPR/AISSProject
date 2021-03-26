package mGameInfo.shared.domain.tw;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable{

	private static final long serialVersionUID = 159721956688952297L;
	
    @JsonProperty("screen_name")
	private String screen_name;
    @JsonProperty("profile_image_url")
	private String profile_image_url;
	
	public String getScreen_name() {
		return screen_name;
	}
	
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	
	public String getProfile_image_url() {
		return profile_image_url;
	}
	
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

}
