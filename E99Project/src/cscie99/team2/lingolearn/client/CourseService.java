package cscie99.team2.lingolearn.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cscie99.team2.lingolearn.shared.Course;
import cscie99.team2.lingolearn.shared.User;

@RemoteServiceRelativePath("courseService")
public interface CourseService extends RemoteService {
	public ArrayList<Course> getCoursesUserIsInstructing(User user);
}