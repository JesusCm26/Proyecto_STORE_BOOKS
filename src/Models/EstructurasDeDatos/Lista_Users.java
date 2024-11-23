package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_User;

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
        
}
