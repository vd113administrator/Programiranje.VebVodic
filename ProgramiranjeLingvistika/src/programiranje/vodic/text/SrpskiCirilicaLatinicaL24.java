/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.text;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Mikec
 */
public class SrpskiCirilicaLatinicaL24 extends Preslovljavanje{
    private String[] latinica = 
    {
        "A","B","V","G","D",
        "DJ","E","ZH","Z","I",
        "J","K","L","LJ","M",
        "N","NJ","O","P","R",
        "S","T","CJ","U","F",
        "H","C","CH","DZ","SH",
        
        "a","b","v","g","d",
        "dj","e","ž","z","i",
        "j","k","l","lj","m",
        "n","nj","o","p","r",
        "s","t","cj","u","f",
        "h","c","ch","dz","sh"
    };
    
    private String[] cirilica = 
    {
        "А","Б","В","Г","Д",
        "Ђ","Е","Ж","З","И",
        "Ј","К","Л","Љ","М",
        "Н","Њ","О","П","Р",
        "С","Т","Ћ","У","Ф",
        "Х","Ц","Ч","Џ","Ш",
        
        "а","б","в","г","д",
        "ђ","е","ж","з","и",
        "ј","к","л","љ","м",
        "н","њ","о","п","р",
        "с","т","ћ","у","ф",
        "х","ц","ч","џ","ш"
    };
    
    public SrpskiCirilicaLatinicaL24() {
        super(new TreeMap<String,String>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()<o2.length()) return +1; 
                if(o1.length()>o2.length()) return -1;
                return o1.compareTo(o2);
            }
        }));
        for(int i=0; i<60; i++){
            mapa.put(cirilica[i],latinica[i]);
        }
    }
}
