package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.Optional;


public class Controller {

    @FXML
    public ImageView imageLogo;

    public void buttonStartClicked(MouseEvent event) {
       if(event.isControlDown()){
           openWindow();
      }
    }

    private  void openWindow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("AkedmiaKodu ostrzega..");
        alert.setHeaderText("Ostrzegamy..");
        alert.setContentText("Dziś będzie padać.");

        Optional<ButtonType> optional = alert.showAndWait();
        if(optional.get() == ButtonType.OK) {
          System.out.println("Kliknięto ok");
        }
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
}
