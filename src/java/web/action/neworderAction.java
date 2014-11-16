/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.Product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author julian
 */
public class neworderAction extends Action{
    CategoryModel categoryModel;
    ProductModel productModel;

    public neworderAction(CategoryModel categoryModel,ProductModel productModel){
        this.categoryModel = categoryModel;
        this.productModel = productModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {

        req.setAttribute("categories", categoryModel.retrieve());
        String id = req.getParameter("categoryid");
        int id1=Integer.parseInt(id);
        req.setAttribute("categoriaId", productModel.retrieveCat(id1));
      
        //////////////////
        ShoppingCart carro;
        if((carro= (ShoppingCart) req.getSession().getAttribute("carrito")) == null){
            carro = new ShoppingCart();
            req.getSession().setAttribute("carrito", carro);
        }
        String idProduct = req.getParameter("idproduct");
        int idp=Integer.parseInt(idProduct);
        Product nuevo=productModel.retrieveProduct(idp);  //consulto el id de producto
        ShoppingCartItem newProduct= new ShoppingCartItem(nuevo,1);

        carro.addItem(newProduct);
              
        ViewManager.nextView(req, resp, "/view/category.jsp");
        
    }

}
