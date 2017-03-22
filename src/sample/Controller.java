package sample;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    public ImageView imageLogo;

    @FXML
    public JFXDrawer fxDrawer;

    @FXML
    public  AnchorPane anchorPane;

    @FXML
    public JFXHamburger buttonStart;

    private static AnchorPane anchorPaneStatic;

    public void buttonStartClicked(MouseEvent event) {
      // if(event.isControlDown()){
           if(fxDrawer.isShown()) {
              fxDrawer.close();
           }else{
               fxDrawer.open();
           }

     // }
    }

    public static AnchorPane getPane() {
       return  anchorPaneStatic;
   }

    private  void openWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("AkedmiaKodu");
        alert.setHeaderText("Wybierz jedną z opcji");

        ButtonType buttonOne = new ButtonType("Pierwszy przycisk");
        ButtonType buttonTwo = new ButtonType("Drugi przycisk");
        ButtonType buttonThree = new ButtonType("Trzeci przycisk");
        ButtonType buttonCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonOne, buttonTwo, buttonThree, buttonCancel);


        Optional<ButtonType> optional = alert.showAndWait();
        if(optional.get() == buttonCancel) {
            alert.close();
            System.out.println("Ktos zamknal okno bez wyboru");
        }
    }

    public void openWindowWithText() {
        TextInputDialog dialog = new TextInputDialog("Wpisz imie");
        dialog.setTitle("Podaj nam swoje imie");
        dialog.setContentText("Wpisz imię: ");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> System.out.println("Twoje imie to" + name));

    }



    private void runAnimation() {
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(5), imageLogo);
        fadeInTransition.setFromValue(0.0f);
        fadeInTransition.setToValue(1.0f);

        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(5), imageLogo);
        fadeOutTransition.setFromValue(1f);
        fadeOutTransition.setToValue(0f);

        fadeInTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fadeOutTransition.play();
            }
        });
        fadeInTransition.play();




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        anchorPaneStatic = anchorPane;

        try {
            VBox box = FXMLLoader.load(getClass().getResource("drawerContent.fxml"));
            fxDrawer.setSidePane(box);
        } catch (IOException e) {
            e.printStackTrace();
        }

       HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(buttonStart);
        transition.setRate(-1);
        buttonStart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                transition.setRate(transition.getRate() * -1);
                transition.play();

                if(fxDrawer.isShown()) {
                    fxDrawer.close();
                }else{
                    fxDrawer.open();
                }
            }
        });

    }
}
