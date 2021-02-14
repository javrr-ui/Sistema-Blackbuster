package sistema.blackbuster;

/**
 *
 * @author Javi
 */
public class Producto {

    private String nombre;
    private float precio;
    private int unidades;
    private int id;
    private boolean disponible;

    Producto() {

    }

    Producto(String nombre, float precio, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;

    }

    public String getNombre() {
        return nombre;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public int getId() {
        return id;
    }

    public int getUnidades() {
        return unidades;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", id=" + id + ", disponible=" + disponible + ", precio=" + precio + '}';
    }

}
