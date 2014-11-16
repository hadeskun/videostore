<%@ page import="entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page session='true'%>

    <head>
        <meta http-equiv="Expires" CONTENT="0">
        <meta http-equiv="Cache-Control" CONTENT="no-cache">
        <meta http-equiv="Pragma" CONTENT="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Store movies</title>
    </head>
    
    <body>

        <h2>Welcome to the online home of the movies</h2>

        <h3> Our unique home delivery service brings you the best quality of movies. </h3>


    <table width="10%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">

        
       
        <%
        List<Category> categories = (List<Category>)request.getAttribute("categories");
            int i=1; //contador de filas
            int j=1; //contador de columnas
        for(Category category : categories){

            if(i==1){
        %>
             <tr> <font size="2" face="Verdana">
                 <td width="1%" valign="center" align="middle">
                   <a href="category.do?categoryid=<%=category.getId()%>&nom=<%=category.getName()%>">
                   <img src="img/categories/<%=category.getName()%>.jpg"
                     alt="<%=category.getName()%>" >
                       <%=category.getName()%>
                   </a>
                 </td>
             <%  i=0;
            }
            else {
                 if(j<=2){
        %>
         <td width="1%" valign="center" align="middle">
            <a href="category.do?categoryid=<%=category.getId()%>&nom=<%=category.getName()%>">
                <img src="img/categories/<%=category.getName()%>.jpg"
                     alt="<%=category.getName()%>" >
                <%=category.getName()%>
            </a>
        </td>
        <% 
           ++j;    }//end if
                 else{
                     j=1; i=1;
          %>
                <td width="1%" valign="center" align="middle">
            <a href="category.do?categoryid=<%=category.getId()%>&nom=<%=category.getName()%>">
                <img src="img/categories/<%=category.getName()%>.jpg"
                     alt="<%=category.getName()%>" >
                <%=category.getName()%>
            </a>
                </td>
         </font>
         </tr>
         <% }//end else %>
        <% }//end else %>
       <% }//end for %>
       
    </table>

    </body>