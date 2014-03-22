package cscie99.team2.lingolearn.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cscie99.team2.lingolearn.client.User;
import cscie99.team2.lingolearn.shared.Course;

public interface CourseServiceAsync {
  public void getCoursesUserIsInstructing(User user, AsyncCallback<ArrayList<Course>> callback);
}

