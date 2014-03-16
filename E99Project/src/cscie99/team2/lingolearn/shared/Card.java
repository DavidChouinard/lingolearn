/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn.shared;

import java.io.Serializable;
import java.util.List;

/**
 * @author YPolyanskyy
 * 
 * This class represents an individual card which will be a part of the flashcards.
 * A card has several optional attributes
 */
@SuppressWarnings("serial")
public class Card implements Serializable {

	private 				String cardId,	// Unique card Id
							kanji,			// Kanji Unicode
							hiragana,		// Hiragana Unicode
							katakana,		// Katakana Unicode
							enTranslation;	// English translation
	private Image  			image;			// Image
	//private Sound  			sound;			// Sound
	//private List<Confuser>	confuserList;	// List of "confusers"
	
	public Card() {
		
	}
	
	public void setId(String id) {
		this.cardId = id;
	}
	
	public void setKanji(String kanji) {
		this.kanji = kanji;
	}
	
	public String getKanji() {
		return this.kanji;
	}
	
	public void setImage(Image img) {
		this.image = img;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public void setTranslation(String translation) {
		this.enTranslation = translation;
	}
	
	public String getTranslation() {
		return this.enTranslation;
	}
}
