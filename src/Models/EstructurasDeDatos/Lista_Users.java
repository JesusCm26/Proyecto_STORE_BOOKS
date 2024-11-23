package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    public Nodo_User getUltimo() {

        if (getCab() == null) {
            return null;
        } else {
            Nodo_User u = getCab();
            while (u.getSig() != null) {
                u = u.getSig();
            }
            return u;
        }
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

    public Nodo_User crearUsuario(TextField txtNombre, TextField txtIdentificacion, TextField txtCell, TextField txtGmail, PasswordField txtPassword) {

        Nodo_User buscar = buscarEmail(txtGmail.getText());
        Nodo_User buscar2 = buscarIdentificacion(Integer.parseInt(txtIdentificacion.getText()));
        try {

            if (buscar != null) {
                Alert(Alert.AlertType.WARNING, "Importante..!",
                        "Ya existe un usuario con este Correo");
                txtGmail.setText("");
                txtGmail.requestFocus();
                return null;
            } else if (buscar2 != null) {
                Alert(Alert.AlertType.WARNING, "Importante..!",
                        "Ya existe un usuario con esta identificación");
                txtIdentificacion.setText("");
                txtIdentificacion.requestFocus();
                return null;
            } else {
                Nodo_User nuevoU = new Nodo_User(txtNombre.getText(), Integer.parseInt(txtIdentificacion.getText()), txtCell.getText(), txtGmail.getText(), txtPassword.getText());
                Alert(Alert.AlertType.CONFIRMATION, "Dialogo de confirmación.",
                        "Registro realizado con exito...!\n"
                        + "Felicidades...! ya haces parte de nuestros usuarios.");
                txtNombre.setText("");
                txtIdentificacion.setText("");
                txtCell.setText("");
                txtGmail.setText("");
                txtPassword.setText("");
                return nuevoU;
            }

        } catch (NumberFormatException e) {
            Logger.getLogger(Lista_Users.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

    public void agregarUsuario(TextField txtNombre, TextField txtIdentificacion, TextField txtCell, TextField txtGmail, PasswordField txtPassword) {

        Nodo_User us = crearUsuario(txtNombre, txtIdentificacion, txtCell, txtGmail, txtPassword);

        if (us != null) {
            if (getCab() == null) {
                setCab(us);
                nUsers++;
            } else {
                us.setSig(getCab());
                getCab().setAnt(us);
                setCab(us);
                nUsers++;
            }
        }
    }

    public void almacenarUsuariosEnArchivo_TXT(Lista_Users listaU) {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Usuarios.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Nodo_User nodoActual = listaU.getCab();

            while (nodoActual != null) {
                writer.write(nodoActual.getNombre() + ", ");
                writer.write(nodoActual.getIdentificacion() + ", ");
                writer.write(nodoActual.getNum_celular() + ", ");
                writer.write(nodoActual.getCorreo() + ", ");
                writer.write(nodoActual.getContrasena());

                writer.newLine();

                nodoActual = nodoActual.getSig();
            }

            System.out.println("Datos guardados correctamente en el archivo de usuarios.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de usuarios: " + e.getMessage());
        }
    }
    
    private void caragarUsuario(String nombre, String identificacion, String celular, String correo, String contrasena) {
        
        Nodo_User user = new Nodo_User(nombre, Integer.parseInt(identificacion), celular, correo, contrasena);
        
        if (getCab() == null) {
            setCab(user);
            nUsers++;
        } else {
            Nodo_User ultimo = getUltimo();
            
            ultimo.setSig(user);
            user.setAnt(ultimo);
            nUsers++;
        }
    }

    public void cargarUsuariosDesdeArchivo_TXT() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Usuarios.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            vaciarLista();

            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String nombre = atributos[0];
                String identificacion = atributos[1];
                String celular = atributos[2];
                String correo = atributos[3];
                String contrasena = atributos[4];

                caragarUsuario(nombre, identificacion, celular, correo, contrasena);
            }

            System.out.println("Datos cargados correctamente desde archivo de usuasio.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de usuarios: " + e.getMessage());
        }
    }
}
