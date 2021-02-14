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
            } catch (NumberFormatException e) {
                // e.printStackTrace();
                //System.out.println(e);
            }

        } while (opc < 1 || opc > 4);
        switch (opc) {
            case 1 ->
                menuClientes();
            case 2 ->
                menuProductos();
            case 3 ->
                menuRentas();
            default -> {
            }
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
            } catch (NumberFormatException e) {
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
                subMenuModificaCliente();
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
            } catch (NumberFormatException e) {
                // failure
            }
        } while (opc < 1 || opc > 5);
        switch (opc) {
            case 1:
                subMenuAltaProducto();
                menuPrincipal();
                break;
            case 2:
                subMenuBajaProducto();
                menuPrincipal();
                break;
            case 3:
                subMenuModificaProducto();
                menuPrincipal();
                break;
            case 4:
                SubMenuConsultaProducto();
                menuPrincipal();
                break;
            default:
                break;
        }
    }

    public void subMenuAltaProducto() {
        String nombre, plataforma, artista, genero = "";
        int unidades, numCanciones = 0;
        float precio;
        Producto nuevo;

        System.out.println("Seleccione el tipo de producto que quiere dar de alta");
        System.out.println("1. DVD Videojuego\n2. DVD Video\n3.CD Musica");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            //error 
        }
        if (opc < 1 || opc > 3) {
            System.out.println("Esa opción no existe, intentelo de nuevo.");
            subMenuAltaProducto();
        } else {
            switch (opc) {
                case 1:
                    System.out.println("ALTA DVD VIDEOJUEGO");
                    System.out.print("Ingrese el nombre:");
                    nombre = scan.nextLine();
                    System.out.print("Precio de renta:");
                    precio = Float.parseFloat(scan.nextLine());
                    System.out.print("Ingrese la cantidad de unidades disponibles:");
                    unidades = Integer.parseInt(scan.nextLine());
                    System.out.print("Ingrese la plataforma (xbox, playstation, nintendo):");
                    plataforma = scan.nextLine();
                    //Crea una instancia de un videojuego y lo agrega al inventario
                    nuevo = new VideojuegoDVD(nombre, precio, unidades, plataforma);
                    inventario.agregarProducto(nuevo);
                    System.out.println("Agregaste el producto " + nuevo);
                    break;
                case 2:
                    System.out.println("ALTA DVD VIDEO");
                    System.out.print("Ingrese el nombre:");
                    nombre = scan.nextLine();
                    System.out.print("Precio de renta:");
                    precio = Float.parseFloat(scan.nextLine());
                    System.out.print("Ingrese la cantidad de unidades disponibles:");
                    unidades = Integer.parseInt(scan.nextLine());
                    System.out.print("Ingrese el genero del video:");
                    genero = scan.nextLine();

                    nuevo = new VideoDVD(nombre, precio, unidades, genero);
                    inventario.agregarProducto(nuevo);
                    System.out.println("Agregaste el producto " + nuevo);
                    break;
                case 3:
                    System.out.println("ALTA CD MUSICA");
                    System.out.print("Ingrese el nombre del CD:");
                    nombre = scan.nextLine();
                    System.out.print("Precio de renta:");
                    precio = Float.parseFloat(scan.nextLine());
                    System.out.print("Ingrese la cantidad de unidades disponibles:");
                    unidades = Integer.parseInt(scan.nextLine());
                    System.out.print("Ingrese el nombre del artista:");
                    artista = scan.nextLine();
                    System.out.print("Ingrese el numero de canciones:");
                    numCanciones = Integer.parseInt(scan.nextLine());
                    System.out.print("Ingrese el género:");
                    genero = scan.nextLine();

                    nuevo = new MusicaCD(nombre, precio, unidades, artista, numCanciones, genero);
                    inventario.agregarProducto(nuevo);
                    System.out.print("Agregaste el producto " + nuevo);
                    break;
            }
        }

    }

    public void subMenuBajaProducto() {
        System.out.print("1. Ingresa el ID del producto que quieres dar de Baja: ");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            // Error
        }
        if (inventario.getProducto(opc) != null) {
            System.out.println(inventario.getProducto(opc));
            System.out.print("¿Este es el producto que quieres eliminar si/no: ");
            String op = scan.nextLine();
            if ("si".equalsIgnoreCase(op)) {
                if (inventario.getProducto(opc) instanceof VideojuegoDVD) {

                }
                if(inventario.getProducto(opc) instanceof MusicaCD){
                    
                } 
                if(inventario.getProducto(opc) instanceof VideoDVD){
                    
                }
            } else {
                subMenuBajaProducto();
            }
        } else {
            System.out.println("No existe cliente con ese ID.");
        }
    }

    public void subMenuModificaProducto() {

    }

    public void SubMenuConsultaProducto() {

        inventario.consultarProducto();

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
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
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
                subMenuBajaCliente();
            }
        } else {
            System.out.println("No existe cliente con ese ID.");
        }

    }

    public void subMenuModificaCliente() {
        System.out.print("1. Ingresa el ID del cliente que quieres editar: ");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {

        }
        if (dbClientes.getCliente(opc) != null) {
            System.out.println(dbClientes.getCliente(opc));
            System.out.print("¿Este es el cliente que quieres editar? si/no: ");
            String op = scan.nextLine();
            System.out.print("op=" + op);
            if ("si".equalsIgnoreCase(op)) {
                System.out.print("Ingrese el nuevo nombre: ");
                op = scan.nextLine();
                Cliente refCliente = dbClientes.getCliente(opc);
                refCliente.setNombre(op);
            } else {
                subMenuModificaCliente();
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
