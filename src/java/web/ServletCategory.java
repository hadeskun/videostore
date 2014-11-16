/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;
import entity.Category;
import model.CategoryModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julian
 */
public class ServletCategory extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCategory</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCategory at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        /*CategoryModel objectCategory = new CategoryModel();
        objectCategory.createCrud("Horror");
        out.println("This is a new register in the database");*/
        //Category retrieveCrud = objectCategory.retrieveCrud(1);
        //out.println("Nombre Categoria --> "+retrieveCrud.getName());
        /*objectCategory.updateCrud(1, "Vegetales");
        Category retrieveCrud = objectCategory.retrieveCrud(1);
        out.println("Nombre Categoria --> "+retrieveCrud.getName());*/
        //objectCategory.deleteCrud(0);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Codigo Juan Luis Consulta Ejemplo Select
        CategoryModel categoryModel = new CategoryModel();
        List<Category> list = categoryModel.retrieve();
        for(Category category : list){
            out.print("<br>"+ category.getId() +"__ "+ category.getName());
        }

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
