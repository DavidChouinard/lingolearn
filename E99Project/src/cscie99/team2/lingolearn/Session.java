/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn;

import java.util.Date;

/**
 * @author YPolyanskyy
 * 
 * This abstract class represents Session of the system. It defines common elements of all sessions.
 * Required for implementation of Lesson, Quiz, Test.
 */
public abstract class Session {

	private String sessId;		// Session Id
	private Date   sessStart,	// Timestamp of the session's start
				   sessEnd;		// Timestamp of the session's end
	
	private Deck   deck;		// Deck associated with this session
	private Course courseId;	// Course Id that this session belongs to
	
	/**
	 * This method interacts with DeckMng to obtain the deck for this session
	 * 
	 * @return	Deck of the cards for this session
	 */
	public Deck getDeck() {
		
		return null;
	}
}
