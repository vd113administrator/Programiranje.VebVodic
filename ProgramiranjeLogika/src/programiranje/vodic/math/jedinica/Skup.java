/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.jedinica;

import java.util.Iterator;
import java.util.Set;
import programiranje.vodic.math.Elemenat;
import programiranje.vodic.math.Stavka;
import programiranje.vodic.math.relacija.NabrojivaStavka;

/**
 *
 * @author Mikec
 */
public class Skup<T extends Elemenat> extends Jedinica<Set<T>> implements NabrojivaStavka<T>{
    
    public Skup(Set<T> objekat) {
        super(objekat);
    }

    @Override
    public Iterator<T> iterator() {
        return getPodatak().iterator();
        
    }
}
