package Models.Nodos;

public class Nodo_Book {

    private int idPropietario;
    private String titulo;
    private String autor;
    private String descripcion;
    private float precio;
    private String fechaPublicacion;
    private String URL_IMAGE;

    public Nodo_Book(int idPropietario, String titulo, String autor, String descripcion, float precio, String fechaPublicacion, String URL_IMAGE) {
        this.idPropietario = idPropietario;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.URL_IMAGE = URL_IMAGE;
    }

    public Nodo_Book(int idPropietario, String titulo, String autor, float precio, String fechaPublicacion, String URL_IMAGE) {
        this.idPropietario = idPropietario;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = "";
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.URL_IMAGE = URL_IMAGE;
    }
    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
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

    public String getURL_IMAGE() {
        return URL_IMAGE;
    }

    public void setURL_IMAGE(String URL_IMAGE) {
        this.URL_IMAGE = URL_IMAGE;
    }

}
