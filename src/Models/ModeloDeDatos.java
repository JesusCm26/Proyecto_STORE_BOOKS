package Models;

import Models.EstructurasDeDatos.Lista_Users;
import Models.EstructurasDeDatos.Pila_Books;

public class ModeloDeDatos {

    private static ModeloDeDatos instancia;
    private final Lista_Users listaU;
    private final Pila_Books pialB;

    private ModeloDeDatos() {
        this.listaU = new Lista_Users();
        this.pialB = new Pila_Books();
    }

    public static ModeloDeDatos obtenerInstancia() {

        if (instancia == null) {
            instancia = new ModeloDeDatos();
        }        
        return instancia;
    }

    public Lista_Users getListaU() {
        return listaU;
    }

    public Pila_Books getPialB() {
        return pialB;
    }
            
}
