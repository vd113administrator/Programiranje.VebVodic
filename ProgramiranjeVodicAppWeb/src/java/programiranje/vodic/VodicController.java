/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import programiranje.vodic.alat.PathUtil;
import programiranje.vodic.alat.SrzTool;
import programiranje.vodic.beans.VodicBean;
import programiranje.vodic.beans.util.InformacioniBean;
import programiranje.vodic.fixed.KonstanteStatusa;
import programiranje.vodic.fixed.PutanjeDatoteka;
import programiranje.vodic.model.VodicManager;

/**
 * 
 * @author Mikec
 */
public class VodicController extends HttpServlet{
    private static File root;
    private static SrzTool serijalizacija = new SrzTool(PutanjeDatoteka.datoteke);
    public synchronized static File getRootDirectory(){
        if(root==null) return null; 
        if(!root.exists()) return null; 
        if(!root.isDirectory()) return null; 
        return root;
    }
    
    public synchronized static void setRootDirectory(File file){
        File root = getRootDirectory(); 
        if(root!=null) return;
        VodicController.root = file;
        root = getRootDirectory(); 
        if(root==null)
        VodicController.root = null;
    }
    
    protected void proccessCurrentPath(HttpServletRequest request, HttpServletResponse response){
        VodicBean vodic = (VodicBean) request.getSession().getAttribute("vodic"); 
        String putanja = request.getParameter("vodic_filex");
        String datoteka = request.getParameter("vodic_datax");
        if(vodic==null) return; 
        if(putanja==null) return; 
        File direktorijum = new File(putanja);
        VodicManager manager = vodic.getVodic(); 
        try{
            File trenutni = new File(vodic.getTekucaPutanja());
            boolean inclusive = PathUtil.inclusive(trenutni, direktorijum); 
            boolean exclusive = PathUtil.exclusive(trenutni, direktorijum);
            if(datoteka!=null) {
                File file = new File(datoteka);
                if(file.exists() && file.isFile())
                    manager.setDatoteka(file);
                else 
                    manager.setDatoteka(null);
            }
            else{
                manager.setDatoteka(null);
            }
            if(exclusive && inclusive) return; 
            if(exclusive) manager.kretanjeNaprijed(direktorijum.getName());
            if(inclusive) manager.setTekucaPutanja(direktorijum);
        }catch(Exception ex){
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        VodicBean vodic = (VodicBean) request.getSession().getAttribute("vodic"); 
        InformacioniBean info = (InformacioniBean) request.getSession().getAttribute("poruke");
        String putanja = request.getParameter("vodic_filex");
        String datoteka = request.getParameter("vodic_datax");
        String poruke = request.getParameter("vodic_poruka");
        String status = request.getParameter("vodic_status");
        
        if(info==null){
            info = new InformacioniBean(); 
            request.setAttribute("poruke",info);
        }
        
        if(status!=null && status.equals(KonstanteStatusa.vodicAppOpen)){
            vodic = (VodicBean) serijalizacija.openInput().readObject();
            request.getSession().setAttribute("vodic",vodic);
            serijalizacija.closeInput();
        }
        
        if(vodic==null){
            vodic = new VodicBean();
            request.getSession().setAttribute("vodic",vodic);
        }
        
        ServletContext context = getServletContext();
        String servletPath = context.getRealPath(request.getServletPath());
        File servletFile = new File(servletPath).getParentFile();
        response.setContentType("text/html;charset=UTF-8");
        setRootDirectory(servletFile);
        
        String path = vodic.getTekucaPutanja();
        String file = vodic.getDatoteka();
        proccessCurrentPath(request,response);
        
        info.setStatus(status);
        if(status == null){
            response.sendRedirect("index.jsp");
        }
        else if(status.equals(KonstanteStatusa.vodicAppOpen)){
            info.setPoruka("Очитавање података стања апликације успјешно.");
            response.sendRedirect("successfull.jsp");
        }
        else if(status.equals(KonstanteStatusa.voidcAppSave)){
            serijalizacija.initialize().openOutput().writeObject(vodic).closeOutput();
            info.setPoruka("Чување података стања апликације успјешно.");
            response.sendRedirect("successfull.jsp");
        }
        else if(status.equals(KonstanteStatusa.voidcAppDownload)){
            File download = new File(path,file);
            if(download==null || !download.exists() || !download.isFile())
                throw new RuntimeException("Преузимање није дефинисано или подржано.");
            info.setPoruka("Захтијев за преузимање датотеке прихваћен.<br>("+download.getName()+")");
            String patha = download.getCanonicalPath().substring(root.getCanonicalPath().length()+1); 
            InformacioniBean dwib = new InformacioniBean();
            dwib.setDownload(patha);
            request.getSession().setAttribute("download", dwib);
            response.sendRedirect("download.jsp");
        }
        else{
            response.sendRedirect("index.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public String getServletInfo(){
        return "Main controller.";
    }
}
