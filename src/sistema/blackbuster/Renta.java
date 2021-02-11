/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.blackbuster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Javi
 */
public class Renta {
    private LocalDate fechaRenta;
    private LocalDate fechaDevolucion;
    private int idCliente;
    private String nombreCliente;
    private ArrayList<Producto> productos = new ArrayList<>();
    private Cliente cliente;
    
    Renta(LocalDate fechaRenta, LocalDate fechaDevolucion, Cliente cliente,Producto producto){
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
        this.cliente = cliente;
        productos.add(producto);
        
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    

    public LocalDate getFechaRenta() {
        return fechaRenta;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setFechaRenta(LocalDate fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        //System.out.println(productos.toString());
        
        return "Renta{" + "fechaRenta=" + fechaRenta + ", fechaDevolucion=" + fechaDevolucion + ", idCliente=" + cliente.getId() +", Cliente="+ cliente.getNombre()+ ", productos="+ productos.toString() + '}';
    }
    

    
    
}
