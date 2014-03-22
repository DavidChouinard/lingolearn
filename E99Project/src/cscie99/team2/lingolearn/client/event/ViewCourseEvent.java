package cscie99.team2.lingolearn.client.event;


import com.google.gwt.event.shared.GwtEvent;

import cscie99.team2.lingolearn.shared.Course;

public class ViewCourseEvent extends GwtEvent<ViewCourseEventHandler> {
  public static Type<ViewCourseEventHandler> TYPE = new Type<ViewCourseEventHandler>();
  
  private Course course;
  
  public ViewCourseEvent(Course course) {
	  this.course = course;
  }
  
  public Course getCourse() {
	  return this.course;
  }
  
  @Override
  public Type<ViewCourseEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ViewCourseEventHandler handler) {
    handler.onViewCourse(this);
  }
}
