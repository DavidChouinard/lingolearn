package cscie99.team2.lingolearn.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cscie99.team2.lingolearn.client.CardService;
import cscie99.team2.lingolearn.client.CourseService;
import cscie99.team2.lingolearn.server.datastore.CardDAO;
import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Course;
import cscie99.team2.lingolearn.shared.Image;
import cscie99.team2.lingolearn.shared.User;

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

}
