package cscie99.team2.lingolearn.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class LingoLearn implements EntryPoint {

	@Override
	public void onModuleLoad() {
		//Set up controller / event manager
		CourseServiceAsync courseService = GWT.create(CourseService.class);
		CardServiceAsync cardService = GWT.create(CardService.class);
	    HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(courseService, cardService, eventBus);
	    
	    //Clear loading screen
	    RootPanel.get("content").clear(true);
	    
	    //Go to home page
	    appViewer.go(RootPanel.get("content"));
	    
	}

}
