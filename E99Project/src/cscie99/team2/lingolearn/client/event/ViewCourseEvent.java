package cscie99.team2.lingolearn.client.event;


import com.google.gwt.event.shared.GwtEvent;

public class ViewCourseEvent extends GwtEvent<ViewCourseEventHandler> {
  public static Type<ViewCourseEventHandler> TYPE = new Type<ViewCourseEventHandler>();
  
  @Override
  public Type<ViewCourseEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ViewCourseEventHandler handler) {
    handler.onViewCourse(this);
  }
}
