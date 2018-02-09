/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.jedinica;

import programiranje.vodic.math.Stavka;
import programiranje.vodic.math.relacija.SeparatnaStavka;

/**
 * Objekat - bilo kakva funkcionalna stavka podataka <br>
 * Objekat - ne moze koristiti nikakve funkcionalnosti sistena <br>
 * Objekat - vezanost za sistem samo egzistencija kao funkcionalne jedice <br>
 * Objekat - moze dakle samo egzistirati bilo gdje i nositi vanjske podatke <br>
 * Objekat - ni po kom drugom pravilu sistemski funkcionalnosti 
 *           ne moze se dovesti u vezu sa drugim stavkama ili objektima <br>
 * @author Mikec
 */
public class Objekat<T> extends Stavka<T> implements SeparatnaStavka{
    
    public Objekat(T objekat) {
        super(objekat);
    }
    
}
