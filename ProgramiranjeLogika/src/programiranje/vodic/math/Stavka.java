/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math;

/**
 * Stavka - funkcionalni obijekat sistema sa bilo kakvim osobinama<br>
 * Ostalo - pomocne klase dijelovi okruzenja <br>
 * @author Mikec
 */
public abstract class Stavka<T> implements Elemenat<T>{
    private T objekat; 
    public Stavka(T objekat){
        this.objekat = objekat; 
    }
    public synchronized T getPodatak(){
        return objekat; 
    }
    public final String toString(){
        return "<"+super.toString()+"><"+toDataDescription()+"><"+toDataString()+">";
    }
    public String toDataDescription(){
        return objekat.getClass().getName()+"@"+objekat.hashCode(); 
    }
    public String toDataString(){
        return objekat.toString(); 
    }
}
