package cscie99.team2.lingolearn.client.view;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import cscie99.team2.lingolearn.shared.Course;

public class HomeView extends Composite {
  
  interface Binder extends UiBinder<Widget, HomeView> { }
  private static final Binder binder = GWT.create(Binder.class);

  @UiField Element coursesAsStudent;
  @UiField Element coursesAsInstructor;
  @UiField Button sampleCardButton;
  
  public HomeView() {
	  initWidget(binder.createAndBindUi(this));
  }
  
  public HasClickHandlers getSampleCardButton() {
	  return sampleCardButton;
  }

  public void setCoursesUserIsInstructing(ArrayList<Course> courses) {
	  this.populateCourseList(this.coursesAsInstructor, courses);
  }
  
  public void setCoursesUserIsEnrolledIn(ArrayList<Course> courses) {
	  this.populateCourseList(this.coursesAsStudent, courses);
  }
  
  private void populateCourseList(Element courseContainer, ArrayList<Course> courses) {
	  for (int i=0;i<courses.size();i++) {
		  courseContainer.setInnerHTML("<a href='#viewCard'>" + courses.get(i).getName() + "</a>");
	  }
  }
  
  public Widget asWidget() {
    return this;
  }
}
