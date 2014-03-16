/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn.shared;

import java.util.List;

/**
 * @author YPolyanskyy
 * 
 * This class contains statistics regarding user's interaction with the flashcard
 */
public class UserResponse {

	private String 	respId;			// Unique response Id
	private boolean isCorrect,		// Holds status if the user's provided answer was correct
					isDropped,		// Holds status if the user dropped this card
					isChanged;		// Holds status if the user was not sure and changed answer one or more times 
	private float	timeToAnswer; 	// Time, user spent answering this question
	private String  cardShown;		// Id of the card, shown to the user
}
