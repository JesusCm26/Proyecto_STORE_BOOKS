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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_View_Principal implements Initializable {

    @FXML
    private Button btn_favoritos;
    @FXML
    private Button btn_userOptions;
    @FXML
    private Button btn_carrito;
    @FXML
    public Text txt_user;
    @FXML
    private Pane paneOpcionesUser;
    @FXML
    private Button btn_cerrarSesión;
    @FXML
    private VBox panelCarrito;
    @FXML
    private Button btnComprarC;
    @FXML
    private Button btnDetalles1;
    @FXML
    private Button btnDetalles2;
    @FXML
    private Button btnDetalles3;
    @FXML
    private Button btnDetalles4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void eventAction(ActionEvent event) {

        if (event.getSource() == btn_userOptions) {
            paneOpcionesUser.setVisible(!paneOpcionesUser.isVisible());
        } else if (event.getSource() == btn_cerrarSesión) {
            closeWindow();
        } else if (event.getSource() == btn_carrito) {
            panelCarrito.setVisible(!panelCarrito.isVisible());
        } else if (event.getSource() == btn_favoritos) {
        }
    }

    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/View_Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);

            Stage miStage = (Stage) this.btn_carrito.getScene().getWindow();
            stage.setMaximized(miStage.isMaximized());
            stage.setX(miStage.getX());
            stage.setY(miStage.getY());
            stage.setWidth(miStage.getWidth());
            stage.setHeight(miStage.getHeight());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller_View_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage.show();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_View_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
