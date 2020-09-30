import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import javafx.geometry.Pos;

import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class PewPewApplication extends Application{

  @Override
  public void start(Stage stage) throws FileNotFoundException
  {
    VBox root = new VBox(200);
    root.setBackground(Background.EMPTY);
    root.setAlignment(Pos.TOP_CENTER);


    // create and configure welcome scene
    Scene welcomeScene = new Scene(root, 500, 500, Color.DARKOLIVEGREEN);

    stage.setScene(welcomeScene);
    stage.setTitle("PewPewJava");

    stage.show();

  }

  public static void main(String args[]){
      launch(args);
      // could call another app by using:
      // Application.launch(MyApp.class, args);
  }
}
