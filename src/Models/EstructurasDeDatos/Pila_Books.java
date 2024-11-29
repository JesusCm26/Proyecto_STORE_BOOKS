package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Book;
import java.util.Stack;

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
 
    
    
}
