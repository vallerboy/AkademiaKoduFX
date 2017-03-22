package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

/**
 * Created by OskarPraca on 2017-03-22.
 */
public class DrawerController {

    @FXML
    public JFXButton button1;
    @FXML
    public JFXButton button2;
    @FXML
    public JFXButton button3;
    @FXML
    public JFXButton button4;

    public void clickButton1(){
       Controller.getPane().setStyle("-fx-background-color:#00FF00");
    }
    public void clickButton2(){
        Controller.getPane().setStyle("-fx-background-color:#0000FF");
    }
    public void clickButton3(){
        Controller.getPane().setStyle("-fx-background-color:#FF0000");
    }
    public void clickButton4(){
        System.exit(1);
    }

}
