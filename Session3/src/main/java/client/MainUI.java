package client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.rmi.RemoteException;
import java.util.Optional;

public class MainUI extends Application
{

  private double xOffset = 0;
  private double yOffset = 0;


  @Override
  public void start(Stage primaryStage)
  {

    SoSmartClient ssc = null;
    try
    {
      ssc = new SoSmartClient();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Could not connect to server.");
      alert.setHeaderText("Connection problems");
      alert.setContentText("Could not connect to server. Start the server before connecting...");
      alert.showAndWait().ifPresent(rs -> {
        if (rs == ButtonType.OK) {
          System.exit(0);
        }
      });
    }

    try
    {
      FXMLLoader loader = new FXMLLoader();

      AnchorPane root = null;
      loader.setLocation(getClass().getResource("../client/mainui.fxml"));
      root = loader.load();


      root.setOnMousePressed(event -> {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
      });
      root.setOnMouseDragged(event -> {
        primaryStage.setX(event.getScreenX() - xOffset);
        primaryStage.setY(event.getScreenY() - yOffset);
      });


      MainUiController view = loader.getController();
      view.init(ssc);
      Scene scene = new Scene(root);


      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }





}
