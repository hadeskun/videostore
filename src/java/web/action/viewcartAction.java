/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.action;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.ViewManager;

/**
 *
 * @author julian
 */
public class viewcartAction extends Action{

    public viewcartAction() {
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        ShoppingCart carrito = (ShoppingCart) req.getSession().getAttribute("carrito");
        if(carrito != null){
            req.setAttribute("carrito", carrito.getCarrito());
        }
        req.setAttribute("estado", "false");
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }
}
