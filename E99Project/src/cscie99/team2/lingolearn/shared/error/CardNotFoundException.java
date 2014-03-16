/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn.shared.error;

/**
 * This exception should be thrown when a card cannot be found.
 */
@SuppressWarnings("serial")
public class CardNotFoundException extends Exception {
	/**
	 * Constructor, note the exception reason.
	 */
	public CardNotFoundException(String message) {
		super(message);
	}
}
