import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class MainUI extends Application
{
  @Override
  public void start(Stage primaryStage) {

    SoSmartClient ssc = null;
    try
    {
      ssc = new SoSmartClient();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }

    try {

      FXMLLoader loader = new FXMLLoader();

      AnchorPane root = null;
      loader.setLocation(getClass().getResource("mainui.fxml"));
      root = loader.load();
      MainUiController view = loader.getController();
      view.init(ssc);
      Scene scene = new Scene(root,600,300);

      primaryStage.setScene(scene);
      primaryStage.show();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }





}
