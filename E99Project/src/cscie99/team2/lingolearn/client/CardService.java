package cscie99.team2.lingolearn.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cscie99.team2.lingolearn.shared.Card;

import java.util.ArrayList;

@RemoteServiceRelativePath("cardService")
public interface CardService extends RemoteService {
	public Card getCardById(String cardId);
}
