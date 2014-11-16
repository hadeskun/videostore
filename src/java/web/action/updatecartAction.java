/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author julian
 */
public class updatecartAction extends Action{

    ProductModel productModel;

    public updatecartAction(ProductModel productModel) {
   
        this.productModel = productModel;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        int id=99;
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("carrito");
        int cant=Integer.parseInt(req.getParameter("cantidad"));
        id=Integer.parseInt(req.getParameter("idproduct"));
        ShoppingCartItem obj=cart.findItem(id);
        cart.updateCart(obj,cant);
        req.setAttribute("estado","true");
        req.setAttribute("carrito", cart.getCarrito());
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }

}
