/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.blackbuster;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Javi
 */
public class SistemaRentas {
    
    private ArrayList<Renta> rentas;
    
    
    SistemaRentas(){
        rentas = new ArrayList<>();
    }
    
    public void nuevaRenta(Renta renta){
        rentas.add(renta);
    }
    
    public void consultaRentas(){
        for(Renta renta: rentas){
            System.out.println(renta.toString());
        }
    }
    
    
}
