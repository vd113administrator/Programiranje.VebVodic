/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math.brojevi;

import java.util.Set;
import programiranje.vodic.math.jedinica.Skup;

/**
 *
 * @author Mikec
 */
public class PrebrojivCijelobrojniSkup extends Skup<CijelobrojniElemenat> implements CijelobrojniElemenat<Set<CijelobrojniElemenat>>{
    public PrebrojivCijelobrojniSkup(Set<CijelobrojniElemenat> objekat) {
        super(objekat);
    }
}
