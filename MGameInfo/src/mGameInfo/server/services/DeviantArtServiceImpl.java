package mGameInfo.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import mGameInfo.client.services.DeviantArtService;
import mGameInfo.server.resources.DeviantArtResource;
import mGameInfo.shared.domain.da.ResultDA;
import mGameInfo.shared.domain.da.Token;

public class DeviantArtServiceImpl extends RemoteServiceServlet implements DeviantArtService{

	private static final long serialVersionUID = 1500712052263060283L;
	
	private DeviantArtResource DeviantArtR;
	
	public DeviantArtServiceImpl(){
		DeviantArtR = new DeviantArtResource();
	}

	public ResultDA searchFanArt(Integer o, String s) {
		return DeviantArtR.searchFanArt(o, s);
	}

	public Token getToken() {
		return DeviantArtR.getToken();
	}

}
