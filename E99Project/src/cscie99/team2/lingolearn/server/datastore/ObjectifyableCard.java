package cscie99.team2.lingolearn.server.datastore;

import static cscie99.team2.lingolearn.server.datastore.OfyService.ofy;

import java.io.Serializable;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Image;
import cscie99.team2.lingolearn.shared.Sound;

/**
 *
 */
@Entity(name="ObjectifyableCard")
public class ObjectifyableCard implements Serializable {

	private static final long serialVersionUID = -5054129063681784845L;
	
	@Id private Long cardId;				// Unique card Id
	@Index private String kanji;			// Kanji Unicode
	@Index private String enTranslation;	// English translation
	@Load Ref<ObjectifyableImage> image;	// Image
	@Load Ref<ObjectifyableSound> sound;	// Sound
	
	public ObjectifyableCard() {}
	
	/**
	 * This method creates Objectifyable Proxy from real object
	 * @param card		Card object
	 */
	public ObjectifyableCard(Card card) {
		this.cardId = card.getId();
		this.kanji = card.getKanji();
		this.enTranslation = card.getEnTranslation();
		// Process image
		Image img = card.getImage();
		ObjectifyableImage oimg = new ObjectifyableImage(img);
		ofy().save().entity(oimg).now();
		this.image = Ref.create(oimg);
		
		// Process sound
		Sound sound = card.getSound();
		ObjectifyableSound osound = new ObjectifyableSound(sound);
		ofy().save().entity(osound).now();
		this.sound = Ref.create(osound);
		
	}
	
	
	/**
	 * This method reconstructs real object from Objectifyable Proxy
	 * @return Card object
	 */
	public Card getCard() {
		Card c = new Card();
		c.setId(this.cardId);
		c.setKanji(this.kanji);
		c.setEnTranslation(this.enTranslation);
		c.setImage(this.image.get().getImage());
		c.setSound(this.sound.get().getSound());
		return c;
	}
	
}

