package Models.EstructurasDeDatos;

import Models.Nodos.Nodo_Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            if (aux.getIdPropietario() == id) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Book getBook(int id, String titulo) {
        for (Nodo_Book aux : pilaC) {
            if (aux.getIdPropietario() == id && aux.getTitulo().equals(titulo)) {
                return aux;
            }
        }
        return null;
    }

    public void popBook(int id, String titulo) {
        Alert alert = new Alert(Alert.AlertType.NONE);

        Nodo_Book aux = null;
        if (!pilaC.empty()) {
            aux = getBook(id, titulo);
            if ((aux != null) && (pilaC.remove(aux))) {
                System.out.println("Libro eliminado");
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
            if (aux.getIdPropietario() == id) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public Nodo_Book getBookFav(int id, String titulo) {
        for (Nodo_Book aux : pilaFav) {
            if (aux.getIdPropietario() == id && aux.getTitulo().equals(titulo)) {
                return aux;
            }
        }
        return null;
    }

    public void popBookFav(int id, String titulo) {
        Alert alert = new Alert(Alert.AlertType.NONE);

        Nodo_Book aux = null;
        if (!pilaFav.empty()) {
            aux = getBookFav(id, titulo);
            if ((aux != null) && (pilaFav.remove(aux))) {
                System.out.println("Libro eliminado");
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

    public void guardarBooks() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Books_Carrito.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {

            for (Nodo_Book book : pilaC) {
                writer.write(book.getIdPropietario() + ", ");
                writer.write(book.getTitulo() + ", ");
                writer.write(book.getAutor() + ", ");                
                writer.write(book.getPrecio() + ", ");
                writer.write(book.getFechaPublicacion() + ", ");
                writer.write(book.getURL_IMAGE());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: Archivo_Books_Carrito.txt: " + e.getMessage());
        }
    }

    public void cargarBooks() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Books_Carrito.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaC.isEmpty()) {
                pilaC.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                int idPropietario = Integer.parseInt(atributos[0]);
                String titulo = atributos[1];
                String autor = atributos[2];
                float precio = Float.parseFloat(atributos[3]);
                String fechaPublicacion = atributos[4];
                String URL_IMAGE = atributos[5];

                Nodo_Book book = new Nodo_Book(idPropietario, titulo, autor, precio, fechaPublicacion, URL_IMAGE);

                setPush(book);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde Archivo_Books_Carrito.txt: " + e.getMessage());
        }
    }
    
    public void guardarBooks_Fav() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Books_Favoritos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {

            for (Nodo_Book book : pilaFav) {
                writer.write(book.getIdPropietario() + ", ");
                writer.write(book.getTitulo() + ", ");
                writer.write(book.getAutor() + ", ");                
                writer.write(book.getPrecio() + ", ");
                writer.write(book.getFechaPublicacion() + ", ");
                writer.write(book.getURL_IMAGE());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: Archivo_Books_Favoritos.txt: " + e.getMessage());
        }
    }
    
    public void cargarBooks_Fav() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Books_Favoritos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaFav.isEmpty()) {
                pilaFav.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                int idPropietario = Integer.parseInt(atributos[0]);
                String titulo = atributos[1];
                String autor = atributos[2];
                float precio = Float.parseFloat(atributos[3]);
                String fechaPublicacion = atributos[4];
                String URL_IMAGE = atributos[5];

                Nodo_Book book = new Nodo_Book(idPropietario, titulo, autor, precio, fechaPublicacion, URL_IMAGE);

                setPushFav(book);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde Archivo_Books_Favoritos.txt: " + e.getMessage());
        }
    }
}
