package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controller_View_Login implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btn_ingresar;
    @FXML
    private Button btn_registrarse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventAction(ActionEvent event) {
        if (event.getSource() == btn_ingresar) {

        } else if (event.getSource() == btn_registrarse) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Sign_in.fxml"));
                Parent root = loader.load();

                Controller_View_Sing_in controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow();
                });
                stage.show();

                Stage miStage = (Stage) this.btn_ingresar.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
