/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.brojevi.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import programiranje.vodic.math.brojevi.CijelaJedinica;
import programiranje.vodic.math.brojevi.CijelobrojniElemenat;
import programiranje.vodic.math.brojevi.PrebrojivCijelobrojniSkup;


/**
 *
 * @author Mikec
 */
public class TestA {
    public static void main(String ... args){
        HashSet<CijelobrojniElemenat> set0 = new HashSet<>();
        HashSet<CijelobrojniElemenat> set = new HashSet<>();
        PrebrojivCijelobrojniSkup skup0 = new PrebrojivCijelobrojniSkup(set0);
        PrebrojivCijelobrojniSkup skup = new PrebrojivCijelobrojniSkup(set);
        CijelaJedinica s01 = new CijelaJedinica(1);
        CijelaJedinica s11 = new CijelaJedinica(11);
        CijelaJedinica s02 = new CijelaJedinica(2);
        CijelaJedinica s12 = new CijelaJedinica(22);
        set0.addAll(Arrays.asList(s01,s02));
        set.addAll(Arrays.asList(s11,s12));
        set.add(skup0);
        Iterator<CijelobrojniElemenat> i = skup.iterator(); 
        while(i.hasNext()){
            System.out.println(i.next().toDataString());
        }
    }
}
