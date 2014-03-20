/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn.shared;

import java.io.Serializable;
import java.util.List;

/**
 * @author YPolyanskyy
 * 
 *	This abstract class represents users of the system. It defines common elements of all users.
 *	Required for implementation of Student, Instructor and Researcher.
 *
 */
public class User implements Serializable {
	
	private String	uId = null;		// Unique system wide user Id
    private String   		uPass,			// Hashed password
           					uFirstName,		// First name
           				 	uLastName,		// Last name
           				 	uEmail;			// Email address
	private int 		uYOB = 0;		// Year of birth. Will be used to calculate user's age
	private int 			uYearsTeachExp;	// Years of language teaching experience 
	private Gender 			uGender;		// Gender
	private List<Role> 	 	uRole;			// List of Roles that assigned to this user. Default: RESEARCHER
	private List<Language> 	uLangSpoken;	// List of languages the user can speak. Native language should be listed first.
	private List<Session>	uSessionRec;	// 
	
	
	/**
	 * This method performs user login
	 * 
	 * @param uId		unique user Id
	 * @param uPass		hashed user password
	 * @return			true if login attempt was successful
	 */
	public boolean login (String uId, String uPass) {
		boolean loginResult = false;
		
		return loginResult;
	}
	
	/**
	 * This method performs user logout
	 * 
	 * @param uId		unique user Id
	 * @param uPass		hashed user password
	 * @return			true if login attempt was successful
	 */
	public boolean logout (String uId, String uPass) {
		boolean logoutResult = false;
		
		return logoutResult;
	}
	
	/**
	 * This method allows users to upload files in the Anki flashcard format. After the file is uploaded,
	 * it will parse the file and allow user to matches uploaded data to data model of the system's flash cards
	 * 
	 * @param filename	File in Anki format to be imported
	 */
	public void loadAnkiFile(String filename) {
		
	}
	
	/**
	 * This method allows users to upload files in the plain CSV format. After the file is uploaded,
	 * it will parse the file and allow user to matches uploaded data to data model of the system's flash cards
	 * 
	 * @param filename	File in the CSV format (with headers) to be imported
	 */
	public void loadFlatFile(String filename) {
		
	}
}
