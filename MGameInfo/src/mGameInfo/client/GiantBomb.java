package mGameInfo.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import mGameInfo.client.services.GiantBombService;
import mGameInfo.client.services.GiantBombServiceAsync;
import mGameInfo.client.util.Strings;
import mGameInfo.shared.domain.da.ResultDA;
import mGameInfo.shared.domain.gb.Developers;
import mGameInfo.shared.domain.gb.Game;
import mGameInfo.shared.domain.gb.GameDetails;
import mGameInfo.shared.domain.gb.Genres;
import mGameInfo.shared.domain.gb.OriginalRating;
import mGameInfo.shared.domain.gb.Platforms;
import mGameInfo.shared.domain.gb.Publishers;
import mGameInfo.shared.domain.gb.Result;
import mGameInfo.shared.domain.gb.ResultDetails;
import mGameInfo.shared.domain.tw.Tweets;
import mGameInfo.shared.domain.yt.Items;

public class GiantBomb extends Composite{

	public static final HorizontalPanel horizontal = new HorizontalPanel();
	public static final VerticalPanel vertical = new VerticalPanel();
	public static final VerticalPanel vertical2 = new VerticalPanel();
	public static final FlexTable p = new FlexTable();
	public static final FlexTable p2 = new FlexTable();
	public static final HorizontalPanel buttons = new HorizontalPanel();

	private static final GiantBombServiceAsync gbS = GWT.create(GiantBombService.class);

	List<Game> games = new LinkedList<Game>();
	public static GameDetails gDetails = new GameDetails();
	public static String replacedName;
	List<OriginalRating> ratings = new LinkedList<OriginalRating>();
	List<Platforms> platforms = new LinkedList<Platforms>();
	List<Developers> developers = new LinkedList<Developers>();
	List<Publishers> publishers = new LinkedList<Publishers>();
	List<Genres> genres = new LinkedList<Genres>();

