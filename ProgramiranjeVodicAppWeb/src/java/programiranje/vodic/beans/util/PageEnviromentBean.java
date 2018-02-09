/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.beans.util;

import java.io.Serializable;

/**
 *
 * @author Mikec
 */
public class PageEnviromentBean implements Serializable{
     private String klasa;
     public String getKlasa(){
         return klasa; 
     }
     public void setKlasa(String klasa){
         this.klasa = klasa;
     }
}
