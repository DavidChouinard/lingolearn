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

/**
 *
 */
@Entity(name="ObjectifyableCard")
public class ObjectifyableCard implements Serializable {

	private static final long serialVersionUID = -5054129063681784845L;
	
	@Id private int cardId;				// Unique card Id
	@Index private String kanji;			// Kanji Unicode
	@Index private String enTranslation;	// English translation
	@Load Ref<ObjectifyableImage> image;					// Image
	
	public ObjectifyableCard() {}
	
	public ObjectifyableCard(Card card) {
		this.cardId = card.getId();
		this.kanji = card.getKanji();
		this.enTranslation = card.getEnTranslation();
		Image img = card.getImage();
		ObjectifyableImage oimg = new ObjectifyableImage(img);
		ofy().save().entity(oimg).now();
		this.image = Ref.create(oimg);
	}
	
	public Card getCard() {
		Card c = new Card();
		c.setId(this.cardId);
		c.setKanji(this.kanji);
		c.setEnTranslation(this.enTranslation);
		c.setImage(this.image.get().getImage());
		return c;
	}
	
}

