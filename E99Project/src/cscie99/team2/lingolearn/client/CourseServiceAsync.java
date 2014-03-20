package cscie99.team2.lingolearn.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cscie99.team2.lingolearn.shared.Course;
import cscie99.team2.lingolearn.shared.User;

public interface CourseServiceAsync {
  public void getCoursesUserIsInstructing(User user, AsyncCallback<ArrayList<Course>> callback);
}

