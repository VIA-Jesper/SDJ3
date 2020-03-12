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
    String result = ssc.findMoM(findMoMTextName.getText());

    findMoMValue.setText(result != null ? result : "Name not found");
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
