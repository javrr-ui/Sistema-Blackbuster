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

    Inventario() {
        contadorId = 0;
        inventario = new ArrayList<>();

        agregarProducto(new VideojuegoDVD("GTA 3", 399.99f, 4, "XBOX"));
        agregarProducto(new VideojuegoDVD("Smack down vs raw 2011", 399.99f, 4, "XBOX"));
        agregarProducto(new VideojuegoDVD("God of War", 399.99f, 3, "XBOX"));
        agregarProducto(new MusicaCD("One Direction best songs", 299f, 3, "One Direction", 15, "Pop"));
        agregarProducto(new VideoDVD("Spiderman 3", 100, 4, "accion"));

    }

    public void agregarProducto(Producto producto) {
        contadorId += 1;
        producto.setId(contadorId);
        producto.setDisponible(true);
        inventario.add(producto);
    }

    public void eliminarProducto(String nombre) {

    }

    public void eliminarProducto(int id) {

    }

    public void consultarProducto(String nombre) {

    }

    public void consultarProducto(int id) {

    }

    public Producto getProducto(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public void consultarProducto() {
        inventario.forEach((producto) -> System.out.println(producto));
    }
}
