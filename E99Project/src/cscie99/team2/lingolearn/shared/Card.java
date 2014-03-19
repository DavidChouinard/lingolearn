/**
 * CSCIE99 TEAM 2
 */
package cscie99.team2.lingolearn.shared;


import java.io.Serializable;
import java.util.List;

/**
 * @author YPolyanskyy
 *
 */
public class Card implements Serializable {

	private static final long serialVersionUID = -2630264168091602483L;
	
	private Long cardId;				// Unique card Id
	private String kanji;			// Kanji Unicode
	private	String hiragana;				// Hiragana Unicode
	private	String katakana;				// Katakana Unicode
	private String enTranslation;	// English translation
	private Image image;					// Image
	private Sound sound;					// Sound
	//private List<Confuser>	confuserList;	// List of "confusers"

	public Card () {};
	
	public Card(String kanji, String enTranslation) {
		super();
		this.kanji = kanji;
		this.enTranslation = enTranslation;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getKanji() {
		return kanji;
	}

	public void setKanji(String kanji) {
		this.kanji = kanji;
	}

	public String getHiragana() {
		return hiragana;
	}

	public void setHiragana(String hiragana) {
		this.hiragana = hiragana;
	}

	public String getKatakana() {
		return katakana;
	}

	public void setKatakana(String katakana) {
		this.katakana = katakana;
	}

	public String getEnTranslation() {
		return enTranslation;
	}

	public void setEnTranslation(String enTranslation) {
		this.enTranslation = enTranslation;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	/*
	public List<Confuser> getConfuserList() {
		return confuserList;
	}

	public void setConfuserList(List<Confuser> confuserList) {
		this.confuserList = confuserList;
	}
	*/
	
}

