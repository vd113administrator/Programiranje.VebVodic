/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.jedinica.funkcije;

import java.util.Iterator;
import java.util.Set;
import programiranje.vodic.math.jedinica.Jedinica;
import programiranje.vodic.math.relacija.NabrojivaStavka;

/**
 *
 * @author Mikec
 */
public class NabrojivaJedinica<T> extends Jedinica<Set<T>> implements NabrojivaStavka<T>{ 

    public NabrojivaJedinica(Set<T> objekat) {
        super(objekat);
    }

    @Override
    public Iterator<T> iterator() {
        return getPodatak().iterator();
    }
}
