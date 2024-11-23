package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class Lista_Users {

    private Nodo_User cab;
    private int nUsers;

    public Lista_Users() {
        this.cab = null;
        this.nUsers = 0;
    }

    public Nodo_User getCab() {
        return cab;
    }

    public void setCab(Nodo_User cab) {
        this.cab = cab;
    }

    public int getnUsers() {
        return nUsers;
    }

    public void setnUsers(int nUsers) {
        this.nUsers = nUsers;
    }

    public void vaciarLista() {
        cab = null;
    }

    public void Alert(Alert.AlertType alertType, String tit, String mj) {
        Alert a = new Alert(alertType);
        a.setTitle(tit);
        a.setContentText(mj);
        a.showAndWait();
    }

    public Nodo_User buscarEmail(String gmail) {
        if (getCab() == null) {
            return null;
        } else {
            Nodo_User aux = getCab();
            while (aux != null) {
                if (aux.getCorreo().equalsIgnoreCase(gmail)) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }

    public Nodo_User buscarIdentificacion(int identificacion) {
        if (getCab() == null) {
            return null;
        } else {
            Nodo_User aux = getCab();
            while (aux != null) {
                if (aux.getIdentificacion() == identificacion) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }

    public ObservableList<Nodo_User> getUsuarios() {
        ObservableList<Nodo_User> todos = FXCollections.observableArrayList();

        if (getCab() == null) {
            return todos;
        }

        Nodo_User actual = getCab();

        do {

            todos.add(actual);
            actual = actual.getSig();

        } while (actual != null && actual != getCab());

        return todos;
    }
}
