package Controllers;

import Models.EstructurasDeDatos.Pila_Books;
import Models.ModeloDeDatos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_View_Principal implements Initializable {

    private Pila_Books pilaB = ModeloDeDatos.obtenerInstancia().getPialB();
    
    private ObservableList<HBox> elementosCarrito;
    private ObservableList<HBox> elementosFavoritos;
    
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
    @FXML
    private HBox bookCar1;
    @FXML
    private HBox bookCar2;
    @FXML
    private HBox bookCar3;
    @FXML
    private HBox bookCar4;
    @FXML
    private Text txtTotal;
    @FXML
    private VBox panelFavoritos;
    @FXML
    private HBox bookFav1;
    @FXML
    private HBox bookFav2;
    @FXML
    private HBox bookFav3;
    @FXML
    private HBox bookFav4;
    @FXML
    private ImageView e1;
    @FXML
    private ImageView e2;
    @FXML
    private ImageView e3;
    @FXML
    private ImageView e4;
    @FXML
    private ImageView p1;
    @FXML
    private ImageView p2;
    @FXML
    private ImageView p3;
    @FXML
    private ImageView p4;
    @FXML
    private FlowPane containerBooksC;
    @FXML
    private FlowPane containerBooksF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tooltip tooltip = new Tooltip("Eliminar libro");
        Tooltip tooltip2 = new Tooltip("Pasar al carrito");
        Tooltip.install(e1, tooltip);
        Tooltip.install(e2, tooltip);
        Tooltip.install(e3, tooltip);
        Tooltip.install(e4, tooltip);
        Tooltip.install(p1, tooltip2);
        Tooltip.install(p2, tooltip2);
        Tooltip.install(p3, tooltip2);
        Tooltip.install(p4, tooltip2);
        
        elementosCarrito = FXCollections.observableArrayList();
        elementosFavoritos = FXCollections.observableArrayList();
        
        containerBooksC.getChildren().stream().map(node -> (HBox) node).forEachOrdered(newPane -> {
            elementosCarrito.add(newPane);
        });
        
        containerBooksF.getChildren().stream().map(node -> (HBox) node).forEachOrdered(newPane -> {
            elementosFavoritos.add(newPane);
        });
    }

    @FXML
    private void eventAction(ActionEvent event) {

        if (event.getSource() == btn_userOptions) {
            paneOpcionesUser.setVisible(!paneOpcionesUser.isVisible());
            if (paneOpcionesUser.isVisible()) {
                panelCarrito.setVisible(false);
                panelFavoritos.setVisible(false);
            }
        } else if (event.getSource() == btn_cerrarSesión) {
            closeWindow();
        } else if (event.getSource() == btn_carrito) {
            panelCarrito.setVisible(!panelCarrito.isVisible());
            if (panelCarrito.isVisible()) {
                panelFavoritos.setVisible(false);
                paneOpcionesUser.setVisible(false);
            }
        } else if (event.getSource() == btn_favoritos) {
            panelFavoritos.setVisible(!panelFavoritos.isVisible());
            if (panelFavoritos.isVisible()) {
                panelCarrito.setVisible(false);
                paneOpcionesUser.setVisible(false);
            }

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

    @FXML
    private void pasarAlCarrtio(MouseEvent event) {
    }
}
