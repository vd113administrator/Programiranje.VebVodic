/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.math;

/**
 * Alternativa za stavku kod visestrukog nasledjivanja
 * @author Mikec
 */
public interface Elemenat<T>{
    public T getPodatak();
    public String toString();
    public String toDataDescription();
    public String toDataString();
}
