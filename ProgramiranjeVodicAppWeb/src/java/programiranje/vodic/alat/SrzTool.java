/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.alat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Mikec
 */
public class SrzTool {
    private File file;
    private ObjectInputStream ois;
    private ObjectOutputStream oos; 
    
    public SrzTool(File file){
        this.file = file; 
    }
    public SrzTool(String string){
        this.file = new File(string);
    }
    
    public synchronized SrzTool initialize() throws IOException{
        if(!file.exists()) file.createNewFile();
        return this; 
    }
    
    public synchronized File getFile(){
        return file;
    }
    public synchronized ObjectInputStream getInput(){
        return ois;
    }
    public synchronized ObjectOutputStream getOutput(){
        return oos; 
    }
    public synchronized SrzTool openInput() throws FileNotFoundException, IOException{
        ois = new ObjectInputStream(new FileInputStream(file));
        return this;
    }
    public synchronized SrzTool openOutput() throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(file));
        return this;
    }
    public synchronized SrzTool closeInput() throws IOException{
        ois.close();
        return this; 
    }
    public synchronized SrzTool closeOutput() throws IOException{
        oos.close();
        return this; 
    }
    public synchronized SrzTool writeObject(Serializable o) throws IOException{
        oos.writeObject(o);
        return this; 
    }
    public synchronized Serializable readObject() throws IOException, ClassNotFoundException{
        return (Serializable) ois.readObject(); 
    }
}