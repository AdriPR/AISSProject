package mGameInfo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MGameInfo implements EntryPoint {

	static VerticalPanel result = new VerticalPanel();
	static HorizontalPanel menu = new HorizontalPanel();


	public void onModuleLoad() {
		go("init");
	}

	public static void go(String token) {

		final RootPanel p = RootPanel.get();
		
		if(token.equals("init")){

			p.clear();
			result.clear();
			menu.clear();
			result.add(menu);
			p.add(result);
			result.add(new GiantBomb());
		}

	}
}

