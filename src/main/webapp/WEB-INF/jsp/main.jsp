<%-- 
    Document   : hello
    Created on : 29 déc. 2018, 14:09:49
    Author     : HP
--%>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

        <link href="${pageContext.request.contextPath}/resources/css/forms.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="elements/header.jsp" %>
    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
                      <%@include file="elements/menu.jsp" %>
		  </div>
		  <div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-6">
	  					<div class="content-box-large">
			  				<div class="panel-heading">
                                                            <div class="panel-title"></div>
					          
					            <div class="panel-options">
                                                            <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
                                                            <a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
                                                        </div>
                                                    </div>
			  				<div class="panel-body">
                                                            <form class="form-horizontal" role="form" action="add" method="POST" enctype="multipart/form-data">
                                                                    <fieldset>
                                                                            <legend>Importer le fichier</legend>

                                                                            <div class="form-group">
                                                                                    <label class="col-md-2 control-label">Fichier</label>
                                                                                    <div class="col-md-10">
                                                                                            <input type="file" class="btn btn-default" name="file" id="fileChoice" value="${file}">
                                                                                            <p class="help-block">
                                                                                                    veuiller choisir un format MP3
                                                                                            </p>
                                                                                    </div>
                                                                            </div>

                                                                    </fieldset>
								  <div class="form-group">
								    <div class="col-sm-offset-2 col-sm-10">
								      <button type="submit" class="btn btn-primary">Ajouter</button>
								    </div>
								  </div>
								</form>
			  				</div>
			  			</div>
	  				</div>
                                </div>
	  		<!--  Page content -->
		  </div>
		</div>
    </div>
    <%@include file="elements/footer.jsp" %>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/resources/ui/external/jquery/jquery.js"></script>
    <!-- jQuery UI -->
    <script src="${pageContext.request.contextPath}/resources/ui/jquery-ui.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/vendors/form-helpers/js/bootstrap-formhelpers.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/vendors/select/bootstrap-select.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/vendors/tags/js/bootstrap-tags.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/vendors/mask/jquery.maskedinput.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/vendors/moment/moment.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/vendors/wizard/jquery.bootstrap.wizard.min.js"></script>

     <!-- bootstrap-datetimepicker -->
     <link href="${pageContext.request.contextPath}/resources/vendors/bootstrap-datetimepicker/datetimepicker.css" rel="stylesheet">
     <script src="${pageContext.request.contextPath}/resources/vendors/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script> 


    <link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet"/>
	<script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/forms.js"></script>
  </body>

</html>
