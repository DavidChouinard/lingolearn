package cscie99.team2.lingolearn.client.view;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.InlineHTML;

import cscie99.team2.lingolearn.shared.Course;
import cscie99.team2.lingolearn.shared.Deck;
import cscie99.team2.lingolearn.shared.Session;

public class SessionView extends Composite {
  
  interface Binder extends UiBinder<Widget, SessionView> { }
  private static final Binder binder = GWT.create(Binder.class);

  @UiField FlowPanel sessionHeader;
  @UiField FlowPanel cardArea;
  @UiField FlowPanel controlsArea;
  @UiField Button nextButton;
  
  public SessionView() {
	  initWidget(binder.createAndBindUi(this));
	  this.showControls();
  }
  

  public void setSessionName(String name) {
	  InlineHTML title = new InlineHTML();
	  title.setText(name);
	  this.sessionHeader.add(title);
  }
  
  public HasWidgets getCardContainer() {
	  return this.cardArea;
  }
  
  public void hideControls() {
	  this.controlsArea.setVisible(false);
  }
  
  public void showControls() {
	  this.controlsArea.setVisible(true);
  }
  
  public HasClickHandlers getNextButton() {
	  return nextButton;
  }
  
  public Widget asWidget() {
      return this;
  }
}
