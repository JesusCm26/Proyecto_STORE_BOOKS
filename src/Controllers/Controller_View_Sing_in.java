package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
}
