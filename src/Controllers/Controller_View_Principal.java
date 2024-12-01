package Controllers;

import Models.EstructurasDeDatos.Lista_Users;
import Models.EstructurasDeDatos.Pila_Books;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Book;
import Models.Nodos.Nodo_User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_View_Principal implements Initializable {

    private final Pila_Books pilaB = ModeloDeDatos.obtenerInstancia().getPialB();
    private final Lista_Users listaU = ModeloDeDatos.obtenerInstancia().getListaU();

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
    @FXML
    private FlowPane containerCat;
    @FXML
    private Pane B_Juegos;
    @FXML
    private Pane B_Divergente;
    @FXML
    private Pane B_Hamlet;
    @FXML
    private Pane B_Principito;
    @FXML
    private AnchorPane catalogo;

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

    public void Alert(Alert.AlertType alertType, String tit, String mj) {
        Alert a = new Alert(alertType);
        a.setTitle(tit);
        a.setContentText(mj);
        a.showAndWait();
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
        Nodo_User user = listaU.buscarEmail(txt_user.getText());
        Stack<Nodo_Book> pila = pilaB.getBooks(user.getIdentificacion());
        ImageView ima = (ImageView) event.getSource();

        switch (ima.getParent().getId()) {
            case "p1":

                Nodo_Book book = new Nodo_Book(
                        user.getIdentificacion(), "Juego de Tronos", "George Martin",
                        "Juego de Tronos es la primera entrega de la serie"
                        + "\nCanción de Hielo y Fuego escrita por George R. R. Martin"
                        + "\nLa historia se desarrolla en los Siete Reinos de Poniente donde "
                        + "\ndiferentes casas nobles gobiernan las regiones."
                        + "\n\nTras un largo verano el invierno se acerca a los Siete Reinos."
                        + "\nLord Eddard Stark señor de Invernalia deja sus dominios para"
                        + "\nunirse a la corte de su amigo el rey Robert Baratheon llamado el Usurpador.",
                        70000, "08/1996", "/Images/LIBRO1.jpg");

                if (pila.isEmpty()) {
                    pilaB.setPush(book);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(p1);
                    pilaB.popBookFav(user.getIdentificacion(), "Juego de Tronos");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                } else {
                    if (pilaB.getPilaC().indexOf(book) != -1) {
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                    } else {
                        pilaB.setPush(book);
                        pilaB.guardarBooks();
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                        containerBooksF.getChildren().remove(p1);
                        pilaB.popBookFav(user.getIdentificacion(), "Juego de Tronos");
                        pilaB.guardarBooks_Fav();
                        pilaB.cargarBooks_Fav();
                    }
                }
                break;
            case "p2":

                Nodo_Book book2 = new Nodo_Book(
                        user.getIdentificacion(), "Divergente", "Veronica Roth",
                        "Juego de Tronos es la primera entrega de la serie"
                        + "\nCanción de Hielo y Fuego escrita por George R. R. Martin"
                        + "\nLa historia se desarrolla en los Siete Reinos de Poniente donde "
                        + "\ndiferentes casas nobles gobiernan las regiones."
                        + "\n\nTras un largo verano el invierno se acerca a los Siete Reinos."
                        + "\nLord Eddard Stark señor de Invernalia deja sus dominios para"
                        + "\nunirse a la corte de su amigo el rey Robert Baratheon llamado el Usurpador.",
                        95000, "04/2011", "/Images/LIBRO2.jpg");
                if (pila.isEmpty()) {
                    pilaB.setPush(book2);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(p2);
                    pilaB.popBookFav(user.getIdentificacion(), "Divergente");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                } else {
                    if (pilaB.getPilaC().indexOf(book2) != -1) {
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                    } else {
                        pilaB.setPush(book2);
                        pilaB.guardarBooks();
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                        containerBooksF.getChildren().remove(p2);
                        pilaB.popBookFav(user.getIdentificacion(), "Divergente");
                        pilaB.guardarBooks_Fav();
                        pilaB.cargarBooks_Fav();
                    }
                }
                break;
            case "p3":

                Nodo_Book book3 = new Nodo_Book(
                        user.getIdentificacion(), "Hamlet", "William Shakespeare",
                        "\nLa tragedia de Hamlet, príncipe de Dinamarca (título original en inglés: The Tragical History of Hamlet,"
                        + "\nPrince of Denmark), o simplemente Hamlet, es una tragedia del dramaturgo "
                        + "\ninglés William Shakespeare.1​ Su autor probablemente basó Hamlet en dos "
                        + "\nfuentes: la leyenda de Amleth y una perdida obra isabelina conocida hoy como "
                        + "\nUr-Hamlet o Hamlet original (hecho que se deduce de otros textos)."
                        + "\n\n"
                        + "\nEl año concreto en que fue escrita sigue aún en disputa, cuestión que se complica porque "
                        + "\nse han conservado a la época actual tres versiones tempranas de la obra,"
                        + "\nconocidas como First Quarto (Q1), Second Quarto (Q2) y el First Folio (F1); "
                        + "\ncada cual única, puesto que poseen líneas —e incluso escenas— diferentes o ausentes entre ellas. Dichas obras posiblemente fueron compuestas en algún momento entre 1599 y 1601.",
                        50000, "1623", "/Images/LIBRO4.jpg");
                if (pila.isEmpty()) {
                    pilaB.setPush(book3);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(p3);
                    pilaB.popBookFav(user.getIdentificacion(), "Hamlet");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                } else {
                    if (pilaB.getPilaC().indexOf(book3) != -1) {
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                    } else {
                        pilaB.setPush(book3);
                        pilaB.guardarBooks();
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                        containerBooksF.getChildren().remove(p3);
                        pilaB.popBookFav(user.getIdentificacion(), "Hamlet");
                        pilaB.guardarBooks_Fav();
                        pilaB.cargarBooks_Fav();
                    }
                }
                break;
            case "p4":

                Nodo_Book book4 = new Nodo_Book(
                        user.getIdentificacion(), "Principito", "Antonie de Saint - Exupery",
                        "El principito es un cuento poético que viene acompañado de ilustraciones"
                        + "\n hechas con acuarelas por el mismo Saint-Exupéry. En él, un piloto "
                        + "\nse encuentra perdido en el desierto del Sahara después de que su avión"
                        + "\nsufriera una avería, pero para su sorpresa, es allí donde conoce a un pequeño"
                        + "\npríncipe proveniente de otro planeta. La historia tiene una temática filosófica, "
                        + "\ndonde se incluyen críticas sociales dirigidas a la «extrañeza» con la que los "
                        + "\nadultos ven las cosas. Estas críticas a las cosas «importantes» y al mundo de los "
                        + "\nadultos van apareciendo en el libro a lo largo de la narración.",
                        80000, "04/2011", "/Images/LIBRO3.jpg");
                if (pila.isEmpty()) {
                    pilaB.setPush(book4);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(p4);
                    pilaB.popBookFav(user.getIdentificacion(), "Principito");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                } else {
                    if (pilaB.getPilaC().indexOf(book4) != -1) {
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                    } else {
                        pilaB.setPush(book4);
                        pilaB.guardarBooks();
                        Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                        containerBooksF.getChildren().remove(p4);
                        pilaB.popBookFav(user.getIdentificacion(), "Principito");
                        pilaB.guardarBooks_Fav();
                        pilaB.cargarBooks_Fav();
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void eliminarDeCarrito(MouseEvent event) {
        Nodo_User user = listaU.buscarEmail(txt_user.getText());
        Stack<Nodo_Book> pila = pilaB.getBooks(user.getIdentificacion());
        ImageView ima = (ImageView) event.getSource();

        switch (ima.getParent().getId()) {
            case "e1":
                containerBooksC.getChildren().remove(e1);
                pilaB.popBook(user.getIdentificacion(), "Juego de Tronos");
                pilaB.guardarBooks();
                pilaB.cargarBooks();
                break;
            case "e2":
                containerBooksC.getChildren().remove(e2);
                pilaB.popBook(user.getIdentificacion(), "Divergente");
                pilaB.guardarBooks();
                pilaB.cargarBooks();
                break;
            case "e3":
                containerBooksC.getChildren().remove(e3);
                pilaB.popBook(user.getIdentificacion(), "Hamlet");
                pilaB.guardarBooks();
                pilaB.cargarBooks();
                break;
            case "e4":
                containerBooksC.getChildren().remove(e4);
                pilaB.popBook(user.getIdentificacion(), "Principito");
                pilaB.guardarBooks();
                pilaB.cargarBooks();
                break;
            default:
                throw new AssertionError();
        }
    }
}
