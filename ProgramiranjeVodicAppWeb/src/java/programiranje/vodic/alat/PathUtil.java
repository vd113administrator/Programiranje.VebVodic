/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.alat;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mikec
 */
public final class PathUtil {
   private PathUtil(){
   }
   public static boolean inclusive(File file1, File file2) throws IOException{
       String path1 = file1.getCanonicalPath(); 
       String path2 = file2.getCanonicalPath(); 
       return path1.startsWith(path2);
   }
   public static boolean inclusive(String path1, String path2) throws IOException{
       File file1 = new File(path1);
       File file2 = new File(path2);
       return inclusive(file1,file2);
   }
   public static boolean inclusive(File file1, String path2) throws IOException{
       File file2 = new File(path2);
       return inclusive(file1,file2);
   }
   public static boolean inclusive(String path1, File file2) throws IOException{
       File file1 = new File(path1);
       return inclusive(file1,file2);
   }
   public static boolean exclusive(File file1, File file2) throws IOException{
       return inclusive(file2,file1);
   }
   public static boolean exclusive(String path1, File file2) throws IOException{
       return inclusive(file2,path1);
   }
   public static boolean exclusive(File file1, String path2) throws IOException{
       return inclusive(path2,file1);
   }
   public static boolean exclusive(String file1, String file2) throws IOException{
       return inclusive(file2,file1);
   }
   public static String path(File file) throws IOException{
       return file.getCanonicalPath(); 
   }
   public static String path(String path) throws IOException{
       return path(new File(path));
   }
   public static String path(String dir, String path) throws IOException{
       return path(file(dir,path));
   }
   public static String path(File dir, String path) throws IOException{
       return path(file(dir,path));
   }
   public static String path(String dir, File path) throws IOException{
       return path(file(dir,path));
   }
   public static String path(File dir, File path) throws IOException{
       return path(file(dir,path));
   }
   public static String[] explode(File file) throws IOException{
       return path(file).split(File.separator); 
   }
   public static String[] explode(String path) throws IOException{
       return path(path).split(File.separator);
   }
   public static File file(String path){
       return new File(path);
   }
   public static File file(String dir, String path){
       return new File(dir,path);
   }
   public static File file(File dir, String path){
       return new File(dir,path);
   }
   public static File file(File dir, File path) throws IOException{
       return new File(dir,path(path));
   }
   public static File file(String dir, File path) throws IOException{
       return new File(dir,path(path));
   }
}
