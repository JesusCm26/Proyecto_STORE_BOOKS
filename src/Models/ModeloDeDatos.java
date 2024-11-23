package Models;

import Models.EstructurasDeDatos.Lista_Users;

public class ModeloDeDatos {

    private static ModeloDeDatos instancia;
    private final Lista_Users listaU;

    private ModeloDeDatos() {
        this.listaU = new Lista_Users();
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
        
}
