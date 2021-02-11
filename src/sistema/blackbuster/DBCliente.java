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
    
   DBCliente(){
       
   }

    public Cliente getCliente(int id) {
        for(Cliente i: clientes){
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }
   
   
    

    public void agregarCliente(Cliente cliente) {
        //Agrega un id unico cuando agrega el cliente al ArrayList
        contadorIdCliente +=1;
        cliente.setId(contadorIdCliente);
        clientes.add(cliente);
    }
    
    public void mostrarClientes(){
        clientes.forEach((cliente) -> System.out.println(cliente) );
    }
    
    
}
