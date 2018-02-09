/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.alat;

/**
 *
 * @author Mikec
 */
public final class HtmlUtil {
    private HtmlUtil(){
    }
    public static String encodeForNestingToHTML(String string){
        return string.replace("&", "&amp;").replace("<","&lt;").replace(">","&gt;"); 
    }
    public static String decodeFromNestedInHTML(String string){
        return string.replace(">","&gt;").replace("<","&lt;").replace("&", "&amp;"); 
    }
    public static String escapeForForwardToJavaScript(String string){
        return string.replace("\\", "\\\\").replace("'","\\'").replace("\"","\\\""); 
    }
    public static String unescapeFromForwardingInJavaScripy(String string){
        return string.replace("\"","\\\"").replace("'","\\'").replace("\\\\","\\"); 
    }
}
