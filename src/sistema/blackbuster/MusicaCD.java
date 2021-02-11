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
public class MusicaCD extends Producto{
    private int numeroDeCanciones;
    private String genero;
    
    MusicaCD(String nombre, float precio, int numeroDeCanciones, String genero){
        super(nombre,precio);
        this.numeroDeCanciones = numeroDeCanciones;
        this.genero = genero;
    }
}
