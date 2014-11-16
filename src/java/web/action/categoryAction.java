/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

/**
 *
 * @author julian
 */
import javax.servlet.http.*;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

public class categoryAction extends Action {

    CategoryModel categoryModel;
    ProductModel productModel;

    public categoryAction(CategoryModel categoryModel,ProductModel productModel){
        this.categoryModel = categoryModel;
        this.productModel = productModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        
        req.setAttribute("categories", categoryModel.retrieve());
        String id = req.getParameter("categoryid");
        String nom = req.getParameter("nom");
        int id1=Integer.parseInt(id);
        req.setAttribute("categoriaId", productModel.retrieveCat(id1));
        req.setAttribute("nomcat", nom);
        ViewManager.nextView(req, resp, "/view/category.jsp");
               
    }
}
