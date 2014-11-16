package web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import model.CategoryModel;
import model.ProductModel;
import web.*;
import web.action.Action;
import web.action.categoryAction;
import web.action.checkoutAction;
import web.action.clearcartAction;
import web.action.initAction;
import web.action.neworderAction;
import web.action.updatecartAction;
import web.action.viewcartAction;

/*
* En web.xml todas las acciones *.do se asignan al controllerServlet
* El método init () en el ControllerServlet
  crea un HashMap y agrega todos los posibles
  acciones.
* El doPost o doGet identifica y realiza la acción correspondiente.
*/



public class ControllerServlet extends HttpServlet {

    private HashMap actionMap;

    @Override
    public void init() throws ServletException {

        actionMap = new HashMap();  //Tabla de Hash
        ServletContext context = getServletContext();  //ambito aplicacion
        //Todos los .do se llaman desde los JSP
        actionMap.put("/init.do", new initAction((CategoryModel) context.getAttribute("categoryModel")));
        actionMap.put("/category.do", new categoryAction((CategoryModel) context.getAttribute("categoryModel"),(ProductModel) context.getAttribute("productModel")));
        actionMap.put("/neworder.do", new neworderAction((CategoryModel) context.getAttribute("categoryModel"),(ProductModel) context.getAttribute("productModel")));
        actionMap.put("/viewcart.do", new viewcartAction());
        actionMap.put("/updatecart.do", new updatecartAction((ProductModel) context.getAttribute("productModel")));
        actionMap.put("/clearcart.do", new clearcartAction());
        actionMap.put("/checkout.do", new checkoutAction());

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String op = req.getServletPath(); //Path of Servlet is /init.do or ....
        //System.out.println("Path of Servlet is " + req.getServletPath());
        Action action = (Action) actionMap.get(op);//Devuelve el valor de la
        //clave especificada que se asigno en este mapa hash de identidad, o null
        //si el mapa no contiene ninguna asignación para esta clave.
        
        try {
            action.perform(req, resp);  //aqui se ejecuta el metodo PERFORM
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            if (dispatcher != null) {
                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doPost(req, resp);
    }
}