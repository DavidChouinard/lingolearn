package cscie99.team2.lingolearn.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cscie99.team2.lingolearn.server.datastore.ObjectifyableUser;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	

	public Boolean isUserLoggedIn();

	public Boolean loginUser( String gmail );
	
	public Boolean logoutUser( ObjectifyableUser user );
	
	/* Get the user who is currently logged into this session */
	public ObjectifyableUser getCurrentUser();
	
	/* Get the gmail address of the session user - who is not yet registered */
	public String getSessionGmail();
	
	/* Get the gplusid address of the session user - who is not yet registered */
	public String getSessionGplusId();
	
	
}
