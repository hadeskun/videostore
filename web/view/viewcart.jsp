<%-- 
    Document   : viewcart
    Created on : Dec 18, 2010, 11:40:16 AM
    Author     : julian
--%>

<%@page import="entity.Product"%>
<%@page import="cart.ShoppingCartItem"%>
<%@page import="java.util.List"%>
<%@page import="cart.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <img src="img/cart.gif" alt="cart.gif">

           <% ShoppingCart carrito = (ShoppingCart)request.getSession().getAttribute("carrito");
           if(carrito!=null){%>
               <%= carrito.getNumberOfItems()%> items
           <%}%>

           <h2>
           Your shopping cart contains
               <%if(carrito!=null){%>
                    <%= carrito.getNumberOfItems()%> items
               <%}%>
           </h2>

           <a href="clearcart.do">Clear cart</a>
           <br>
           <a href="init.do">Continue shopping</a>
           <br>
           <a href="checkout.do">Proceed to checkout</a>
           <br><br>
       <table width="70%" border="1" bordercolordark="#000000"
              bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0" >
               <tr>
                   <th>Product</th>
                   <th>Name</th>
                   <th>Price</th>
                   <th>Quantity</th>
               </tr>
               <%
               List<ShoppingCartItem> cart = (List<ShoppingCartItem>) request.getAttribute("carrito");
               if(cart!=null){
                   for(ShoppingCartItem index : cart){
                       Product product = index.getProduct();
               %>
                        <tr>
                           <td width="14%" valign="center" align="middle">
                                <img src="img/products/<%=product.getName()%>.jpg"
                                     alt="<%=product.getName()%>" >
                        </td>
                        <td width="14%" valign="center" align="middle">
                            <%=product.getName()%>
                        </td>
                        <td width="14%" valign="center" align="middle">
                            <%=product.getPrice()%>€ / unit
                        </td>
                        <td width="14%" valign="center" align="middle">
                            <form action="updatecart.do" method="post">
                                <input type="hidden" name="idproduct" value="<%=product.getId()%>">
                                   <% String x=(String)request.getAttribute("estado");
                                     if(x=="false"){%>
                                     <input type="text" value="<%=index.getCantidad()%>"
                                       name="cantidad">
                                   <%}else{%>
                                     <input type="text" value="<%=index.getCantidad()%>"
                                       name="cantidad" disabled>
                                   <%}%>  
                                <input type="submit" name="enviar" value="update">
                                
                            </form>

                        </td>
                   </tr>
               <%
                   }
               }%>
           </table>
           <h3>Total amount: <%=carrito.getTotal()%>€</h3>
    </body>
</html>
