/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.blackbuster;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class SistemaBlackbuster {

    Scanner scan;
    Inventario inventario;
    SistemaRentas sisRentas;
    DBCliente dbClientes;
    int opc;

    public SistemaBlackbuster() {

        scan = new Scanner(System.in);
        inventario = new Inventario(); //Inventario de productos
        sisRentas = new SistemaRentas();//sistema de Registro de las rentas
        dbClientes = new DBCliente();// base de datos de clientes

    }

    public void run() {

//      Producto juego1 = new VideojuegoDVD("Crash Bandicoot",399.99f,"XBOX");
//      if(juego1 instanceof MusicaCD){
        dbClientes.agregarCliente(new Cliente("Francisco"));
        dbClientes.agregarCliente(new Cliente("Armando"));
        dbClientes.agregarCliente(new Cliente("Sara"));
        //dbClientes.mostrarClientes();

        sisRentas.nuevaRenta(new Renta(LocalDate.now(), LocalDate.of(2021, 2, 21), dbClientes.getCliente(1), inventario.getProducto(1)));
        sisRentas.nuevaRenta(new Renta(LocalDate.now(), LocalDate.of(2021, 2, 25), dbClientes.getCliente(2), inventario.getProducto(3)));
        sisRentas.nuevaRenta(new Renta(LocalDate.now(), LocalDate.of(2021, 2, 25), dbClientes.getCliente(2), inventario.getProducto(2)));
        sisRentas.consultaRentas();

        //al llamar el metodo consultarProducto sin parametros, muestra todo el inventario
        //inventario.consultarProducto();
        System.out.println("Bienvenido a sistema Blackbuster");
        menuPrincipal();
    }

    public void menuPrincipal() {

        do {

            System.out.println("1. Clientes");
            System.out.println("2. Productos");
            System.out.println("3. Rentas");
            System.out.println("4. Salir");
            try {
                opc = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                // e.printStackTrace();
                //System.out.println(e);
            }

        } while (opc < 1 || opc > 4);
        switch (opc) {
            case 1:
                menuClientes();
                break;
            case 2:
                menuProductos();
                break;
            case 3:
                menuRentas();
                break;
            default:
                break;
        }

    }

    public void menuClientes() {

        do {
            System.out.println("1. Alta cliente");
            System.out.println("2. Baja cliente");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Consulta cliente");
            System.out.println("5. Salir");
            try {
                opc = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                // failure
            }
        } while (opc < 1 || opc > 5);
        switch (opc) {
            case 1:
                //Alta cliente
                subMenuAltaCliente();
                menuPrincipal();
                break;
            case 2:
                //Submenu para baja de clientes
                subMenuBajaCliente();
                menuPrincipal();
                break;
            case 3:
                //submenu para editar clientes
                subMenuEditaCliente();
                menuPrincipal();
                break;
            case 4:
                subMenuConsultaCliente();
                menuPrincipal();
                break;
            default:
                break;
        }

    }

    public void menuProductos() {
        
        
        do {
            System.out.println("1. Alta producto");
            System.out.println("2. Baja producto");
            System.out.println("3. Modificar producto");
            System.out.println("4. Consulta producto");
            System.out.println("5. Salir");
            try {
                opc = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                // failure
            }
        } while (opc < 1 || opc > 5);
    }

    public void menuRentas() {
        System.out.println("1. Nueva renta");
        System.out.println("2. Devolución");

    }

    public void subMenuAltaCliente() {
        String nombre = "";

        System.out.print("Ingrese nombre del cliente: ");
        try {
            nombre = scan.nextLine();
        } catch (Exception e) {
            // failure
        }
        dbClientes.agregarCliente(new Cliente(nombre));
        System.out.println("Nuevo cliente " + nombre + " agregado.");

    }

    public void subMenuBajaCliente() {
        System.out.print("1. Ingresa el ID del cliente que quieres dar de Baja: ");
        try{
            opc = Integer.parseInt(scan.nextLine());
        }catch(Exception e){
            // Error
        }
        if (dbClientes.getCliente(opc) != null) {
            System.out.println(dbClientes.getCliente(opc));
            System.out.print("¿Este es el cliente que quieres eliminar si/no: ");
            String op = scan.nextLine();
            if ("si".equalsIgnoreCase(op)) {
                System.out.print("Ingrese el nuevo nombre: ");
                op = scan.nextLine();
                Cliente refCliente = dbClientes.getCliente(opc);
                refCliente.setNombre(op);
            } else {
                subMenuEditaCliente();
            }
            

        } else {
            System.out.println("No existe cliente con ese ID.");
        }

    }

    public void subMenuEditaCliente() {
        System.out.print("1. Ingresa el ID del cliente que quieres editar: ");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {

        }
        if (dbClientes.getCliente(opc) != null) {
            System.out.println(dbClientes.getCliente(opc));
            System.out.print("¿Este es el cliente que quieres editar? si/no: ");
            String op = scan.nextLine();
            System.out.print("op="+op);
            if ("si".equalsIgnoreCase(op)) {
                System.out.print("Ingrese el nuevo nombre: ");
                op = scan.nextLine();
                Cliente refCliente = dbClientes.getCliente(opc);
                refCliente.setNombre(op);
            } else {
                subMenuEditaCliente();
            }

        } else {
            System.out.println("No existe cliente con ese ID.");
        }
    }

    public void subMenuConsultaCliente() {
        System.out.println("1. Consulta cliente con ID");
        System.out.println("2. Consulta general");
        try {
            //scan.nextLine();
            opc = Integer.parseInt(scan.nextLine());

        } catch (Exception e) {
            // e.printStackTrace();
            //System.out.println(e);
        }
        switch (opc) {
            case 1:
                System.out.print("Ingresa el ID  del cliente:");
                try {
                    //scan.nextLine();
                    opc = Integer.parseInt(scan.nextLine());
                } catch (Exception e) {
                    // e.printStackTrace();
                    //System.out.println(e);
                }
                if (dbClientes.getCliente(opc) != null) {
                    System.out.println(dbClientes.getCliente(opc));
                } else {
                    System.out.println("No existe cliente con ese ID.");
                }
                break;
            case 2:
                dbClientes.mostrarClientes();
                break;
            default:
                break;
        }

    }

    public void menuReutilizable(String menu, int maxOpc) {

        do {
            System.out.println(menu);
            try {
                opc = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                // failure
            }
        } while (opc < 1 || opc > maxOpc);
        switch (opc) {
            case 1:
                break;
        }
    }
}
