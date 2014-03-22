package cscie99.team2.lingolearn.client.presenter;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

import cscie99.team2.lingolearn.client.CardServiceAsync;
import cscie99.team2.lingolearn.client.view.CardView;
import cscie99.team2.lingolearn.shared.Card;

public class CardPresenter implements Presenter {  

  private final CardServiceAsync cardService;
  private final HandlerManager eventBus;
  private final CardView display;
  
  public CardPresenter(CardServiceAsync cardService, HandlerManager eventBus, CardView display) {
    this.cardService = cardService;
    this.eventBus = eventBus;
    this.display = display;
  }
  
  public void bind() {
    
	display.getFlipButton().addClickHandler(new ClickHandler() {   
      public void onClick(ClickEvent event) {
        //eventBus.fireEvent(new ViewCardEvent());
    	display.flipCard();
      }
    });
    
  }
  
  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
    setCardData();
  }
  
  private void setCardData() {
	  cardService.getCardById("1", new AsyncCallback<Card>() {
	      public void onSuccess(Card card) {
	          display.setData(card);
	      }
	      
	      public void onFailure(Throwable caught) {
	        Window.alert("Error fetching contact details");
	      }
	    });
  }

}
