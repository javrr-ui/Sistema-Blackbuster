/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.blackbuster;

import java.util.ArrayList;

/**
 *
 * @author Javi
 */
public class Inventario {
    
    private ArrayList<Producto> inventario;
    private int contadorId;
    
    Inventario(){
        contadorId = 0;
         inventario = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto){
        contadorId += 1;
        producto.setId(contadorId);
        producto.setDisponible(true);
        inventario.add(producto);
    }
    
    
    public void eliminarProducto(String nombre){
        
    }
    public void eliminarProducto(int id){
        
    }
    
    public void consultarProducto(String nombre){
        
    }
    public void consultarProducto(int id){
        
    }
    
    public void consultarProducto(){
        inventario.forEach((producto) -> System.out.println(producto) );
    }
}
