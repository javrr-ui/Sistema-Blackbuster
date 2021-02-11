/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.blackbuster;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Javi
 */
public class SistemaBlackbuster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Producto juego1 = new VideojuegoDVD("Crash Bandicoot",399.99f,"XBOX");
//       if(juego1 instanceof MusicaCD){
//           System.out.println("el tipo de producto es videojuego");
//       }else{
//           System.out.print("NO es de tipo videojuego");
//       }
          Inventario inventario = new Inventario();
          SistemaRentas sisRentas = new SistemaRentas();
          DBCliente dbClientes = new DBCliente();
          
          dbClientes.agregarCliente(new Cliente("Francisco"));
          dbClientes.agregarCliente(new Cliente("Armando"));
          dbClientes.agregarCliente(new Cliente("Sara"));
          dbClientes.mostrarClientes();
          
          
          
          //sisRentas.nuevaRenta(new Renta(LocalDate.now(), LocalDate.of(2021,2,21), cliente,new MusicaCD("MAna en vivo", 299f, 15, "rock")));
          //sisRentas.nuevaRenta(new Renta(LocalDate.now(), LocalDate.of(2021,2,25), cliente,new MusicaCD("Zoe", 299f, 15, "rock")));
          //sisRentas.consultaRentas();
          
          
          
          inventario.agregarProducto(new VideojuegoDVD("GTA 3", 399.99f, "XBOX"));
          inventario.agregarProducto(new VideojuegoDVD("God of War", 399.99f, "XBOX"));
          inventario.agregarProducto(new VideojuegoDVD("Shrek 2", 299.99f, "Playstation"));
          SistemaBlackbuster sys = new SistemaBlackbuster();
          sys.menuPrincipal();
          inventario.consultarProducto();

    }
    
    
    private void menuPrincipal(){
        System.out.println("Bienvenido a sistema Blackbuster");
        System.out.println("1. Clientes");
        System.out.println("2. Productos");
        System.out.println("3. Rentas");
        System.out.println("4. Salir");
    }
    
    private void menuClientes(){
        System.out.println("1. Alta cliente");
        System.out.println("2. Baja cliente");
        System.out.println("3. Consulta cliente");
    }
    
    private void menuProductos(){
        System.out.println("1. Alta producto");
        System.out.println("2. Baja producto");
        System.out.println("3. Consulta producto");
    }
    
    private void subMenuClientesBaja(){
        System.out.println("1. Dar de Baja con ID");
        System.out.println("2. Dar de baja con nombre");
        
    }
    
    private void subMenuClienteConsulta(){
        System.out.println("1. Consulta cliente con ID");
        System.out.println("2. Consulta cliente con nombre");
    }
    
}
