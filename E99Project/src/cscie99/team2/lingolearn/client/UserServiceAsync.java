package cscie99.team2.lingolearn.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cscie99.team2.lingolearn.server.datastore.ObjectifyableUser;

public interface UserServiceAsync {

	public void isUserLoggedIn( AsyncCallback<Boolean> callback );
	
	public void loginUser( String gmail, AsyncCallback<Boolean> callback );
	
	public void logoutUser( ObjectifyableUser user, AsyncCallback<Boolean> callback );
	
	/* Get the user who is currently logged into this session */
	public void getCurrentUser( AsyncCallback<ObjectifyableUser> callback );
	
	/* Get the gmail address of the session user - who is not yet registered */
	public void getSessionGmail( AsyncCallback<String> callback );
	
	/* Get the gplusid address of the session user - who is not yet registered */
	public void getSessionGplusId( AsyncCallback<String> callback );
}
