/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cart;
import model.ProductModel;
import entity.Product;
/**
 *
 * @author julian
 */
public class ShoppingCartItem extends ShoppingCart{

    Product product;
    private int cantidad;
    private double total;

    public ShoppingCartItem(Product x,int cant) {
        this.product=x;
        this.cantidad=cant;
        this.total=0;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //usado para el metodo update
    public Product getProduct() {
        return product;
    }

    
    public double getTotal() {
        
        this.total = (this.getCantidad() * product.getPrice().doubleValue());
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void sumCantidad() {
        this.cantidad++;
    }

}
