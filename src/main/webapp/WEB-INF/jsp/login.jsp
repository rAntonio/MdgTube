<%-- 
    Document   : newjsplogin
    Created on : 29 déc. 2018, 13:18:04
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- styles -->
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
    </head>
    <body class="login-bg">

	<div class="page-content container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			                <h6>Sign In</h6>
			                <div class="social">
                                            <a class="face_login" href="#">
                                                <span class="face_icon">
                                                    <img src="images/facebook.png" alt="fb">
                                                </span>
                                                <span class="text">Sign in with Gmail</span>
                                            </a>
                                            <div class="division">
                                                <hr class="left">
                                                <span>or</span>
                                                <hr class="right">
                                            </div>
                                        </div>
                                        <form action="${pageContext.request.contextPath}/admin/authentification" method="POST">
                                            <input class="form-control" type="text" placeholder="E-mail address" name="username">
                                            <input class="form-control" type="password" placeholder="Password" name="password">
                                            <div class="action">
                                                <button class="btn btn-primary signup" href="/hello">Login</button>
                                            </div>
                                        </form>
			            </div>
			        </div>

			        <div class="already">
			            <p>Don't have an account yet?</p>
			            <a href="signup.html">Sign Up</a>
			        </div>
			    </div>
			</div>
		</div>
	</div>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
  </body>
</html>
