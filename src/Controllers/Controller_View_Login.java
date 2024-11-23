package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
}
