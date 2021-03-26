package mGameInfo.shared.domain.da;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content implements Serializable{

	private static final long serialVersionUID = -4499719451488364173L;
	
    @JsonProperty("src")
	private String src;
    @JsonProperty("height")
	private Integer heightIMG;
    @JsonProperty("width")
	private Integer widthIMG;
	
	public String getSrc() {
		return src;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	public Integer getHeightIMG() {
		return heightIMG;
	}
	
	public void setHeightIMG(Integer heightIMG) {
		this.heightIMG = heightIMG;
	}
	
	public Integer getWidthIMG() {
		return widthIMG;
	}
	
	public void setWidthIMG(Integer widthIMG) {
		this.widthIMG = widthIMG;
	}
	
}