	public GiantBomb(){
		initWidget(horizontal);
		final TextBox box = new TextBox();

		Button clean = new Button("Clean");
		clean.setWidth("100px");
		clean.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				p.clear();
				p2.clear();
				p2.setBorderWidth(0);
			}
		});

		box.setText("Game name");
		box.setWidth("250px");
		box.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				if(box.getText().equals("Game name")){
					box.setText("");
				}
			}
		});

		box.addKeyUpHandler(new KeyUpHandler(){

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
					p2.setBorderWidth(0);
					games.removeAll(games);
					gbS.searchGames(box.getText(), new AsyncCallback<Result>() {

						public void onSuccess(Result results) {
							games.addAll(results.getGames());
							showGames(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("Couldn't search Games");
						}
					});
				}
			}
		});

		Button search = new Button("Search", new ClickHandler(){
			public void onClick(ClickEvent event) {
				p2.setBorderWidth(0);
				games.removeAll(games);
				gbS.searchGames(box.getText(), new AsyncCallback<Result>() {

					public void onSuccess(Result results) {
						games.addAll(results.getGames());
						showGames(results);
					}

					public void onFailure(Throwable caught) {
						Window.alert("Couldn't search Games");
					}

				});
			}
		});

		final Button logIn = new Button("Log In With Twitter");
		if(Twitter.TwToken==null || Twitter.TwToken.isEmpty()){
			logIn.addClickHandler(new ClickHandler(){	
				public void onClick(ClickEvent event) {
					Twitter.twS.authURL(new AsyncCallback<String>(){
						public void onFailure(Throwable caught) {	
							Window.alert("Error getting Authentincation URL");
						}

						public void onSuccess(String result) {
							logIn.setVisible(false);
							Twitter.doLogin(result);
						}
					});
				}	
			});
		}

		search.setWidth("100px");
		buttons.add(clean);
		buttons.add(box);
		buttons.add(search);
		buttons.add(logIn);
		horizontal.add(vertical);
		horizontal.add(vertical2);
		vertical.add(buttons);
		vertical.add(p);
		vertical2.add(p2);

	}

	private void showGames(Result results) {  //Resultados de la busqueda de videojuegos
		p.clear();
		p2.clear();
		Integer row = 0;
		Integer column = 0;

		for(final Game g:games){

			final Label name;
			if(g.getName() == null || g.getName().isEmpty()){
				name = new Label("No Games name.");
			}else {
				name = new Label(g.getName());
			}
			p.setWidget(row+1, column, name);

			if(g.getImage() == null){
				Image image = new Image("No_Image_Available.png");
				image.setWidth("200px");
				image.setHeight("200px");
				p.setWidget(row+2, column, image);
			}else{
				Image image = new Image(g.getImage().getImageUrl());
				image.setWidth("200px");
				image.setHeight("200px");
				p.setWidget(row+2, column, image);
			}

			Button gameDetails = new Button("Details");
			ClickHandler details = new ClickHandler(){

				public void onClick(ClickEvent event) {
					gbS.showDetails(g.getID().toString(), new AsyncCallback<ResultDetails>() {

						public void onSuccess(ResultDetails results) {
							gDetails = results.getGame();
							replacedName = Strings.replaceString(gDetails.getName());
							showGameDetails(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("Couldn't search Games");
						}

					});
				}
			};
			gameDetails.addClickHandler(details);
			p.setWidget(row+3, column, gameDetails);

			column++;
			if (column == 6) {
				column = 0;
				row += 6;
			}
		}
	}

	private void showGameDetails(ResultDetails results) {	//Muestra los detalles de un videojuego
		p.clear();
		p2.clear();
		Integer row = 0;
		Integer column = 0;
		final FlexTable ct = new FlexTable();
		vertical.add(ct);
		final FlexTable rt = new FlexTable();
		vertical.add(rt);
		final FlexTable plt = new FlexTable();
		vertical.add(plt);
		final FlexTable dvt = new FlexTable();
		vertical.add(dvt);
		final FlexTable pbt = new FlexTable();
		vertical.add(pbt);
		final FlexTable gt = new FlexTable();
		vertical.add(gt);
		final FlexTable desct = new FlexTable();
		vertical2.add(desct);	
		final FlexTable but = new FlexTable();
		vertical2.add(but);	

		final Label name;
		if(gDetails.getName() == null || gDetails.getName().isEmpty()){
			name = new Label("No Games name.");
		}else {
			name = new Label(gDetails.getName());
		}
		p2.setWidget(row+1, column, name);

		if(gDetails.getImage() == null){
			Image image = new Image("No_Image_Available.png");
			image.setWidth("200px");
			image.setHeight("200px");
			p2.setWidget(row+2, column, image);
		}else{
			Image image = new Image(gDetails.getImage().getImageUrl());
			image.setWidth("200px");
			image.setHeight("200px");
			p2.setWidget(row+2, column, image);
		}

		final Label original_release_date;
		if(gDetails.getOriginal_release_date() == null || gDetails.getOriginal_release_date().isEmpty()){
			original_release_date = new Label("No release date available.");
		}else {
			original_release_date = new Label("Release Date: " + gDetails.getOriginal_release_date());
		}
		ct.setWidget(row+3, column, original_release_date);

		Label rating;
		Label ratlbl = new Label("Rating: ");
		rt.setWidget(row+4, column, ratlbl);
		if(gDetails.getOriginalGameRating() == null ||gDetails.getOriginalGameRating().isEmpty()){
			rating = new Label("No rating available");
			rt.setWidget(row+4, column+1, rating);
		}else{
			ratings.addAll(gDetails.getOriginalGameRating());
			Integer ratingColumn = column+1;
			for(OriginalRating r:ratings){
				rating = new Label(r.getName());
				rt.setWidget(row+4, ratingColumn, rating);
				ratingColumn++;
			}
		}

		Label platform;
		Label platlbl = new Label("Platforms: ");
		plt.setWidget(row+5, column, platlbl);
		if(gDetails.getPlatforms() == null || gDetails.getPlatforms().isEmpty()){
			platform = new Label("No platforms available");
			plt.setWidget(row+5, column+1, platform);
		}else{
			platforms.addAll(gDetails.getPlatforms());
			Integer platformColumn = column+1;
			for(Platforms plat:platforms){
				platform = new Label(plat.getAbbreviation() + "(" + plat.getName() + ")");
				plt.setWidget(row+5, platformColumn, platform);
				platformColumn++;
			}
		}

		Label developer;
		Label devlbl = new Label ("Developers: ");
		dvt.setWidget(row+6, column, devlbl);
		if(gDetails.getDevelopers() == null || gDetails.getDevelopers().isEmpty()){
			developer = new Label("No developers available");
			dvt.setWidget(row+6, column+1, developer);
		}else{
			developers.addAll(gDetails.getDevelopers());
			Integer devColumn = column+1;
			for(Developers dev:developers){
				developer = new Label(dev.getName());
				dvt.setWidget(row+6, devColumn, developer);
				devColumn++;
			}
		}

		Label publisher;
		Label publbl = new Label("Publishers: ");
		pbt.setWidget(row+7, column, publbl);
		if(gDetails.getPublishers() == null || gDetails.getPublishers().isEmpty()){
			publisher = new Label("No publishers available");
			pbt.setWidget(row+7, column+1, publisher);
		}else{
			publishers.addAll(gDetails.getPublishers());
			Integer pubColumn = column+1;
			for(Publishers pub:publishers){
				publisher = new Label(pub.getName());
				pbt.setWidget(row+7, pubColumn, publisher);
				pubColumn++;
			}
		}

		Label genre;
		Label genlbl = new Label("Genres: ");
		gt.setWidget(row+8, column, genlbl);
		if(gDetails.getGenres() == null || gDetails.getGenres().isEmpty()){
			genre = new Label("No genres available");
			gt.setWidget(row+8, column+1, genre);
		}else{
			genres.addAll(gDetails.getGenres());
			Integer genColumn = column+1;
			for(Genres gen:genres){
				genre = new Label(gen.getName());
				gt.setWidget(row+8, genColumn, genre);
				genColumn++;
			}
		}

		HTML description = new HTML();
		if(!(gDetails.getDescription() == null || gDetails.getDescription().isEmpty())){
			description.setHTML(gDetails.getDescription());
		}
		p.setWidget(row+1, column, description);

		Button showVid = new Button("Videos");
		ClickHandler vid = new ClickHandler(){

			public void onClick(ClickEvent event) {
				Youtube.ytS.searchVideos(replacedName, new AsyncCallback<Items>() {

					public void onSuccess(Items results) {
						Youtube.videos = results.getVideos();
						Youtube.showVideos(results);
					}

					public void onFailure(Throwable caught) {
						Window.alert("Couldn't search Games");
					}
				});
			}
		};
		showVid.addClickHandler(vid);

		Button showArt = new Button("FanArt");
		ClickHandler art = new ClickHandler(){

			public void onClick(ClickEvent event) {
				DeviantArt.firstPage=true;
				DeviantArt.offset=0;
				DeviantArt.daS.searchFanArt(DeviantArt.offset, replacedName, new AsyncCallback<ResultDA>() {

					public void onSuccess(ResultDA results) {
						DeviantArt.fanart = results.getFanArts();
						DeviantArt.showFanArt(results);
					}

					public void onFailure(Throwable caught) {
						Window.alert("No Art available");
					}
				});
			}
		};
		showArt.addClickHandler(art);

		Button showFeedback = new Button("Tweets");
		if(Twitter.TwToken!=null){
			showFeedback.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					Twitter.twS.searchTweets(replacedName, new AsyncCallback<List<Tweets>>(){

						public void onFailure(Throwable caught) {
							Window.alert("ERROR");
						}
						public void onSuccess(List<Tweets> result) {
							Twitter.tweets.addAll(result);
							Twitter.showTweets(result);
						}
					});
				}
			});
			but.setWidget(row, column+2, showFeedback);
		}

		but.setWidget(row, column, showVid);
		but.setWidget(row, column+1, showArt);

		p2.setWidget(row+3, column, ct);
		p2.setWidget(row+4, column, rt);
		p2.setWidget(row+5, column, plt);
		p2.setWidget(row+6, column, dvt);
		p2.setWidget(row+7, column, pbt);
		p2.setWidget(row+8, column, gt);
		p2.setWidget(row+9, column, but);
		p2.setBorderWidth(5);

	}

}
