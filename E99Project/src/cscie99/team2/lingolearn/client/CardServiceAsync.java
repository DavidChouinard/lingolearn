package cscie99.team2.lingolearn.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cscie99.team2.lingolearn.shared.Card;

import java.util.ArrayList;

public interface CardServiceAsync {
  public void getCardById(String cardId, AsyncCallback<Card> callback);
}

