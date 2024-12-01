package Controllers;

import Models.EstructurasDeDatos.Lista_Users;
import Models.EstructurasDeDatos.Pila_Books;
import Models.ModeloDeDatos;
import Models.Nodos.Nodo_Book;
import Models.Nodos.Nodo_User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller_View_Principal implements Initializable {

    private final Pila_Books pilaB = ModeloDeDatos.obtenerInstancia().getPialB();
    private final Lista_Users listaU = ModeloDeDatos.obtenerInstancia().getListaU();
    public int idUsuario;
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
    private Text txtTotal;
    @FXML
    private VBox panelFavoritos;
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
    private Label NO_HAY_CAR;
    @FXML
    private Label NO_HAY_FAV;
    @FXML
    private HBox C_JuegodeTronos;
    @FXML
    private HBox C_Divergente;
    @FXML
    private HBox C_Hamlet;
    @FXML
    private HBox C_Principito;
    @FXML
    private HBox F_JuegodeTronos;
    @FXML
    private HBox F_Divergente;
    @FXML
    private HBox F_Hamlet;
    @FXML
    private HBox F_Principito;
    @FXML
    private AnchorPane panelCatalogo;
    @FXML
    private BorderPane panelDeDetalles;
    @FXML
    private Button btnComprarGN;
    @FXML
    private Button btnAgregarCGN;
    @FXML
    private Button btnAgregarFGN;
    @FXML
    private Text txtPrecioGN;
    @FXML
    private ImageView imagenGN;
    @FXML
    private Text txtTituloGN;
    @FXML
    private Text txtContextGN;
    @FXML
    private Text txtAutorGN;
    @FXML
    private Text txtPublicadoGN;
    @FXML
    private ImageView btnAtras;

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

        btnAtras.setOnMouseClicked((MouseEvent event) -> {
            panelCatalogo.setVisible(true);
            panelDeDetalles.setVisible(false);
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
                mostrarBooksC();
            } else {
                NO_HAY_CAR.setVisible(false);
                NO_HAY_FAV.setVisible(false);
            }
        } else if (event.getSource() == btn_favoritos) {
            panelFavoritos.setVisible(!panelFavoritos.isVisible());
            if (panelFavoritos.isVisible()) {
                panelCarrito.setVisible(false);
                paneOpcionesUser.setVisible(false);
                mostrarBooksF();
            } else {
                NO_HAY_CAR.setVisible(false);
                NO_HAY_FAV.setVisible(false);
            }

        } else if (event.getSource() == btnDetalles1) {
            Image ima = new Image(getClass().getResourceAsStream("/Images/LIBRO1.jpg"));
            panelCatalogo.setVisible(!panelCatalogo.isVisible());
            panelDeDetalles.setVisible(true);
            if (!panelCatalogo.isVisible()) {
                txtTituloGN.setText("Juego de Tronos");
                imagenGN.setImage(ima);
                imagenGN.setUserData("/Images/LIBRO1.jpg");
                txtPrecioGN.setText("70,000 COP");
                txtContextGN.setText("Juego de Tronos es la primera entrega de la serie"
                        + "\nCanción de Hielo y Fuego escrita por George R. R. Martin"
                        + "\nLa historia se desarrolla en los Siete Reinos de Poniente donde "
                        + "\ndiferentes casas nobles gobiernan las regiones."
                        + "\n\nTras un largo verano el invierno se acerca a los Siete Reinos."
                        + "\nLord Eddard Stark señor de Invernalia deja sus dominios para"
                        + "\nunirse a la corte de su amigo el rey Robert Baratheon llamado el Usurpador.");
                txtAutorGN.setText("George Martin");
                txtPublicadoGN.setText("08/1996");
            }
        } else if (event.getSource() == btnDetalles2) {
            Image ima = new Image(getClass().getResourceAsStream("/Images/LIBRO2.jpg"));
            panelCatalogo.setVisible(!panelCatalogo.isVisible());
            panelDeDetalles.setVisible(true);
            if (!panelCatalogo.isVisible()) {
                txtTituloGN.setText("Divergente");
                imagenGN.setImage(ima);
                imagenGN.setUserData("/Images/LIBRO2.jpg");
                txtPrecioGN.setText("95,000 COP");
                txtContextGN.setText("Divergente es una novela distópica escrita por Veronica Roth12345."
                        + "\nLa historia se desarrolla en un Chicago post-apocalíptico"
                        + "\ndonde la sociedad está dividida en cinco facciones: Verdad"
                        + "\nAbnegación Osadía Cordialidad y Erudición1. La protagonista Beatrice Prior "
                        + "\ndebe elegir a qué facción pertenecer pero su identidad misma socava la estricta"
                        + "\nestructura social de su sociedad.");
                txtAutorGN.setText("Veronica Roth");
                txtPublicadoGN.setText("04/2011");
            }
        } else if (event.getSource() == btnDetalles3) {
            Image ima = new Image(getClass().getResourceAsStream("/Images/LIBRO4.jpg"));
            panelCatalogo.setVisible(!panelCatalogo.isVisible());
            panelDeDetalles.setVisible(true);
            if (!panelCatalogo.isVisible()) {
                txtTituloGN.setText("Hamlet");
                imagenGN.setImage(ima);
                imagenGN.setUserData("/Images/LIBRO4.jpg");
                txtPrecioGN.setText("50,000 COP");
                txtContextGN.setText("La tragedia de Hamlet, príncipe de Dinamarca (título original en inglés: The Tragical History of Hamlet,"
                        + "\nPrince of Denmark), o simplemente Hamlet, es una tragedia del dramaturgo "
                        + "\ninglés William Shakespeare.1​ Su autor probablemente basó Hamlet en dos "
                        + "\nfuentes: la leyenda de Amleth y una perdida obra isabelina conocida hoy como "
                        + "\nUr-Hamlet o Hamlet original (hecho que se deduce de otros textos)."
                        + "\n\n"
                        + "\nEl año concreto en que fue escrita sigue aún en disputa, cuestión que se complica porque "
                        + "\nse han conservado a la época actual tres versiones tempranas de la obra,"
                        + "\nconocidas como First Quarto (Q1), Second Quarto (Q2) y el First Folio (F1); "
                        + "\ncada cual única, puesto que poseen líneas —e incluso escenas— diferentes o ausentes entre ellas."
                        + "\nDichas obras posiblemente fueron compuestas en algún momento entre 1599 y 1601.");
                txtAutorGN.setText("William Shakespeare");
                txtPublicadoGN.setText("1623");
            }
        } else if (event.getSource() == btnDetalles4) {
            Image ima = new Image(getClass().getResourceAsStream("/Images/LIBRO3.jpg"));
            panelCatalogo.setVisible(!panelCatalogo.isVisible());
            panelDeDetalles.setVisible(true);
            if (!panelCatalogo.isVisible()) {
                txtTituloGN.setText("El Principito");
                imagenGN.setImage(ima);
                imagenGN.setUserData("/Images/LIBRO3.jpg");
                txtPrecioGN.setText("80,000 COP");
                txtContextGN.setText("El principito es un cuento poético que viene acompañado de ilustraciones"
                        + "\n hechas con acuarelas por el mismo Saint-Exupéry. En él, un piloto "
                        + "\nse encuentra perdido en el desierto del Sahara después de que su avión"
                        + "\nsufriera una avería, pero para su sorpresa, es allí donde conoce a un pequeño"
                        + "\npríncipe proveniente de otro planeta. La historia tiene una temática filosófica, "
                        + "\ndonde se incluyen críticas sociales dirigidas a la «extrañeza» con la que los "
                        + "\nadultos ven las cosas. Estas críticas a las cosas «importantes» y al mundo de los "
                        + "\nadultos van apareciendo en el libro a lo largo de la narración.");
                txtAutorGN.setText("Antonie de Saint - Exupery");
                txtPublicadoGN.setText("04/1943");
            }
        } else if (event.getSource() == btnAgregarCGN) {
            Nodo_Book book = null;

            switch (imagenGN.getUserData().toString()) {
                case "/Images/LIBRO1.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Juego de Tronos", "George Martin",
                            "Juego de Tronos es la primera entrega de la serie"
                            + "\nCanción de Hielo y Fuego escrita por George R. R. Martin"
                            + "\nLa historia se desarrolla en los Siete Reinos de Poniente donde "
                            + "\ndiferentes casas nobles gobiernan las regiones."
                            + "\n\nTras un largo verano el invierno se acerca a los Siete Reinos."
                            + "\nLord Eddard Stark señor de Invernalia deja sus dominios para"
                            + "\nunirse a la corte de su amigo el rey Robert Baratheon llamado el Usurpador.",
                            70000, "08/1996", "/Images/LIBRO1.jpg");

                    if (pilaB.getPilaC().isEmpty()) {
                        pilaB.setPush(book);
                        pilaB.guardarBooks();
                        book = pilaB.getBookFav(idUsuario, "Juego de Tronos");
                        if (book != null) {
                            pilaB.popBookFav(idUsuario, "Juego de Tronos");
                            pilaB.guardarBooks_Fav();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                    } else {
                        if (pilaB.getPilaC().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al carrito de compras"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPush(book);
                            pilaB.guardarBooks();
                            book = pilaB.getBookFav(idUsuario, "Juego de Tronos");
                            if (book != null) {
                                pilaB.popBookFav(idUsuario, "Juego de Tronos");
                                pilaB.guardarBooks_Fav();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                        }
                    }
                    break;
                case "/Images/LIBRO2.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Divergente", "Veronica Roth",
                            "Divergente es una novela distópica escrita por Veronica Roth12345."
                            + "\nLa historia se desarrolla en un Chicago post-apocalíptico"
                            + "\ndonde la sociedad está dividida en cinco facciones: Verdad"
                            + "\nAbnegación Osadía Cordialidad y Erudición1. La protagonista Beatrice Prior "
                            + "\ndebe elegir a qué facción pertenecer pero su identidad misma socava la estricta"
                            + "\nestructura social de su sociedad.",
                            95000, "04/2011", "/Images/LIBRO2.jpg");

                    if (pilaB.getPilaC().isEmpty()) {
                        pilaB.setPush(book);
                        pilaB.guardarBooks();
                        book = pilaB.getBookFav(idUsuario, "Divergente");
                        if (book != null) {
                            pilaB.popBookFav(idUsuario, "Divergente");
                            pilaB.guardarBooks_Fav();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                    } else {
                        if (pilaB.getPilaC().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al carrito de compras"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPush(book);
                            pilaB.guardarBooks();
                            book = pilaB.getBookFav(idUsuario, "Divergente");
                            if (book != null) {
                                pilaB.popBookFav(idUsuario, "Divergente");
                                pilaB.guardarBooks_Fav();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                        }
                    }
                    break;
                case "/Images/LIBRO3.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Principito", "Antonie de Saint - Exupery",
                            "El principito es un cuento poético que viene acompañado de ilustraciones"
                            + "\n hechas con acuarelas por el mismo Saint-Exupéry. En él, un piloto "
                            + "\nse encuentra perdido en el desierto del Sahara después de que su avión"
                            + "\nsufriera una avería, pero para su sorpresa, es allí donde conoce a un pequeño"
                            + "\npríncipe proveniente de otro planeta. La historia tiene una temática filosófica, "
                            + "\ndonde se incluyen críticas sociales dirigidas a la «extrañeza» con la que los "
                            + "\nadultos ven las cosas. Estas críticas a las cosas «importantes» y al mundo de los "
                            + "\nadultos van apareciendo en el libro a lo largo de la narración.",
                            80000, "04/2011", "/Images/LIBRO3.jpg");

                    if (pilaB.getPilaC().isEmpty()) {
                        pilaB.setPush(book);
                        pilaB.guardarBooks();
                        book = pilaB.getBookFav(idUsuario, "Principito");
                        if (book != null) {
                            pilaB.popBookFav(idUsuario, "Principito");
                            pilaB.guardarBooks_Fav();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                    } else {
                        if (pilaB.getPilaC().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al carrito de compras"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPush(book);
                            pilaB.guardarBooks();
                            book = pilaB.getBookFav(idUsuario, "Principito");
                            if (book != null) {
                                pilaB.popBookFav(idUsuario, "Principito");
                                pilaB.guardarBooks_Fav();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                        }
                    }
                    break;
                case "/Images/LIBRO4.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Hamlet", "William Shakespeare",
                            "La tragedia de Hamlet, príncipe de Dinamarca (título original en inglés: The Tragical History of Hamlet,"
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

                    if (pilaB.getPilaC().isEmpty()) {
                        pilaB.setPush(book);
                        pilaB.guardarBooks();
                        book = pilaB.getBookFav(idUsuario, "Hamlet");
                        if (book != null) {
                            pilaB.popBookFav(idUsuario, "Hamlet");
                            pilaB.guardarBooks_Fav();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                    } else {
                        if (pilaB.getPilaC().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al carrito de compras"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPush(book);
                            pilaB.guardarBooks();
                            book = pilaB.getBookFav(idUsuario, "Hamlet");
                            if (book != null) {
                                pilaB.popBookFav(idUsuario, "Hamlet");
                                pilaB.guardarBooks_Fav();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al carrito de compras...!");
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } else if (event.getSource() == btnAgregarFGN) {
            Nodo_Book book = null;

            switch (imagenGN.getUserData().toString()) {
                case "/Images/LIBRO1.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Juego de Tronos", "George Martin",
                            "Juego de Tronos es la primera entrega de la serie"
                            + "\nCanción de Hielo y Fuego escrita por George R. R. Martin"
                            + "\nLa historia se desarrolla en los Siete Reinos de Poniente donde "
                            + "\ndiferentes casas nobles gobiernan las regiones."
                            + "\n\nTras un largo verano el invierno se acerca a los Siete Reinos."
                            + "\nLord Eddard Stark señor de Invernalia deja sus dominios para"
                            + "\nunirse a la corte de su amigo el rey Robert Baratheon llamado el Usurpador.",
                            70000, "08/1996", "/Images/LIBRO1.jpg");

                    if (pilaB.getPilaFav().isEmpty()) {
                        pilaB.setPushFav(book);
                        pilaB.guardarBooks_Fav();
                        book = pilaB.getBook(idUsuario, "Juego de Tronos");
                        if (book != null) {
                            pilaB.popBook(idUsuario, "Juego de Tronos");
                            pilaB.guardarBooks();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                    } else {
                        if (pilaB.getPilaFav().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al panel de favoritos"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPushFav(book);
                            pilaB.guardarBooks_Fav();
                            book = pilaB.getBook(idUsuario, "Juego de Tronos");
                            if (book != null) {
                                pilaB.popBook(idUsuario, "Juego de Tronos");
                                pilaB.guardarBooks();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                        }
                    }
                    break;
                case "/Images/LIBRO2.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Divergente", "Veronica Roth",
                            "Divergente es una novela distópica escrita por Veronica Roth12345."
                            + "\nLa historia se desarrolla en un Chicago post-apocalíptico"
                            + "\ndonde la sociedad está dividida en cinco facciones: Verdad"
                            + "\nAbnegación Osadía Cordialidad y Erudición1. La protagonista Beatrice Prior "
                            + "\ndebe elegir a qué facción pertenecer pero su identidad misma socava la estricta"
                            + "\nestructura social de su sociedad.",
                            95000, "04/2011", "/Images/LIBRO2.jpg");

                    if (pilaB.getPilaFav().isEmpty()) {
                        pilaB.setPushFav(book);
                        pilaB.guardarBooks_Fav();
                        book = pilaB.getBook(idUsuario, "Divergente");
                        if (book != null) {
                            pilaB.popBook(idUsuario, "Divergente");
                            pilaB.guardarBooks();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                    } else {
                        if (pilaB.getPilaFav().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al panel de favoritos"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPushFav(book);
                            pilaB.guardarBooks_Fav();
                            book = pilaB.getBook(idUsuario, "Divergente");
                            if (book != null) {
                                pilaB.popBook(idUsuario, "Divergente");
                                pilaB.guardarBooks();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                        }
                    }
                    break;
                case "/Images/LIBRO3.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Principito", "Antonie de Saint - Exupery",
                            "El principito es un cuento poético que viene acompañado de ilustraciones"
                            + "\n hechas con acuarelas por el mismo Saint-Exupéry. En él, un piloto "
                            + "\nse encuentra perdido en el desierto del Sahara después de que su avión"
                            + "\nsufriera una avería, pero para su sorpresa, es allí donde conoce a un pequeño"
                            + "\npríncipe proveniente de otro planeta. La historia tiene una temática filosófica, "
                            + "\ndonde se incluyen críticas sociales dirigidas a la «extrañeza» con la que los "
                            + "\nadultos ven las cosas. Estas críticas a las cosas «importantes» y al mundo de los "
                            + "\nadultos van apareciendo en el libro a lo largo de la narración.",
                            80000, "04/2011", "/Images/LIBRO3.jpg");

                    if (pilaB.getPilaFav().isEmpty()) {
                        pilaB.setPushFav(book);
                        pilaB.guardarBooks_Fav();
                        book = pilaB.getBook(idUsuario, "Principito");
                        if (book != null) {
                            pilaB.popBook(idUsuario, "Principito");
                            pilaB.guardarBooks();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                    } else {
                        if (pilaB.getPilaFav().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al panel de favoritos"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPushFav(book);
                            pilaB.guardarBooks_Fav();
                            book = pilaB.getBook(idUsuario, "Principito");
                            if (book != null) {
                                pilaB.popBook(idUsuario, "Principito");
                                pilaB.guardarBooks();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                        }
                    }
                    break;
                case "/Images/LIBRO4.jpg":

                    book = new Nodo_Book(
                            idUsuario, "Hamlet", "William Shakespeare",
                            "La tragedia de Hamlet, príncipe de Dinamarca (título original en inglés: The Tragical History of Hamlet,"
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

                    if (pilaB.getPilaFav().isEmpty()) {
                        pilaB.setPushFav(book);
                        pilaB.guardarBooks_Fav();
                        book = pilaB.getBook(idUsuario, "Hamlet");
                        if (book != null) {
                            pilaB.popBook(idUsuario, "Hamlet");
                            pilaB.guardarBooks();
                        }
                        Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                    } else {
                        if (pilaB.getPilaFav().indexOf(book) != -1) {
                            Alert(Alert.AlertType.WARNING, "INFO:", "Este libro ya ha sido agregado al panel de favoritos"
                                    + "\nNo se pudo agrear.");
                        } else {
                            pilaB.setPushFav(book);
                            pilaB.guardarBooks_Fav();
                            book = pilaB.getBook(idUsuario, "Hamlet");
                            if (book != null) {
                                pilaB.popBook(idUsuario, "Hamlet");
                                pilaB.guardarBooks();
                            }
                            Alert(Alert.AlertType.INFORMATION, "INFO:", "Libro agregado de forma exitosa al panel de favoritos...!");
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
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
        Stack<Nodo_Book> pila = pilaB.getBooks(idUsuario);

        if (event.getSource() == p1) {

            Nodo_Book book = new Nodo_Book(idUsuario, "Juego de Tronos", "George Martin",
                    70000, "08/1996", "/Images/LIBRO1.jpg");

            if (pila.isEmpty()) {
                pilaB.setPush(book);
                pilaB.guardarBooks();
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                containerBooksF.getChildren().remove(F_JuegodeTronos);
                pilaB.popBookFav(idUsuario, "Juego de Tronos");
                pilaB.guardarBooks_Fav();
                pilaB.cargarBooks_Fav();
            } else {
                if (pilaB.getPilaC().indexOf(book) != -1) {
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                } else {
                    pilaB.setPush(book);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(F_JuegodeTronos);
                    pilaB.popBookFav(idUsuario, "Juego de Tronos");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                }
            }
        } else if (event.getSource() == p2) {
            Nodo_Book book2 = new Nodo_Book(
                    idUsuario, "Divergente", "Veronica Roth",
                    95000, "04/2011", "/Images/LIBRO2.jpg");
            if (pila.isEmpty()) {
                pilaB.setPush(book2);
                pilaB.guardarBooks();
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                containerBooksF.getChildren().remove(F_Divergente);
                pilaB.popBookFav(idUsuario, "Divergente");
                pilaB.guardarBooks_Fav();
                pilaB.cargarBooks_Fav();
            } else {
                if (pilaB.getPilaC().indexOf(book2) != -1) {
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                } else {
                    pilaB.setPush(book2);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(F_Divergente);
                    pilaB.popBookFav(idUsuario, "Divergente");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                }
            }
        } else if (event.getSource() == p3) {
            Nodo_Book book3 = new Nodo_Book(
                    idUsuario, "Hamlet", "William Shakespeare",
                    50000, "1623", "/Images/LIBRO4.jpg");
            if (pila.isEmpty()) {
                pilaB.setPush(book3);
                pilaB.guardarBooks();
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                containerBooksF.getChildren().remove(F_Hamlet);
                pilaB.popBookFav(idUsuario, "Hamlet");
                pilaB.guardarBooks_Fav();
                pilaB.cargarBooks_Fav();
            } else {
                if (pilaB.getPilaC().indexOf(book3) != -1) {
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                } else {
                    pilaB.setPush(book3);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(F_Hamlet);
                    pilaB.popBookFav(idUsuario, "Hamlet");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                }
            }
        } else if (event.getSource() == p4) {
            Nodo_Book book4 = new Nodo_Book(
                    idUsuario, "Principito", "Antonie de Saint - Exupery",
                    80000, "04/2011", "/Images/LIBRO3.jpg");
            if (pila.isEmpty()) {
                pilaB.setPush(book4);
                pilaB.guardarBooks();
                Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                containerBooksF.getChildren().remove(F_Principito);
                pilaB.popBookFav(idUsuario, "Principito");
                pilaB.guardarBooks_Fav();
                pilaB.cargarBooks_Fav();
            } else {
                if (pilaB.getPilaC().indexOf(book4) != -1) {
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "El Libro ya ha sido agregado al carrito..!");
                } else {
                    pilaB.setPush(book4);
                    pilaB.guardarBooks();
                    Alert(Alert.AlertType.INFORMATION, "Aviso", "Libro agregado exitosamente al carrito..!");
                    containerBooksF.getChildren().remove(F_Principito);
                    pilaB.popBookFav(idUsuario, "Principito");
                    pilaB.guardarBooks_Fav();
                    pilaB.cargarBooks_Fav();
                }
            }
        }
    }

    @FXML
    private void eliminarDeCarrito(MouseEvent event) {

        if (event.getSource() == e1) {
            containerBooksC.getChildren().remove(C_JuegodeTronos);
            pilaB.popBook(idUsuario, "Juego de Tronos");
            pilaB.guardarBooks();
            pilaB.cargarBooks();
        } else if (event.getSource() == e2) {
            containerBooksC.getChildren().remove(C_Divergente);
            pilaB.popBook(idUsuario, "Divergente");
            pilaB.guardarBooks();
            pilaB.cargarBooks();
        } else if (event.getSource() == e3) {
            containerBooksC.getChildren().remove(C_Hamlet);
            pilaB.popBook(idUsuario, "Hamlet");
            pilaB.guardarBooks();
            pilaB.cargarBooks();
        } else if (event.getSource() == e4) {
            containerBooksC.getChildren().remove(C_Principito);
            pilaB.popBook(idUsuario, "Principito");
            pilaB.guardarBooks();
            pilaB.cargarBooks();
        }
    }

    private void mostrarBooksC() {
        try {
            containerBooksC.getChildren().clear();
            containerBooksC.getChildren().addAll(elementosCarrito);

            Stack<Nodo_Book> books = pilaB.getBooks(idUsuario);

            if (books == null) {

                containerBooksC.getChildren().clear();
                NO_HAY_CAR.setVisible(true);
                NO_HAY_FAV.setVisible(false);
                return;
            }

            List<HBox> librosAgregar = new ArrayList<>();

            if (!containerBooksC.getChildren().isEmpty()) {
                Stack<Nodo_Book> pila = pilaB.getBooks(idUsuario);

                for (Nodo_Book bookAux : pila) {
                    for (Node node : containerBooksC.getChildren()) {
                        HBox newHbox = (HBox) node;
                        String titulo = bookAux.getTitulo().replaceAll("\\s", "");
                        if (newHbox.getId().equals("C_" + titulo)) {
                            librosAgregar.add(newHbox);
                        }
                    }
                }

                if (librosAgregar.isEmpty()) {
                    containerBooksC.getChildren().clear();
                    NO_HAY_CAR.setVisible(true);
                    NO_HAY_FAV.setVisible(false);
                } else {
                    containerBooksC.getChildren().clear();
                    containerBooksC.getChildren().addAll(librosAgregar);
                    NO_HAY_CAR.setVisible(false);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }

    private void mostrarBooksF() {
        try {
            containerBooksF.getChildren().clear();
            containerBooksF.getChildren().addAll(elementosFavoritos);

            Stack<Nodo_Book> books = pilaB.getBooksFav(idUsuario);

            if (books == null) {

                containerBooksF.getChildren().clear();
                NO_HAY_FAV.setVisible(true);
                NO_HAY_CAR.setVisible(false);
                return;
            }

            List<HBox> librosAgregar = new ArrayList<>();

            if (!containerBooksF.getChildren().isEmpty()) {
                Stack<Nodo_Book> pila = pilaB.getBooksFav(idUsuario);

                for (Nodo_Book bookAux : pila) {
                    for (Node node : containerBooksF.getChildren()) {
                        HBox newHbox = (HBox) node;
                        String titulo = bookAux.getTitulo().replaceAll("\\s", "");
                        if (newHbox.getId().equals("F_" + titulo)) {
                            librosAgregar.add(newHbox);
                        }
                    }
                }

                if (librosAgregar.isEmpty()) {
                    containerBooksF.getChildren().clear();
                    NO_HAY_FAV.setVisible(true);
                    NO_HAY_CAR.setVisible(false);
                } else {
                    containerBooksF.getChildren().clear();
                    containerBooksF.getChildren().addAll(librosAgregar);
                    NO_HAY_FAV.setVisible(false);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }
}
