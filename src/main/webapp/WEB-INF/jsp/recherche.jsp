<%-- 
    Document   : recherche
    Created on : 7 janv. 2019, 11:16:43
    Author     : MIORA
--%>

<%@page import="mg.gasytube.model.Chanson"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--        <spring:url value="css/styles.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />-->
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
        <!-- jQuery UI -->
        <link href="${pageContext.request.contextPath}/resources/ui/jquery-ui.css" rel="stylesheet" media="screen">

        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- styles -->
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">

        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/vendors/form-helpers/css/bootstrap-formhelpers.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/vendors/select/bootstrap-select.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/vendors/tags/css/bootstrap-tags.css" rel="stylesheet">
    </head>
    <form action="${pageContext.request.contextPath}/recherche/traitement" method="GET">
        <div class="header">
                    <div class="container">
                       <div class="row">
                          <div class="col-md-5">
                             <!-- Logo -->
                             <div class="logo">
                                <h1><a href="index.html">MDGTube Recherche</a></h1>
                             </div>
                          </div>
                          <div class="col-md-5">
                             <div class="row">
                               <div class="col-lg-12">
                                 <div class="input-group form">
                                      <input type="text" class="form-control" name ="recherche" placeholder="Search...">
                                      <span class="input-group-btn">
                                        <button class="btn btn-primary">Search</button>
                                      </span>
                                 </div>
                               </div>
                             </div>
                          </div>
                       </div>
                    </div>
        </div>
    </form>
    <div class="table-responsive">
    <table class="table">
                <thead>
                    <tr>
                        <th>RefGenre</th>
                        <th>RefAlbum</th>
                        <th>Titre</th>
                        <th>DateSortie</th>
                        <th>Comment</th>
                        <th>Composer</th>
                        <th>Publisher</th>
                        <th>Copyrigth</th>
                        <th>Url</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                       
                        if(request.getAttribute("resultat")!=null)
                        {
                            System.out.println((String)request.getAttribute("mot"));
                            List<Chanson> myMap = (List<Chanson>) request.getAttribute("resultat"); 
                            for(int i = 0;i<myMap.size();i++)
                            {%>

                            <tr>
                                <td><%out.println(myMap.get(i).getRefgenre());%></td>
                                <td><%out.println(myMap.get(i).getRefalbum());%></td>
                                <td><%out.println(myMap.get(i).getTitre());%></td>
                                <td><%out.println(myMap.get(i).getDateSortie());%></td>
                                <td><%out.println(myMap.get(i).getComment());%></td>
                                <td><%out.println(myMap.get(i).getComposer());%></td>
                                <td><%out.println(myMap.get(i).getPublisher());%></td>
                                <td><%out.println(myMap.get(i).getCopyright());%></td>
                                <td><%out.println(myMap.get(i).getUrl());%></td>
                           </tr>
                            <%}
                        }
                    %>
                </tbody>
            </table>
    </div>
    <ul class="pagination pagination-sm">
   <% 
       Long rep  = new Long(0);
       int indicepage  = 0;
       if(request.getAttribute("nbligne")!=null)
       {
           rep =(Long) request.getAttribute("nbligne");
            int j = 1;  
              while(rep>0){%>
                 <li><a href="${pageContext.request.contextPath}/recherche/traitement?recherche=<%=(String)request.getAttribute("mot")%>&indice=<%=indicepage%>"><%out.println(j);%></a></li>
             <%
                rep -=5;
                indicepage +=5;
                j++;
             }
       }
        %>
</ul>
    
    
         
</html>
