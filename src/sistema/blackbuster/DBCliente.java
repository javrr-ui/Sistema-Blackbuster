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
    
    private int contadorIdCliente=0;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        contadorIdCliente +=1;
        cliente.setId(contadorIdCliente);
        clientes.add(cliente);
    }
    
    public void mostrarClientes(){
        clientes.forEach((cliente) -> System.out.println(cliente) );
    }
    
    
}
