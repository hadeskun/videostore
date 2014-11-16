/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cart;
import java.util.*;
import entity.Product;

/**
 *
 * @author julian
 */
public class ShoppingCart{

    List<ShoppingCartItem> carrito;
    private int nItems;
    private double total;

    public ShoppingCart() {
        carrito = new ArrayList<ShoppingCartItem>();
        this.nItems=0;
        this.total=0;
    }

    public List<ShoppingCartItem> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<ShoppingCartItem> carrito) {
        this.carrito = carrito;
    }

    //Actualiza los items del carrito de compras
    public synchronized void updateCart(ShoppingCartItem obj,int cantidad){
        if (cantidad >= 0) {

            ShoppingCartItem aux = null;

            for (ShoppingCartItem item : carrito) {

                if (item.getProduct().getId() == obj.getProduct().getId()) {

                    if (cantidad != 0) {
                        item.setCantidad(cantidad);
                    } else {
                        aux = item;
                        break;
                    }
                }
            }

            if (aux != null) {
                carrito.remove(aux);
            }
        }
    }//end update

    //Obtener el numero de Items
    public int getNumberOfItems(){
        int n = 0;
        for(ShoppingCartItem index : carrito) {
            n += index.getCantidad();
        }
        this.nItems=n;
        return this.nItems;
    }

    public double getTotal(){
     double aux = 0;
        this.total=0;
        for(ShoppingCartItem cart:carrito){
            aux=aux+cart.getTotal();
        }
        this.total=this.total+aux;
        return this.total;
    }

    public void clear(){
        this.carrito.clear();
        this.nItems = 0;
        this.total = 0;
    }

    public synchronized void addItem(ShoppingCartItem obj){
        boolean flag = false;

        for (ShoppingCartItem item : carrito) {

            if (item.getProduct().getId() == obj.getProduct().getId()) {
                flag = true;
                item.sumCantidad();
            }
        }//end for
        if (!flag)
            carrito.add(obj);
    }

    public synchronized ShoppingCartItem findItem(int id){
        boolean flag = false;
        ShoppingCart aux = null;

        for (ShoppingCartItem item : carrito) {

            if (item.getProduct().getId() == id) {
                aux=item;
                break;
            }
        }
        return (ShoppingCartItem) aux;
    }

    




}