package cscie99.team2.lingolearn.client.presenter;


import cscie99.team2.lingolearn.client.AnalyticsService;
import cscie99.team2.lingolearn.client.AnalyticsServiceAsync;
import cscie99.team2.lingolearn.client.CardService;
import cscie99.team2.lingolearn.client.CardServiceAsync;
import cscie99.team2.lingolearn.client.CourseServiceAsync;
import cscie99.team2.lingolearn.client.event.ViewCardEvent;
import cscie99.team2.lingolearn.client.view.CardView;
import cscie99.team2.lingolearn.client.view.CourseView;
import cscie99.team2.lingolearn.client.view.SessionView;
import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Course;
import cscie99.team2.lingolearn.shared.Lesson;
import cscie99.team2.lingolearn.shared.Session;
import cscie99.team2.lingolearn.shared.User;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SessionPresenter implements Presenter {  

  private final HandlerManager eventBus;
  private final SessionView display;
  private final CourseServiceAsync courseService;
  private final CardPresenter cardPresenter;
  
  public SessionPresenter(CourseServiceAsync courseService, 
		  CardServiceAsync cardService, HandlerManager eventBus, 
		  SessionView display) {
      this.courseService = courseService;
      this.cardPresenter = new CardPresenter(cardService, eventBus, new CardView());
	  this.eventBus = eventBus;
      this.display = display;
      
      //Let the card presenter handle the card display
      this.cardPresenter.go(this.display.getCardContainer());
  }
  
  public void bind() {
    
  }
  
  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
    
    //Set session to dummy
    this.setSession(new Lesson());
  }
  
  /*
   * Sets and starts a session
   */
  public void setSession(Session session) {
	  this.display.setSessionName("Test session");
	  //session.getDeck().getCardIds()
  }
  

}
