package Controllers;

import Models.EstructurasDeDatos.Lista_Users;
import Models.ModeloDeDatos;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_View_Sing_in implements Initializable {

    private Lista_Users listaU = ModeloDeDatos.obtenerInstancia().getListaU();

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
        agregarUsuarios(txt_nombre, txt_identificacion, txt_celular, txt_correo, txt_contrasena, txt_contrasenaConfirm);
    }

    public void closeWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);

            Stage miStage = (Stage) this.btn_registrarse.getScene().getWindow();
            stage.setMaximized(miStage.isMaximized());
            stage.setX(miStage.getX());
            stage.setY(miStage.getY());
            stage.setWidth(miStage.getWidth());
            stage.setHeight(miStage.getHeight());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller_View_Sing_in.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage.show();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Sing_in.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarUsuarios(TextField txtNombre, TextField txtIdentificacion, TextField txtCell, TextField txtGmail, PasswordField txtPassword, PasswordField txtPassword_2) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Informacion:");
        a.setTitle("Dialogo de advertencia");

        if (!"".equals(txtNombre.getText())) {

            if (!"".equals(txtIdentificacion.getText())) {

                if (!"".equals(txtCell.getText())) {

                    if (!"".equals(txtGmail.getText())) {

                        if (!"".equals(txtPassword.getText())) {

                            if (txtPassword.getText().equals(txtPassword_2.getText())) {

                                listaU.agregarUsuario(txtNombre, txtIdentificacion, txtCell, txtGmail, txtPassword);
                                listaU.almacenarUsuariosEnArchivo_TXT(listaU);

                                if (listaU.getnUsers() != 0) {
                                    txtPassword_2.setText("");
                                    closeWindow();
                                }

                            } else {
                                a.setContentText("Verifique su contraseña");
                                a.showAndWait();
                            }

                        } else {

                            a.setContentText("Es necesario que se escriba una contraseña");
                            a.showAndWait();
                        }

                    } else {

                        a.setContentText("Es necesario que se escriba un correo");
                        a.showAndWait();
                    }
                } else {

                    a.setContentText("Es necesario que se escriba un"
                            + "\nnumero de numero de telefono");
                    a.showAndWait();
                }

            } else {

                a.setContentText("Es necesario que se escriba un numero de identificacion");
                a.showAndWait();
            }
        } else {

            a.setContentText("Es necesario que se escriba un nombre");
            a.showAndWait();
        }
    }
}
