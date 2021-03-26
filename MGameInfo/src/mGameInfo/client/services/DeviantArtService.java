package mGameInfo.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import mGameInfo.shared.domain.da.ResultDA;
import mGameInfo.shared.domain.da.Token;

@RemoteServiceRelativePath("deviantart")
public interface DeviantArtService extends RemoteService{
	
	ResultDA searchFanArt(Integer o, String s);
	Token getToken();
	
}
