package mGameInfo.shared.domain.da;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FanArt implements Serializable{

	private static final long serialVersionUID = 5330268645581606485L;
	
    @JsonProperty("deviationid")
	private String deviationid;
    @JsonProperty("title")
	private String title;
    @JsonProperty("author")
	private Author author;
    @JsonProperty("content")
	private Content content;
    @JsonProperty("thumbs")
    private List<Content> thumbs;
	
	public String getDeviationid() {
		return deviationid;
	}
	
	public void setDeviationid(String deviationid) {
		this.deviationid = deviationid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Content getContent() {
		return content;
	}
	
	public void setContent(Content content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Content> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Content> thumbs) {
		this.thumbs = thumbs;
	}

}
