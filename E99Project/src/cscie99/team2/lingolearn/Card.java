/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn;

import java.util.List;

/**
 * @author YPolyanskyy
 * 
 * This class represents an individual card which will be a part of the flashcards.
 * A card has several optional attributes
 */
public class Card {

	private 				String cardId,	// Unique card Id
							kanji,			// Kanji Unicode
							hiragana,		// Hiragana Unicode
							katakana,		// Katakana Unicode
							enTranslation;	// English translation
	private Image  			image;			// Image
	private Sound  			sound;			// Sound
	private List<Confuser>	confuserList;	// List of "confusers"
}
