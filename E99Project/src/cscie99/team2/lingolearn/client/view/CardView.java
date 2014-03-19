package cscie99.team2.lingolearn.client.view;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import cscie99.team2.lingolearn.client.presenter.CardPresenter;
import cscie99.team2.lingolearn.shared.Card;

import java.util.ArrayList;
import java.util.List;

public class CardView extends Composite {
  
  private FlowPanel card;
  private FlowPanel front;
  private FlowPanel back;
  private FlowPanel kanji;
  private FlowPanel hirigana;
  private FlowPanel katakana;
  private FlowPanel englishTranslation;
  private Button flipButton;
  
  public CardView() {
	  this.card = new FlowPanel();
	  this.card.setStyleName("card");
	  initWidget(this.card);
	  
	  this.front = new FlowPanel();
	  this.front.setStyleName("frontOfCard");
	  this.card.add(this.front);
	  this.back = new FlowPanel();
	  this.front.setStyleName("backOfCard");
	  this.back.setVisible(false);
	  this.card.add(this.back);
	  
	  
	  this.kanji = new FlowPanel();
	  this.kanji.setStyleName("kanji");
	  this.front.add(this.kanji);
	  
	  this.hirigana = new FlowPanel();
	  this.hirigana.setStyleName("hirigana");
	  this.front.add(this.hirigana);
	  
	  this.englishTranslation = new FlowPanel();
	  this.englishTranslation.setStyleName("translation");
	  this.back.add(this.englishTranslation);
	  
	  this.flipButton = new Button();
	  this.flipButton.setText("Flip");
	  this.card.add(flipButton);
	  
  }
  
  public HasClickHandlers getFlipButton() {
	  return flipButton;
  }

  public void setData(Card card) {
	  this.kanji.clear();
	  this.englishTranslation.clear();
	  
	  HTML tb1 = new HTML();
	  tb1.setText(card.getKanji());
	  this.kanji.add(tb1);
	  
	  HTML tb2 = new HTML();
	  tb2.setText(card.getEnTranslation());
	  this.englishTranslation.add(tb2);
	  
  }
  
  public void flipCard() {
	  this.front.setVisible(this.front.isVisible() ? false : true);
	  this.back.setVisible(this.back.isVisible() ? false : true);
  }
  
  public Widget asWidget() {
    return this;
  }
}
