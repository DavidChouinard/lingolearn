package cscie99.team2.lingolearn.client.view;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Element;

import cscie99.team2.lingolearn.shared.Course;

public class CourseView extends Composite {
  
  interface Binder extends UiBinder<Widget, CourseView> { }
  private static final Binder binder = GWT.create(Binder.class);

  @UiField Element courseTitle;
  @UiField Element assignments;
  
  public CourseView() {
	  initWidget(binder.createAndBindUi(this));
  }
  

  public void setCourseData(Course course) {
	  this.courseTitle.setInnerHTML(course.getName());
  }
  
  public Widget asWidget() {
    return this;
  }
}
