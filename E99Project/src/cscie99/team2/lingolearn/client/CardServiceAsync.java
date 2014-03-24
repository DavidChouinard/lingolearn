package cscie99.team2.lingolearn.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cscie99.team2.lingolearn.shared.Card;

import java.util.ArrayList;

public interface CardServiceAsync {
  public void getCardById(String cardId, AsyncCallback<Card> callback);
	public void getCardByKanji(String kanji, AsyncCallback<Card> callback);
	public void getCardByHiragana(String hiragana, AsyncCallback<Card> callback);
	public void getCardByKatakana(String katakana, AsyncCallback<Card> callback);
	public void getCardByTranslation(String translation, AsyncCallback<Card> callback);
	public void getCardByDescription(String desc, AsyncCallback<Card> callback);
}

