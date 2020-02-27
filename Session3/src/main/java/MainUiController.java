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
    System.out.println("Button Clicked");
    findMoMValue.setText(ssc.findMoM(findMoMTextName.getText()));
  }
  private SoSmartClient ssc;
  public void init(SoSmartClient ssc)
  {

    this.ssc = ssc;
  }
}
