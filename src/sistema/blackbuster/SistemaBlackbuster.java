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
                    System.out.print("Ingrese la plataforma (xbox, playstation, nintendo,pc):");
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
                default:
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
                System.out.println("El producto " + inventario.getProducto(opc) + " ha sido eliminado");
                inventario.eliminarProducto(opc);
            } else {
                subMenuBajaProducto();
            }
        } else {
            System.out.println("No existe cliente con ese ID.");
        }
    }

    public void subMenuModificaProducto() {
        System.out.print("1. Ingresa el ID del producto que quieres editar: ");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {

        }
        if (inventario.getProducto(opc) != null) {
            System.out.println(inventario.getProducto(opc));
            System.out.print("¿Este es el producto que quieres modificar? si/no: ");
            String op = scan.nextLine();
            if ("si".equalsIgnoreCase(op)) {
                if (inventario.getProducto(opc) instanceof VideojuegoDVD) {
                    modificaVideojuegoDVD(opc);
                }
                if (inventario.getProducto(opc) instanceof MusicaCD) {
                    modificaMusicaCD(opc);
                }
                if (inventario.getProducto(opc) instanceof VideoDVD) {
                    modificaVideoDVD(opc);
                }
            } else {
                subMenuModificaProducto();
            }

        } else {
            System.out.println("No existe un producto con ese ID.");
        }

    }

    public void modificaVideojuegoDVD(int id) {

        System.out.println("¿Que quiere modificar? ");
        System.out.println("1. Nombre\n2. Precio\n3. Unidades\n4. Plataforma\n5. Todo");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Esa opcion no existe.");
            modificaVideojuegoDVD(id);
        }
        if (opc < 1 || opc > 5) {
            System.out.println("Esa opcion no existe.");
            modificaVideojuegoDVD(id);
        }
        String op;
        switch (opc) {
            case 1:
                modificarNombre(id);
                break;
            case 2:
                modificarPrecio(id);
                break;
            case 3:
                modificarUnidades(id);
                break;
            case 4:
                modificarPlataforma(id);
                break;
            case 5:
                modificarNombre(id);
                modificarPrecio(id);
                modificarUnidades(id);
                modificarPlataforma(id);
                break;
            default:
                break;

        }
    }

    public void modificaVideoDVD(int id) {
        System.out.println("¿Que quiere modificar? ");
        System.out.println("1. Nombre\n2. Precio\n3. Unidades\n4. Genero\n5. Todo");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Esa opcion no existe.");
            modificaVideoDVD(id);
        }
        if (opc < 1 || opc > 5) {
            System.out.println("Esa opcion no existe.");
            modificaVideoDVD(id);
        }
        String op;
        switch (opc) {
            case 1:
                modificarNombre(id);
                break;
            case 2:
                modificarPrecio(id);
                break;
            case 3:
                modificarUnidades(id);
                break;
            case 4:
                modificarGenero(id);
                break;
            case 5:
                modificarNombre(id);
                modificarPrecio(id);
                modificarUnidades(id);
                modificarGenero(id);
                break;
            default:
                break;

        }
    }

    public void modificaMusicaCD(int id) {
        System.out.println("¿Que quiere modificar? ");
        System.out.println("1. Nombre\n2. Precio\n3. Unidades\n4. Artista\n5. Numero de canciones\n6. Genero\n7. Todo");
        try {
            opc = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Esa opcion no existe.");
            modificaMusicaCD(id);
        }
        if (opc < 1 || opc > 7) {
            System.out.println("Esa opcion no existe.");
            modificaMusicaCD(id);
        }
        String op;
        switch (opc) {
            case 1:
                modificarNombre(id);
                break;
            case 2:
                modificarPrecio(id);
                break;
            case 3:
                modificarUnidades(id);
                break;
            case 4:
                modificarArtista(id);
                break;
            case 5:
                modificarNumeroCanciones(id);
                break;
            case 6:
                modificarGeneroMusica(id);
                break;
            case 7:
                modificarNombre(id);
                modificarPrecio(id);
                modificarUnidades(id);
                modificarArtista(id);
                modificarNumeroCanciones(id);
                modificarGeneroMusica(id);
                break;
            default:
                break;

        }
    }

    //funciones para modificar un atributo determinado
    public void modificarNombre(int id) {
        String op;
        System.out.print("Ingrese el nuevo nombre: ");
        op = scan.nextLine();
        inventario.getProducto(id).setNombre(op);
        System.out.println("Producto modificado: " + inventario.getProducto(id));
    }

    public void modificarPrecio(int id) {
        float precio = 0;
        System.out.print("Ingrese el nuevo precio: ");
        try {
            precio = Float.parseFloat(scan.nextLine());
            inventario.getProducto(id).setPrecio(precio);
            System.out.println("Producto modificado: " + inventario.getProducto(id));
        } catch (Exception e) {
            System.out.println("Dato invalido");
            subMenuModificaProducto();
        }
    }

    public void modificarUnidades(int id) {
        System.out.print("Ingrese el nuevo numero de unidades: ");
        try {
            opc = Integer.parseInt(scan.nextLine());
            inventario.getProducto(id).setUnidades(id);
            System.out.println("Producto modificado: " + inventario.getProducto(id));
        } catch (Exception e) {
            System.out.println("Dato invalido");
            subMenuModificaProducto();
        }
    }

    public void modificarPlataforma(int id) {
        String op;
        System.out.print("Ingrese la nueva plataforma: ");
        op = scan.nextLine();

        //Downcasting
        ((VideojuegoDVD) inventario.getProducto(id)).setPlataforma(op);
        System.out.println("Producto modificado: " + inventario.getProducto(id));
    }

    public void modificarGenero(int id) {
        String op;
        System.out.print("Ingrese el nuevo genero: ");
        op = scan.nextLine();
        //downcasting
        ((VideoDVD) inventario.getProducto(id)).setGenero(op);
        System.out.println("Producto modificado: " + inventario.getProducto(id));
    }

    public void modificarNumeroCanciones(int id) {
        System.out.print("Ingrese el nuevo numero de canciones: ");
        try {
            opc = Integer.parseInt(scan.nextLine());
            ((MusicaCD) inventario.getProducto(id)).setNumeroDeCanciones(opc);
            System.out.println("Producto modificado: " + inventario.getProducto(id));
        } catch (Exception e) {
            System.out.println("Dato invalido");
            subMenuModificaProducto();
        }
    }

    public void modificarGeneroMusica(int id) {
        String op;
        System.out.print("Ingrese el nuevo genero: ");
        op = scan.nextLine();
        //downcasting
        ((MusicaCD) inventario.getProducto(id)).setGenero(op);
        System.out.println("Producto modificado: " + inventario.getProducto(id));
    }

    public void modificarArtista(int id) {
        String op;
        System.out.print("Ingrese el nuevo artista: ");
        op = scan.nextLine();
        //downcasting
        ((MusicaCD) inventario.getProducto(id)).setArtista(op);
        System.out.println("Producto modificado: " + inventario.getProducto(id));
    }

    public void SubMenuConsultaProducto() {
        inventario.consultarProducto();
    }

    public void menuRentas() {
        int clienteId;
        int productoId;
        LocalDate fecha = LocalDate.now();
        LocalDate fechaEntrega = fecha;

        System.out.println("1. Nueva renta");
        System.out.println("2. Devolución");
        System.out.println("3. Consulta rentas activas");
        System.out.println("4. Salir");

        try {
            opc = Integer.parseInt(scan.nextLine());

        } catch (Exception e) {
            System.out.println("Dato invalido");
        }
        switch (opc) {
            case 1:
                System.out.println("NUEVA RENTA");
                System.out.print("Ingrese el id del cliente: ");
                try {
                    //scan.nextLine();
                    opc = Integer.parseInt(scan.nextLine());
                    clienteId = opc;
                } catch (Exception e) {
                    System.out.println("Dato invalido");
                    break;
                }
                if (dbClientes.getCliente(opc) != null) {
                    System.out.println("¿Que producto desea rentar " + dbClientes.getCliente(opc).getNombre() + "?");
                    System.out.println("Ingrese el id del producto que desea rentar: ");
                    try {
                        opc = Integer.parseInt(scan.nextLine());
                        if (inventario.getProducto(opc) != null) {
                            if (inventario.getProducto(opc).getUnidades() > 0) {
                                productoId = opc;
                                System.out.println("El producto seleccionado es: " + inventario.getProducto(opc));
                                System.out.println("La fecha de hoy es:" + fecha);
                                System.out.print("Ingrese cuantos días quiere rentar el producto: ");
                                try {
                                    opc = Integer.parseInt(scan.nextLine());
                                    fechaEntrega = fecha.plusDays(opc);
                                    System.out.println("La fecha de devolución es: " + fechaEntrega);

                                    //Crea la nueva renta 
                                    Renta renta = new Renta(fecha, fechaEntrega, dbClientes.getCliente(clienteId), inventario.getProducto(productoId));
                                    //Disminuye una unidad al producto cuando se realiza una renta
                                    int unidades = inventario.getProducto(productoId).getUnidades();
                                    inventario.getProducto(productoId).setUnidades(unidades-1);
                                    //cuando unidades es igual a cero, el producto ya no esta disponible
                                    if(inventario.getProducto(productoId).getUnidades()==0){
                                        inventario.getProducto(productoId).setDisponible(false);
                                    }
                                    
                                    sisRentas.nuevaRenta(renta);
                                    System.out.println("Renta creada: " + renta);
                                    menuPrincipal();

                                } catch (Exception e) {
                                    //error
                                    System.out.println("Dato invalido");
                                }
                            } else {
                                System.out.println("Ya no hay unidades disponibles de este producto");
                            }

                        } else {
                            System.out.println("No existe un producto con ese ID");
                        }
                    } catch (Exception e) {
                        System.out.println("Dato invalido");
                    }

                } else {
                    System.out.println("No existe cliente con ese ID.");
                }
                menuPrincipal();
                break;
            case 2:
                System.out.println("DEVOLUCION");
                System.out.print("Ingrese el id del cliente: ");
                try {
                    //scan.nextLine();
                    opc = Integer.parseInt(scan.nextLine());
                    clienteId = opc;
                } catch (Exception e) {
                    System.out.println("Dato invalido");
                    break;
                }
                if (dbClientes.getCliente(opc) != null) {

                    if (sisRentas.consultaRentasCliente(opc) > 0) {

                    } else {
                        System.out.println("El cliente no tiene rentas activas");
                    }

                } else {
                    System.out.println("No existe cliente con ese ID.");
                }
                menuPrincipal();
                break;
            case 3:
                sisRentas.consultaRentas();
                menuPrincipal();
                break;
            default:
                break;

        }

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
                dbClientes.eliminarCliente(opc);
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

}
