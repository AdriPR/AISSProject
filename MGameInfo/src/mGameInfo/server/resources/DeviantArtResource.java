package mGameInfo.server.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import mGameInfo.shared.domain.da.ResultDA;
import mGameInfo.shared.domain.da.Token;

public class DeviantArtResource {
	
	private String DASearch = "https://www.deviantart.com/api/v1/oauth2/browse/popular?q=";
	private String DAToken = "https://www.deviantart.com/oauth2/token/?client_id=5124&client_secret=0e2327a1210e0c928541a8fa9bfe957f&grant_type=client_credentials";
	
	public ResultDA searchFanArt(Integer offset, String s) {
		ResultDA fanArt = null;
		try {
			ClientResource cr = new ClientResource(DASearch + daString(s) + "&timerange=alltime&mature_content=false&limit=20&offset=" + offset + "&access_token=" + this.getToken().getAccess_token());
			fanArt = cr.get(ResultDA.class);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
		return fanArt;
	}
	
	public Token getToken() {
		Token token = null;
		try {
			ClientResource cr = new ClientResource(DAToken);
			token = cr.get(Token.class);
		} catch (ResourceException re) {
			System.err.println("Error.");
		}
		return token;
	}
	
	public static String daString(String str){
		try {
			str = URLEncoder.encode(str, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
