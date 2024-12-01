package Controllers;

import Models.EstructurasDeDatos.Lista_Users;
import Models.EstructurasDeDatos.Pila_Books;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_User;
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
import javafx.stage.WindowEvent;

public class Controller_View_Login implements Initializable {

    private final Lista_Users listaU = ModeloDeDatos.obtenerInstancia().getListaU();
    private final Pila_Books pilaB = ModeloDeDatos.obtenerInstancia().getPialB();

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
        listaU.cargarUsuariosDesdeArchivo_TXT();
        pilaB.cargarBooks();
        pilaB.cargarBooks_Fav();
    }

    @FXML
    private void eventAction(ActionEvent event) {
        if (event.getSource() == btn_ingresar) {

            iniciarSesion();

        } else if (event.getSource() == btn_registrarse) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Sing_in.fxml"));
                Parent root = loader.load();

                Controller_View_Sing_in controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow();
                });

                Stage miStage = (Stage) this.btn_ingresar.getScene().getWindow();
                stage.setMaximized(miStage.isMaximized());
                stage.setX(miStage.getX());
                stage.setY(miStage.getY());
                stage.setWidth(miStage.getWidth());
                stage.setHeight(miStage.getHeight());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.show();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Alert(Alert.AlertType alertType, String tit, String mj) {
        Alert a = new Alert(alertType);
        a.setTitle(tit);
        a.setContentText(mj);
        a.showAndWait();
    }

    public void iniciarSesion() {

        if (txtUser.getText().isEmpty() && txtPass.getText().isEmpty()) {

            Alert(Alert.AlertType.WARNING, "Advertencia", "No se puede verificar\nLos campos están vacios");

        } else if (txtUser.getText().isEmpty()) {

            Alert(Alert.AlertType.WARNING, "Advertencia", "No se puede verificar\nDebe ingresar un correo o usuario");

        } else if (txtPass.getText().isEmpty()) {

            Alert(Alert.AlertType.WARNING, "Adevertencia", "No se puede verificar\nDebe ingresar una contraseña");

        } else {

            Nodo_User buscar = listaU.buscarEmail(txtUser.getText());

            if (buscar != null && buscar.getContrasena().equals(txtPass.getText())) {
                Alert(Alert.AlertType.CONFIRMATION, "Información", buscar.getNombre() + " BIENVENIDO..!");

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Principal.fxml"));
                    Parent root = loader.load();

                    Controller_View_Principal controller = loader.getController();
                    controller.txt_user.setText(buscar.getCorreo());
                    controller.idUsuario = buscar.getIdentificacion();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent value) -> {
                        controller.closeWindow();
                    });

                    Stage miStage = (Stage) this.btn_ingresar.getScene().getWindow();
                    stage.setMaximized(miStage.isMaximized());
                    stage.setX(miStage.getX());
                    stage.setY(miStage.getY());
                    stage.setWidth(miStage.getWidth());
                    stage.setHeight(miStage.getHeight());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    stage.show();
                    miStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Controller_View_Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtUser.setText("");
                txtPass.setText("");

            } else {
                Alert(Alert.AlertType.ERROR, "Alerta", "Contraseña incorrecta");
                txtPass.setText("");
                txtPass.requestFocus();
            }

            if (buscar == null) {
                Alert(Alert.AlertType.ERROR, "Alerta", "El Correo \nno está registrado o es erroneo, por favor verifique");
                txtUser.setText("");
                txtPass.setText("");
                txtUser.requestFocus();
            }
        }

    }
}
