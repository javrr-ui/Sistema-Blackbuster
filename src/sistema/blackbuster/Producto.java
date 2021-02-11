/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.blackbuster;

/**
 *
 * @author Javi
 */
public class Producto {
    private int unidades;
    private String nombre;
    private int id;
    private boolean disponible;
    private float precio;
    
    Producto(){
       
    }
    
    Producto(String nombre, float precio){
        this.nombre = nombre;
        this.precio = precio;
    }

   
    
    public String getNombre() {
        return nombre;
    }
    public boolean getDisponible(){
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
    

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", id=" + id + ", disponible=" + disponible + ", precio=" + precio + '}';
    }
    
    
    
    
    
}
