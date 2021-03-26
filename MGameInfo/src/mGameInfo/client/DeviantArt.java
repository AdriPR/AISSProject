package mGameInfo.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import mGameInfo.client.services.DeviantArtService;
import mGameInfo.client.services.DeviantArtServiceAsync;
import mGameInfo.shared.domain.da.FanArt;
import mGameInfo.shared.domain.da.ResultDA;

public class DeviantArt {

	public static String dAToken;

	public static final DeviantArtServiceAsync daS = GWT.create(DeviantArtService.class);

	public static List<FanArt> fanart = new LinkedList<FanArt>();
	static Boolean firstPage;
	static Integer offset;

	public DeviantArt(){}

	public static void showFanArt(final ResultDA results) {
		GiantBomb.p.clear();
		Integer row = 0;
		Integer column = 0;

		for(FanArt f:fanart){
			if(f.getThumbs().isEmpty()){
				fanart.remove(f);
			}
		}

		for(final FanArt f:fanart){
			if(f.getContent().getSrc() == null){
				Window.alert("ERROR");
			}else{
				Image image = new Image(f.getContent().getSrc());
				image.setWidth("200px");
				image.setHeight("200px");
				image.addClickHandler(new ClickHandler(){
					public void onClick(ClickEvent event) {
						Window.open(f.getContent().getSrc(), "_blank", "");
					}

				});
				GiantBomb.p.setWidget(row+1, column, image);
			}

			final Label title;
			if(f.getTitle() == null || f.getTitle().isEmpty()){
				title = new Label("No Title.");
			}else {
				title = new Label(f.getTitle() + " (By: " + f.getAuthor().getUsername() + ")");
			}
			GiantBomb.p.setWidget(row+2, column, title);

			column++;
			if (column == 5) {
				column = 0;
				row += 5;
			}
		}

		if(results.getHas_more()==true && firstPage==true){

			Button next = new Button("Next");
			ClickHandler nextPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					firstPage=false;
					offset = results.getNext_offset();
					daS.searchFanArt(offset, GiantBomb.replacedName, new AsyncCallback<ResultDA>() {

						public void onSuccess(ResultDA results) {
							fanart = results.getFanArts();
							showFanArt(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Art available");
						}
					});
				}
			};
			next.addClickHandler(nextPage);
			GiantBomb.p.setWidget(row+1, column+7, next);

			Button last = new Button("Last");
			ClickHandler lastPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					firstPage=false;
					offset = results.getEstimated_total()-20;
					daS.searchFanArt(offset, GiantBomb.replacedName, new AsyncCallback<ResultDA>() {

						public void onSuccess(ResultDA results) {
							fanart = results.getFanArts();
							showFanArt(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Art available");
						}
					});
				}
			};
			last.addClickHandler(lastPage);
			GiantBomb.p.setWidget(row+1, column+8, last);

		}else if(results.getHas_more()==true && firstPage==false){

			Button prev = new Button("Prev");
			ClickHandler prevPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					offset = offset - 20;
					if(offset==0){
						firstPage=true;
					}
					daS.searchFanArt(offset, GiantBomb.replacedName, new AsyncCallback<ResultDA>() {

						public void onSuccess(ResultDA results) {
							fanart = results.getFanArts();
							showFanArt(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Art available");
						}
					});
				}
			};
			prev.addClickHandler(prevPage);
			GiantBomb.p.setWidget(row+1, column+6, prev);

			Button next = new Button("Next");
			ClickHandler nextPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					firstPage=false;
					offset = results.getNext_offset();
					daS.searchFanArt(offset, GiantBomb.replacedName, new AsyncCallback<ResultDA>() {

						public void onSuccess(ResultDA results) {
							fanart = results.getFanArts();
							showFanArt(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Art available");
						}
					});
				}
			};
			next.addClickHandler(nextPage);
			GiantBomb.p.setWidget(row+1, column+7, next);

			Button last = new Button("Last");
			ClickHandler lastPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					firstPage=false;
					offset = results.getEstimated_total()-20;
					daS.searchFanArt(offset, GiantBomb.replacedName, new AsyncCallback<ResultDA>() {

						public void onSuccess(ResultDA results) {
							fanart = results.getFanArts();
							showFanArt(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Art available");
						}
					});
				}
			};
			last.addClickHandler(lastPage);
			GiantBomb.p.setWidget(row+1, column+8, last);

		}else if(results.getHas_more()==false){
			Button prev = new Button("Prev");
			ClickHandler prevPage = new ClickHandler(){
				public void onClick(ClickEvent event) {
					offset = offset - 20;
					if(offset==0){
						firstPage=true;
					}
					daS.searchFanArt(offset, GiantBomb.replacedName, new AsyncCallback<ResultDA>() {

						public void onSuccess(ResultDA results) {
							fanart = results.getFanArts();
							showFanArt(results);
						}

						public void onFailure(Throwable caught) {
							Window.alert("No Art available");
						}
					});
				}
			};
			prev.addClickHandler(prevPage);
			GiantBomb.p.setWidget(row+1, column+6, prev);
		}

	}
}
