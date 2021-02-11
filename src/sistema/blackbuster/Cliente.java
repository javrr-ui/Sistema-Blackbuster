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
public class Cliente {
    
    private int id;
    private String nombre;
    private int cantidadProductosRentados=0;
    private ArrayList<Producto> productos=  new ArrayList<>();
    private ArrayList<Renta> rentasCliente = new ArrayList<>();
    
    Cliente(){
        
    }
    
    Cliente(String nombre){
        this.nombre = nombre;
        
    }

    public int getId() {
        return id;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    

    public String getNombre() {
        return nombre;
    }

    public int getCantidadProductosRentados() {
        return cantidadProductosRentados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadProductosRentados(int cantidadProductosRentados) {
        this.cantidadProductosRentados = cantidadProductosRentados;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductos(Producto producto) {
        productos.add(producto);
        
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setRentasCliente(ArrayList<Renta> rentasCliente) {
        this.rentasCliente = rentasCliente;
    }

    public ArrayList<Renta> getRentasCliente() {
        return rentasCliente;
    }

    
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", cantidadProductosRentados=" + cantidadProductosRentados + '}';
    }
    
    
    
}
