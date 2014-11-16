package web.action;

import javax.servlet.http.*;

/*
* Todas las acciones heredan la clase abstracta action
* Cualquier implementacion de "perform" finaliza con:
  ViewManager.nextView(req, resp, "/view/next_view.jsp");
*/

public abstract class Action {

    public abstract void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}