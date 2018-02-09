/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.jedinica.funkcije;

import programiranje.vodic.math.jedinica.Jedinica;
import programiranje.vodic.math.relacija.UporedivaStavka;

/**
 *
 * @author Mikec
 */
public class UporedivaJedinica<T extends Comparable<T>> extends Jedinica<T> implements UporedivaStavka<T>{
    
    public UporedivaJedinica(T objekat) {
        super(objekat);
    }

    @Override
    public int compareTo(T o) {
       return getPodatak().compareTo(o);
    }
    
}
