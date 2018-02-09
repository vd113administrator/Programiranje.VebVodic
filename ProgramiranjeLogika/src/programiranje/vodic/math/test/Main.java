/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import javax.lang.model.element.Element;
import programiranje.vodic.math.Elemenat;
import programiranje.vodic.math.Stavka;
import programiranje.vodic.math.jedinica.Jedinica;
import programiranje.vodic.math.jedinica.Objekat;
import programiranje.vodic.math.jedinica.Skup;

/**
 *
 * @author Mikec
 */
public class Main {
    public static void main(String ... args){
        HashSet<Elemenat> set0 = new HashSet<>();
        HashSet<Elemenat> set = new HashSet<>();
        Skup skup0 = new Skup(set0);
        Skup skup = new Skup(set);
        Jedinica<Integer> s01 = new Jedinica<>(1);
        Jedinica<Integer> s11 = new Jedinica<>(11);
        Jedinica<Integer> s02 = new Jedinica<>(2);
        Jedinica<Integer> s12 = new Jedinica<>(22);
        Objekat<Integer> s03 = new Objekat<>(3);  
        Objekat<Integer> s13 = new Objekat<>(33);
        set0.addAll(Arrays.asList(s01,s02,s03));
        set.addAll(Arrays.asList(s11,s12,s13));
        set.add(skup0);
        Iterator<Elemenat> i = skup.iterator(); 
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
