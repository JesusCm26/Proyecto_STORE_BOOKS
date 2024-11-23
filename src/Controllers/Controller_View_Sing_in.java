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

public class Controller_View_Sing_in implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_identificacion;
    @FXML
    private TextField txt_celular;
    @FXML
    private TextField txt_correo;
    @FXML
    private PasswordField txt_contrasena;
    @FXML
    private PasswordField txt_contrasenaConfirm;
    @FXML
    private Button btn_registrarse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventAction(ActionEvent event) {
    }
    
    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btn_registrarse.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Sing_in.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
