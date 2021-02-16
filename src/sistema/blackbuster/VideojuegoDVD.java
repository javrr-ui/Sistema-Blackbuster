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
public class VideojuegoDVD extends Producto {

    private String plataforma;

    VideojuegoDVD(String nombre, float precio, int unidades, String plataforma) {
        super(nombre, precio, unidades);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }
    
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Videojuego{" + "nombre=" + getNombre() + ", id=" + getId() +", unidades=" + getUnidades() + ", disponible=" + getDisponible() + ", precio=" + getPrecio() + ", plataforma=" + plataforma + '}';
    }

}
