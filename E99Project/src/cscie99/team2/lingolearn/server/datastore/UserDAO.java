package cscie99.team2.lingolearn.server.datastore;

import cscie99.team2.lingolearn.shared.User;

public class UserDAO {

	private static UserDAO instance;
	
	private UserDAO(){
		
	}
	
	public static UserDAO getInstance(){
		if( instance == null )
			instance = new UserDAO();
		
		return instance;
	}
	
	public User getUserByGmail( String gmail ){
		
		User u = new User();
		u.setGmail("test@gmail.com");
		u.setGplusId("12343243134143134134");
		u.setFirstName("Mufasa");
		
		return u;
	}
}
