/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn;

import java.util.HashMap;

/**
 * @author YPolyanskyy
 *
 * The purpose of this class is to improve the performance of the system while retrieving
 * the cards from the datastore. 
 * This class maintains a list of cards, currently active in the system and
 * allows the cards to be reused by different decks. If the card is not
 * used by any deck after a predefined period of time, it will be removed from the cache. 
 *
 */
public class DeckMng {

	private final static int 	  CACHE_INACTIVITY_TIME = 5;	// Time (in minutes) after which a card
																// will be removed from the active cache
	private HashMap<String, Card> cardMap;						// HashMap of the card objects in the active cache
}
