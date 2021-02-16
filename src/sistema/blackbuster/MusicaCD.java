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
public class MusicaCD extends Producto {

    private String artista;
    private int numeroDeCanciones;
    private String genero;

    MusicaCD(String nombre, float precio, int unidades, String artista, int numeroDeCanciones, String genero) {
        super(nombre, precio, unidades);
        this.artista = artista;
        this.numeroDeCanciones = numeroDeCanciones;
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public int getNumeroDeCanciones() {
        return numeroDeCanciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setNumeroDeCanciones(int numeroDeCanciones) {
        this.numeroDeCanciones = numeroDeCanciones;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "MusicaCD{" + "Album=" + getNombre() + ", id=" + getId() + ", unidades=" + getUnidades() + ", precio=" + getPrecio() + ", Artista=" + artista + ", numeroDeCanciones=" + numeroDeCanciones + ", genero=" + genero + '}';
    }

}
