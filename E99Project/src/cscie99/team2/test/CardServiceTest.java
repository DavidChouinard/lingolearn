package cscie99.team2.test;

import cscie99.team2.lingolearn.Card;
import cscie99.team2.lingolearn.services.CardService;

public class CardServiceTest {
	
	public static void main(String[] args) {
		
		CardService cs = new CardService();
		Card c = cs.getCardById("1");

		System.out.println(c.getKanji());
		System.out.println(c.getImage());
	}

}
