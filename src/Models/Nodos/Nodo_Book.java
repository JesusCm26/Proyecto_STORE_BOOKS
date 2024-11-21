package Models.Nodos;

public class Nodo_Book {
    
    private int id;
    private String titulo;
    private String autor;
    private String descripcion;
    private float precio;
    private String fechaPublicacion;
    private Nodo_Book sig, ant;

    public Nodo_Book(int id, String titulo, String autor, String descripcion, float precio, String fechaPublicacion, Nodo_Book sig, Nodo_Book ant) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.sig = sig;
        this.ant = ant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Nodo_Book getSig() {
        return sig;
    }

    public void setSig(Nodo_Book sig) {
        this.sig = sig;
    }

    public Nodo_Book getAnt() {
        return ant;
    }

    public void setAnt(Nodo_Book ant) {
        this.ant = ant;
    }
    
}
