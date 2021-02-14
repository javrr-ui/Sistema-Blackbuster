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
public class SistemaRentas {

    private ArrayList<Renta> rentas;
    private int contadorIdRenta;

    SistemaRentas() {
        rentas = new ArrayList<>();
        contadorIdRenta = 0;
    }

    public void nuevaRenta(Renta renta) {
        contadorIdRenta +=1;
        renta.setIdRenta(contadorIdRenta);
        rentas.add(renta);
    }

    public void consultaRentas() {
        for (Renta renta : rentas) {
            System.out.println(renta);
        }
    }

}
