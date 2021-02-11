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
public class VideosDVD extends Producto{
    private String genero;
    
    VideosDVD(String nombre, float precio,int unidades,String genero){
        super(nombre,precio,unidades);
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "VideosDVD{" +"nombre="+getNombre()+", id="+getId()+", disponible="+getDisponible() +", precio="+getPrecio()+",unidades="+getUnidades() +", genero=" + genero + '}';
    }
    
    
    
}
