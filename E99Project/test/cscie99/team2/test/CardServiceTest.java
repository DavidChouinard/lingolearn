package cscie99.team2.test;

import cscie99.team2.lingolearn.server.CardServiceImpl;
import cscie99.team2.lingolearn.shared.Card;

public class CardServiceTest {
	
	public static void main(String[] args) {
		
		CardServiceImpl cs = new CardServiceImpl();
		Card c = cs.getCardById("1");

		System.out.println(c.getKanji());
		System.out.println(c.getImage());
	}

}
