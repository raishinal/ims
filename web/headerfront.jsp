<%-- 
    Document   : headerfront
    Created on : Jun 2, 2019, 1:41:57 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="fb-root"></div>
            
<!--            // for using the social medias we got their site  and get this codes and we can connect directly to those like from our web app.-->
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<!-- Header -->
		<header id="header" class="transparent-nav">
			<div class="container">

				<div class="navbar-header">
                                    <div class="navbar-brand">
						<a class="logo" >
							<img src="${pageContext.request.contextPath}/img/ims-learning-resources-squarelogo.png" alt="logo">
						</a>
					</div>
					<!-- /Logo -->

					<!-- Mobile toggle -->
					<button class="navbar-toggle">
						<span></span>
					</button>
					<!-- /Mobile toggle -->
				</div>

				<!-- Navigation -->
				<nav id="nav">
					<ul class="main-menu nav navbar-nav navbar-right">
						<li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/About">About</a></li>
						<li><a href="${pageContext.request.contextPath}/Courses">Courses</a></li>
						<li><a href="${pageContext.request.contextPath}/Blog">Blog</a></li>
						<li><a href="${pageContext.request.contextPath}/Contact">Contact</a></li>
						<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                                                
                                                
					</ul>
                                                
                                       
                                        
				</nav>
				<!-- /Navigation -->

			</div>
		</header>