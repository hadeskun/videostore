<%-- 
    Document   : category
    Created on : Dec 18, 2010, 11:39:58 AM
    Author     : julian
--%>

<%@page import="cart.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="entity.Category" %>
<%@ page import="entity.Product" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
    </head>
    <body>
         <%
                String nombrecat = (String)request.getAttribute("nomcat");
                  
                %>
        <h3> Products of <%=nombrecat%> </h3>
        <img src="img/cart.gif" alt="cart.gif">
        <% ShoppingCart c = (ShoppingCart)request.getSession().getAttribute("carrito");
           if(c!=null){ %>
               <%= c.getNumberOfItems()%> Items
               <a href="viewcart.do">View Cart</a>
                    <br>
                    <br>
               <a href="checkout.do">Proceed to Checkout</a>
            <%}
            else{%>0  Items<%}%>
 
        <br>
        <br>
    <table width="70%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
        <td>
            <table width="100%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">

                    <tr>
                        <th> CATEGORIES    </th>

                    </tr>
                 <%
                List<Category> categories = (List<Category>)request.getAttribute("categories");
                    int i=1; //contador de filas
                    int j=1; //contador de columnas
                for(Category category : categories){
                %>
                
                 <tr>
                     <td width="1%" valign="center" align="middle">
                         <a href="category.do?categoryid=<%=category.getId()%>&nom=<%=category.getName()%>">  <%--Aqui se llama al category.do --%>
                            <%=category.getName()%>
                         </a>

                       <br>
                     </td>
                 
                 </tr>
                 
                 <% } %>
                 
            </table>
        </td>
        <td>
            <table width="100%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
                    <tr>
                        <th>             </th>
                        <th>  NAME       </th>
                        <th>  PRICE       </th>
                        <th>  DESCRIPTION </th>
                        <th>             </th>
                    </tr>
                <%
                List<Product> categoriaId = (List<Product>)request.getAttribute("categoriaId");
                    int i1=1; //contador de filas
                    int j1=1; //contador de columnas
                for(Product product : categoriaId){

                  
                %>
                     <tr> <font size="2" face="Verdana">
                         <td width="1%" valign="center" align="middle">
                            <img src="img/products/<%=product.getName()%>.jpg"
                                alt="<%=product.getName()%>" >
                         </td>
                         <td width="1%" valign="center" align="middle">
                             
                             <%=product.getName()%>
                         </td>
                    
                         <td width="1%" valign="center" align="middle">
                            
                             <%=product.getPrice()%>
                         </td>
                         <td width="1%" valign="center" align="middle">
                             
                             <%=product.getDescription()%>
                         </td>
                         <td width="1%" valign="center" align="middle">
                             <form action="neworder.do?categoryid=<%=product.getCategoryid()%>"
                                   method="post">
                                    <input type="hidden" name="idproduct" value="<%=product.getId()%>">
                                    <input type="submit" name="submit" value="add to cart">
                             </form>
                         </td>
                 </font>
                 </tr>
                
               <% }//end for %>
            </table>
        </td>
    </table>
    </body>
</html>
