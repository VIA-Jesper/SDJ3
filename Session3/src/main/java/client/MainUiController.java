package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class MainUiController
{

  @FXML
  public TextField findMoMTextName;
  @FXML
  public TextField findMoMValue;


  public MainUiController() {

  }


  public void findMoM() {
    findMoMValue.setText(ssc.findMoM(findMoMTextName.getText()));
  }
  private SoSmartClient ssc;
  public void init(SoSmartClient ssc)
  {

    this.ssc = ssc;
  }

  public void onQuitButtonAction(ActionEvent actionEvent)
  {
    System.exit(0);
  }
}
