package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Book;
import java.util.Stack;
import javafx.scene.control.Alert;

public class Pila_Books {
    
    private final Stack<Nodo_Book> pilaC;
    private final Stack<Nodo_Book> pilaFav;

    public Pila_Books() {
        this.pilaC = new Stack<>();
        this.pilaFav = new Stack<>();
    }

    public Stack<Nodo_Book> getPilaC() {
        return pilaC;
    }

    public Stack<Nodo_Book> getPilaFav() {
        return pilaFav;
    }
 
    //Metodos PilaC o pila para elementos del carrito
    public void setPush(Nodo_Book b) {
        int pos = pilaC.indexOf(b);
        if (pos == -1) {
            pilaC.push(b);
        } else {
            System.out.println("Ya se encuentra registrado este libro");
        }
    }

    public Stack<Nodo_Book> getBooks(int id) {
        Stack<Nodo_Book> pila = new Stack<>();
        for (Nodo_Book aux : pilaC) {
            if (aux.getIdPropietario()== id) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Book getBook(int id) {
        for (Nodo_Book aux : pilaC) {
            if (aux.getIdPropietario() == id) {
                return aux;
            }
        }
        return null;
    }

    public void popBook(int id) {
        Alert alert = new Alert(Alert.AlertType.NONE);

        Nodo_Book aux = null;
        if (!pilaC.empty()) {
            aux = getBook(id);
            if ((aux != null) && (pilaC.remove(aux))) {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso.");
                alert.setContentText("Libro elimindo.");
                alert.showAndWait();
            } else {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso.");
                alert.setContentText("El libro no existe.");
                alert.showAndWait();
            }
        } else {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Aviso.");
            alert.setContentText("No hay libros registradas");
            alert.showAndWait();
        }
    }

    public Stack<Nodo_Book> getClonarC() {
        Stack<Nodo_Book> caux = new Stack<>();
        int i;
        Nodo_Book aux = null;
        if (this.pilaC == null) {
            return null;
        } else {
            for (i = 0; i < pilaC.size(); i++) {
                aux = pilaC.get(i);
                caux.add(i, aux);
            }
            return caux;
        }
    }
    
    public void setPushFav(Nodo_Book b) {
        int pos = pilaFav.indexOf(b);
        if (pos == -1) {
            pilaFav.push(b);
        } else {
            System.out.println("Ya se encuentra registrado este libro");
        }
    }

    public Stack<Nodo_Book> getBooksFav(int id) {
        Stack<Nodo_Book> pila = new Stack<>();
        for (Nodo_Book aux : pilaFav) {
            if (aux.getIdPropietario()== id) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Book getBookFav(int id) {
        for (Nodo_Book aux : pilaFav) {
            if (aux.getIdPropietario() == id) {
                return aux;
            }
        }
        return null;
    }

    public void popBookFav(int id) {
        Alert alert = new Alert(Alert.AlertType.NONE);

        Nodo_Book aux = null;
        if (!pilaFav.empty()) {
            aux = getBook(id);
            if ((aux != null) && (pilaFav.remove(aux))) {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso.");
                alert.setContentText("Libro elimindo.");
                alert.showAndWait();
            } else {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso.");
                alert.setContentText("La camiseta no existe.");
                alert.showAndWait();
            }
        } else {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Aviso.");
            alert.setContentText("No hay camisetas registradas");
            alert.showAndWait();
        }
    }

    public Stack<Nodo_Book> getClonarFav() {
        Stack<Nodo_Book> caux = new Stack<>();
        int i;
        Nodo_Book aux = null;
        if (this.pilaFav == null) {
            return null;
        } else {
            for (i = 0; i < pilaFav.size(); i++) {
                aux = pilaFav.get(i);
                caux.add(i, aux);
            }
            return caux;
        }
    }
    
    public void eliminar(Stack<Nodo_Book> pila, int id) {
        Stack<Nodo_Book> temp = new Stack<>();

        while (!pila.isEmpty()) {
            Nodo_Book juego = pila.pop();
            if (juego.getIdPropietario() == id) {
                temp.push(juego);
            }
        }
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }
    
}
