package Models.Nodos;

public class Nodo_User {
    
    private String nombre;
    private int identificacion;
    private String num_celular;
    private String correo;
    private String contrasena;
    private Nodo_User sig, ant;

    public Nodo_User(String nombre, int identificacion, String num_celular, String correo, String contrasena) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.num_celular = num_celular;
        this.correo = correo;
        this.contrasena = contrasena;
        this.sig = null;
        this.ant = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNum_celular() {
        return num_celular;
    }

    public void setNum_celular(String num_celular) {
        this.num_celular = num_celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Nodo_User getSig() {
        return sig;
    }

    public void setSig(Nodo_User sig) {
        this.sig = sig;
    }

    public Nodo_User getAnt() {
        return ant;
    }

    public void setAnt(Nodo_User ant) {
        this.ant = ant;
    }
       
}
