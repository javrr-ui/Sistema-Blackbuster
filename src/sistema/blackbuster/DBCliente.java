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
public class DBCliente {

    private int contadorIdCliente;
    private ArrayList<Cliente> clientes;

    DBCliente() {
        contadorIdCliente = 0;
        clientes = new ArrayList<>();
    }

    //Recibe un id y busca un cliente, si existe regresa el objeto cliente, si no existe regresa un null
    public Cliente getCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void agregarCliente(Cliente cliente) {
        //Agrega un id unico cuando agrega el cliente al ArrayList
        contadorIdCliente += 1;
        cliente.setId(contadorIdCliente);
        clientes.add(cliente);
    }

    public void eliminarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(id);
            }
        }
    }

    public void mostrarClientes() {
        clientes.forEach((cliente) -> System.out.println(cliente));
    }

}
