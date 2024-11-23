package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_User;
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
}
