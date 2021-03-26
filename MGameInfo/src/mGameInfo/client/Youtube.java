package mGameInfo.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import mGameInfo.client.services.YoutubeService;
import mGameInfo.client.services.YoutubeServiceAsync;
import mGameInfo.shared.domain.yt.Items;
import mGameInfo.shared.domain.yt.VideoYT;

public class Youtube extends Composite{

	public static final YoutubeServiceAsync ytS = GWT.create(YoutubeService.class);

	public static List<VideoYT> videos = new LinkedList<VideoYT>();
	public static String YtToken;
	
	static String embedHTML1 = "<iframe width=\"640\" height=\"360\" src=\"//www.youtube.com/embed/";
	static String embedHTML2 = "\" frameborder=\"0\" allowfullscreen></iframe>";

	public Youtube(){}
	
	public static void showVideos(final Items vidResult) {	
		GiantBomb.p.clear();
		Integer row = 0;
		Integer column = 0;
		final FlexTable likesIcon = new FlexTable();
		GiantBomb.vertical.add(likesIcon);
		final FlexTable commentBox = new FlexTable();
		GiantBomb.vertical.add(commentBox);

		for(final VideoYT v:videos){

			ClickHandler goVideo = new ClickHandler() {

				public void onClick(ClickEvent event) {	
					GiantBomb.p.clear();
					String html = new String();
					final String id = v.getVideoID().getVideoId();
					html = embedHTML1 + id + embedHTML2;
					HTML player = new HTML();
					player.setHTML(html);
					GiantBomb.p.setWidget(1, 1, player);

					/*	final Image likeIMG = new Image("like.png");
					final Image likedIMG = new Image("liked.png");
					final Image dislikeIMG = new Image("dislike.png");
					final Image dislikedIMG = new Image("disliked.png");

					likeIMG.setPixelSize(25, 25);
					likedIMG.setPixelSize(25, 25);
					dislikeIMG.setPixelSize(25, 25);
					dislikedIMG.setPixelSize(25, 25);

					ClickHandler likeVid = new ClickHandler(){	
						public void onClick(ClickEvent event) {
							ytS.like(YtToken, id, new AsyncCallback<Void>(){
								public void onFailure(Throwable caught) {					
								}
								public void onSuccess(Void result) {
									likesIcon.setWidget(2, 1, likedIMG);
									likesIcon.setWidget(2, 2, dislikeIMG);
								}	
							});
						}
					};

					ClickHandler dislikeVid = new ClickHandler(){	
						public void onClick(ClickEvent event) {
							ytS.dislike(YtToken, id, new AsyncCallback<Void>(){
								public void onFailure(Throwable caught) {					
								}
								public void onSuccess(Void result) {
									likesIcon.setWidget(2, 1, likeIMG);
									likesIcon.setWidget(2, 2, dislikedIMG);
								}	
							});
						}
					};

					likeIMG.addClickHandler(likeVid);
					dislikeIMG.addClickHandler(dislikeVid);
					likesIcon.setWidget(2, 1, likeIMG);
					likesIcon.setWidget(2, 2, dislikeIMG);
					p.setWidget(2, 1, likesIcon);*/
				} 

			};

			if(v.getSnippet().getThumbnails().getDefault_img().getUrl() == null){
				Image image = new Image("No_Image_Available.png");
				image.setWidth("200px");
				image.setHeight("200px");
				GiantBomb.p.setWidget(row+2, column, image);
			}else{
				Image image = new Image(v.getSnippet().getThumbnails().getDefault_img().getUrl());
				image.addClickHandler(goVideo);
				GiantBomb.p.setWidget(row+2, column, image);
			}

			final Label title;
			if(v.getSnippet().getTitle() == null || v.getSnippet().getTitle().isEmpty()){
				title = new Label("No videos.");
			}else {
				title = new Label(v.getSnippet().getTitle());
			}
			GiantBomb.p.setWidget(row+3, column, title);

			column++;
			if (column == 5) {
				column = 0;
				row += 5;
			}
		}

		if(vidResult.getNextPageToken() != null){	//Siguiente página de videos
			Button next = new Button("Next");
			ClickHandler nextPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					ytS.nextPage(GiantBomb.replacedName, vidResult.getNextPageToken(), new AsyncCallback<Items>() {

						public void onSuccess(Items results) {
							videos = results.getVideos();
							showVideos(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Videos.");
						}
					});
				}
			};
			next.addClickHandler(nextPage);
			GiantBomb.p.setWidget(row+1, column+7, next);
		}

		if(vidResult.getPrevPageToken() != null){	//Volver a la página anterior de videos
			Button prev = new Button("Previous");
			ClickHandler prevPage = new ClickHandler(){

				public void onClick(ClickEvent event) {
					ytS.prevPage(GiantBomb.replacedName,vidResult.getPrevPageToken(), new AsyncCallback<Items>() {

						public void onSuccess(Items results) {
							videos = results.getVideos();
							showVideos(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Videos");
						}

					});
				}
			};
			prev.addClickHandler(prevPage);
			GiantBomb.p.setWidget(row+1, column+6, prev);
		}

	}

}
