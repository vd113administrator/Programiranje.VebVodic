/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.jedinica;

import programiranje.vodic.math.Stavka;
import programiranje.vodic.math.relacija.PreklapajucaStavka;
import programiranje.vodic.math.relacija.SeparatnaStavka;

/**
 * Jedinica - slicna objektu <br>
 * Jedinica - razlika je sto druge stavke mogu biti tipa jedinica <br>
 * Jedinica - to znaci da jedinica nije klasa objekata samih za sebe <br>
 * Jedinica - to dalje znaci da te izvedene jedinice mogu upotrebljvati funkcionalnosti sitema
 * @author Mikec
 */
public class Jedinica<T> extends Stavka<T> implements PreklapajucaStavka{
    public Jedinica(T objekat) {
        super(objekat);
    }
}
