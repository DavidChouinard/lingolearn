package cscie99.team2.lingolearn.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cscie99.team2.lingolearn.client.CourseService;
import cscie99.team2.lingolearn.shared.Course;

@SuppressWarnings("serial")
public class CourseServiceImpl extends RemoteServiceServlet implements CourseService {
	
	public ArrayList<Course> getCoursesUserIsInstructing(User user) {
		ArrayList<Course> list = new ArrayList<Course>();
		Course c;
		
		
		//Temporarily prepopulate
		c = new Course();
		c.setName("Best course eva!");
		list.add(c);
		
		return list;
		
	}

	@Override
	public ArrayList<Course> getCoursesUserIsInstructing(
			cscie99.team2.lingolearn.client.User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
