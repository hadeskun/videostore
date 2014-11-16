/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;
import entity.Category;
import entity.Product;
import model.ProductModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;

/**
 *
 * @author julian
 */
public class ServletProduct extends HttpServlet {
   
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
            out.println("<title>Servlet ServletProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProduct at " + request.getContextPath () + "</h1>");
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
        ProductModel objectProduct = new ProductModel();
        /*objectProduct.createCrud("Papaya",(float) 50.12, "Dulce", 0);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("New Register....");*/
       /* response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Product retrieveCrud = objectProduct.retrieveCrud(0);
        out.println("Name: "+retrieveCrud.getName());
        out.println("Description: "+retrieveCrud.getDescription());*/
        /*objectProduct.updateCrud(0,"Pera", (float) 5.2, "Biche", 0);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Product retrieveCrud = objectProduct.retrieveCrud(0);
        out.println("Name: "+retrieveCrud.getName());
        out.println("Description: "+retrieveCrud.getDescription());*/
       // objectProduct.deleteCrud(0);

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
