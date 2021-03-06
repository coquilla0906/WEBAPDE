/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controller.PictureController;
import controller.UserController;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Picture;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;






/**
 *
 * @author Alds
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/uploadServlet"})
public class uploadServlet extends HttpServlet {
    
    private UserController userController = UserController.getInstance();
    private PictureController pictureController = PictureController.getInstance();
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out  = response.getWriter();
        if(!ServletFileUpload.isMultipartContent(request)){
            out.println("Nothing to upload");
            return;
        }
        FileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemFactory);
        try{
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item:items){
                String contentType = item.getContentType();
//                if(!contentType.equals("image/jpg")){
//                    out.println("only jpg format");
//                    continue;
//                }
                File uploadDir = new File("C:\\Bryan");
                File file = File.createTempFile("img", ".jpg", uploadDir);
                item.write(file);
                String user = request.getParameter("username");
                System.out.println("username: "+ user);
                User u = (User) userController.getUserUsingUsername(user);
                int userID = u.getUserID();
                int getPictureID = pictureController.getMaxPicID()+1;
                Picture picture = new Picture(getPictureID, userID, uploadDir.getPath(), "");
                pictureController.addPicture(picture);
                
                
                        
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("index.jsp");
   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
