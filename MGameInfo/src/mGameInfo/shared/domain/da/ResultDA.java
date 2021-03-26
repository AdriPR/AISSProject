package mGameInfo.shared.domain.da;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDA implements Serializable{

	private static final long serialVersionUID = 7476036416426168170L;
	
    @JsonProperty("has_more")
	private Boolean has_more;
    @JsonProperty("next_offset")
	private Integer next_offset;
    @JsonProperty("estimated_total")
    private Integer estimated_total;
    @JsonProperty("results")
	private List<FanArt> results;
	
	public List<FanArt> getFanArts(){
		return this.results;
	}
	
	public void setFanArts(List<FanArt> fanArt){
		this.results=fanArt;
	}
	
	public Boolean getHas_more() {
		return has_more;
	}

	public void setHas_more(Boolean has_more) {
		this.has_more = has_more;
	}

	public Integer getNext_offset() {
		return next_offset;
	}

	public void setNext_offset(Integer next_offset) {
		this.next_offset = next_offset;
	}

	public Integer getEstimated_total() {
		return estimated_total;
	}

	public void setEstimated_total(Integer estimated_total) {
		this.estimated_total = estimated_total;
	}

}
