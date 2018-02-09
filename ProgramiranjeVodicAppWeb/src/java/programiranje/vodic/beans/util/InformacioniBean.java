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
public class InformacioniBean implements Serializable{
    private String poruka; 
    private String status; 
    private String download; 
    
    public String getPoruka(){
        return poruka; 
    }
    
    public String getStatus(){
        return status; 
    }
    
    public void setPoruka(String poruka){
        this.poruka = poruka; 
    }
    
    public void setStatus(String status){
        this.status = status; 
    }
    
    public String getDownload(){
        return download; 
    }
    
    public void setDownload(String str){
        download = str;
    }
}
