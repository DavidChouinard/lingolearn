/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn;

/**
 * @author YPolyanskyy
 *
 */
@SuppressWarnings("serial")
public class CardNotFoundException extends Exception {

	/**
	 * Default no argument constructor
	 * @param msg Message to display when the exception gets thrown
	 */
	CardNotFoundException () {
		super ("Card retrieval problem has occured.");
	}
	
	
}
