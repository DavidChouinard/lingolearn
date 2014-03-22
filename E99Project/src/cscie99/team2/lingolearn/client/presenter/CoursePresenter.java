package cscie99.team2.lingolearn.client.presenter;


import cscie99.team2.lingolearn.client.CourseServiceAsync;
import cscie99.team2.lingolearn.client.event.ViewCardEvent;
import cscie99.team2.lingolearn.client.view.CourseView;
import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Course;
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
import java.util.List;

public class CoursePresenter implements Presenter {  

  private final HandlerManager eventBus;
  private final CourseView display;
  private final CourseServiceAsync courseService;
  
  public CoursePresenter(CourseServiceAsync courseService, HandlerManager eventBus, CourseView display) {
    this.courseService = courseService;
	  this.eventBus = eventBus;
      this.display = display;
  }
  
  public void bind() {
    
  }
  
  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
    populateUserCourseInfo();
  }
  
  private void populateUserCourseInfo() {
	  //TODO: use UserService to get user info
	  courseService.getCourseById((long) 1,  new AsyncCallback<Course>() {
		  public void onSuccess(Course course) {
	          display.setCourseData(course);
	      }
	      
	      public void onFailure(Throwable caught) {
	        Window.alert("Error fetching contact details");
	      }
	  });
	  
  }
  

}
