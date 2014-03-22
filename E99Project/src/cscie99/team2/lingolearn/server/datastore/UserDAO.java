package cscie99.team2.lingolearn.server.datastore;


public class UserDAO {

	private static UserDAO instance;
	
	private UserDAO(){
		
	}
	
	public static UserDAO getInstance(){
		if( instance == null )
			instance = new UserDAO();
		
		return instance;
	}
	
	public ObjectifyableUser getUserByGmail( String gmail ){
		
		ObjectifyableUser u = new ObjectifyableUser();
		u.gmail = "test@gmail.com";
		u.gplusId = "12343243134143134134";
		
		return u;
	}
}
