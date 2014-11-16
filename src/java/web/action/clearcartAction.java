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
public class clearcartAction extends Action{

    public clearcartAction() {
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("carrito");
        cart.clear();
        req.setAttribute("carrito", cart.getCarrito());
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }

}
