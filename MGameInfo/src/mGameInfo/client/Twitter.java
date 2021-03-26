package mGameInfo.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import mGameInfo.client.services.TwitterService;
import mGameInfo.client.services.TwitterServiceAsync;
import mGameInfo.client.util.Strings;
import mGameInfo.shared.domain.tw.Tweets;

public class Twitter {

	public static String TwrequestToken;
	public static String TwToken;
	public static String TwTokenSecret;
	public static List<Tweets> tweets = new ArrayList<Tweets>();

	public static final TwitterServiceAsync twS = GWT.create(TwitterService.class);

	public Twitter(){}

	public static void getToken(String ar){
		String[] split;
		split = ar.split("oauth_token=");
		split = split[1].split("&oauth_token_secret=");
		TwToken = split[0];
		split = split[1].split("&user_id=");
		TwTokenSecret = split[0];
	}

	public static void doLogin(String res){
		Window.open(res, "_blank", "");
		final TextBox verifier = new TextBox();
		GiantBomb.buttons.add(verifier);
		verifier.setText("Enter Pin");
		verifier.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				if(verifier.getText().equals("Enter Pin")){
					verifier.setText("");
				}
			}
		});

		verifier.addKeyUpHandler(new KeyUpHandler(){
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
					Twitter.twS.accessToken(verifier.getText(), new AsyncCallback<String>(){
						public void onFailure(Throwable caught) {
							Window.alert("Incorrect Pin");
						}

						public void onSuccess(String result) {
							Twitter.getToken(result);
							verifier.setVisible(false);
							Window.alert("You have been loged in Twitter! \nToken: " + Twitter.TwToken + "\nToken Secret: " + Twitter.TwTokenSecret);
						}
					});			
				}
			}
		});
	}

	public static void showTweets(List<Tweets> result) {
		GiantBomb.p.clear();
		Integer row = 2;
		Integer column = 0;

		Label pt = new Label("Post a Tweet!");
		final TextBox tweet = new TextBox();
		tweet.setText("#" + Strings.replaceStringTweet2(GiantBomb.replacedName));
		tweet.setPixelSize(700, 50);
		
		Button postTweet = new Button("Post", new ClickHandler(){
			public void onClick(ClickEvent event) {
				Integer j = 140 - tweet.getText().length();
				if(j>=0){
					twS.post(tweet.getText(), new AsyncCallback<Void>() {
						public void onSuccess(Void results) {
							Window.alert("Tweeted!");
						}

						public void onFailure(Throwable caught) {
							Window.alert("Error");
						}

					});
				}else{
					Window.alert("Your tweet is longer than 140 characters! \n Characters: " + j);
				}
				
			}
		});
		
		GiantBomb.p.setWidget(1, 1, pt);
		GiantBomb.p.setWidget(2, 1, tweet);
		GiantBomb.p.setWidget(2, 2, postTweet);
		
		for(final Tweets t:result){
			final Integer r = row;
			final Integer c = column;
			
			if(t.getUser().getProfile_image_url() == null || t.getUser().getProfile_image_url().isEmpty()){
				Image avatar = new Image("No_Image_Available.png");
				avatar.setWidth("100px");
				avatar.setHeight("100px");
				GiantBomb.p.setWidget(row+1, column, avatar);
			}else {
				Image avatar = new Image(t.getUser().getProfile_image_url());
				GiantBomb.p.setWidget(row+1, column, avatar);
			}

			final Label name;
			if(t.getUser().getScreen_name() == null || t.getUser().getScreen_name().isEmpty()){
				name = new Label("No name.");
			}else {
				name = new Label("@" + t.getUser().getScreen_name());
				GiantBomb.p.setWidget(row+1, column+1, name);
			}

			final Label text;
			if(t.getText() == null || t.getText().isEmpty()){
				text = new Label("No tweet.");
			}else {
				text = new Label(t.getText());
				GiantBomb.p.setWidget(row+2, column+1, text);
			}

			final Image likeIMG = new Image("like.png");
			final Image likedIMG = new Image("liked.png");
			final Image retweetIMG = new Image("retweet.png");
			final Image retweetedIMG = new Image("retweeted.png");

			likeIMG.setPixelSize(25, 25);
			likedIMG.setPixelSize(25, 25);
			retweetIMG.setPixelSize(25, 25);
			retweetedIMG.setPixelSize(25, 25);
			
			ClickHandler rt = new ClickHandler(){
				public void onClick(ClickEvent event) {
					twS.retweet(t.getId(), new AsyncCallback<Void>(){
						public void onFailure(Throwable caught) {					
						}
						public void onSuccess(Void result) {
							GiantBomb.p.setWidget(r+3, c, retweetedIMG);
						}	
					});
				}
			};
			
			ClickHandler unrt = new ClickHandler(){
				public void onClick(ClickEvent event) {
					twS.unretweet(t.getId(), new AsyncCallback<Void>(){
						public void onFailure(Throwable caught) {					
						}
						public void onSuccess(Void result) {
							GiantBomb.p.setWidget(r+3, c, retweetIMG);
						}	
					});
				}
			};
			
			ClickHandler fav = new ClickHandler(){
				public void onClick(ClickEvent event) {
					twS.fav(t.getId(), new AsyncCallback<Void>(){
						public void onFailure(Throwable caught) {					
						}
						public void onSuccess(Void result) {
							GiantBomb.p.setWidget(r+3, c+1, likedIMG);
						}	
					});
				}
			};

			ClickHandler unfav = new ClickHandler(){
				public void onClick(ClickEvent event) {
					twS.unfav(t.getId(), new AsyncCallback<Void>(){
						public void onFailure(Throwable caught) {					
						}
						public void onSuccess(Void result) {
							GiantBomb.p.setWidget(r+3, c+1, likeIMG);
						}	
					});
				}
			};
			
			retweetIMG.addClickHandler(rt);
			retweetedIMG.addClickHandler(unrt);
			likeIMG.addClickHandler(fav);
			likedIMG.addClickHandler(unfav);
			
			if(t.getRetweeted()){
				GiantBomb.p.setWidget(r+3, c, retweetedIMG);
			}else{
				GiantBomb.p.setWidget(r+3, c, retweetIMG);
			}
			
			if(t.getFavorited()){
				GiantBomb.p.setWidget(r+3, c+1, likedIMG);
			}else{
				GiantBomb.p.setWidget(r+3, c+1, likeIMG);
			}
			
			row= row+20;
		}
	}
}
