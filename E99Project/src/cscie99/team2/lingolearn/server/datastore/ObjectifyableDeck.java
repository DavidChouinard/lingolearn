package cscie99.team2.lingolearn.server.datastore;

import static cscie99.team2.lingolearn.server.datastore.OfyService.ofy;

import java.io.Serializable;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

import cscie99.team2.lingolearn.shared.Card;
import cscie99.team2.lingolearn.shared.Deck;
import cscie99.team2.lingolearn.shared.Image;
import cscie99.team2.lingolearn.shared.Sound;

/**
 *
 */
@Entity(name="ObjectifyableDeck")
public class ObjectifyableDeck implements Serializable {

	private static final long serialVersionUID = -5054129063681784845L;
	
	public ObjectifyableDeck() {}
	
	/**
	 * This method creates Objectifyable Proxy from real object
	 * @param deck		Deck object
	 */
	public ObjectifyableDeck(Deck deck) {
		//TODO
		
	}
	
	
	/**
	 * This method reconstructs real object from Objectifyable Proxy
	 * @return Deck object
	 */
	public Deck getDeck() {
		//TODO
		return null;
	}
	
}

