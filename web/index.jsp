<%-- 
    Document   : index
    Created on : Jul 24, 2018, 12:26:41 PM
    Author     : Raishin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

                 <title>IMS Home</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>

            
            

		 <%@include file="/headerfront.jsp" %>
		<!-- Home -->
		<div id="home" class="hero-area">

			<!-- Backgound Image -->
			<div class="bg-image bg-parallax overlay" style="background-image:url(./img/home-background.jpg)"></div>
			<!-- /Backgound Image -->

			<div class="home-wrapper">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							<h1 class="white-text">Institute Management System</h1>
							<p class="lead white-text">All IT Courses in one place</p>
							<a class="main-button icon-button" href="${pageContext.request.contextPath}/Courses">Get a Course</a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /Home -->

		<!-- About -->
		<div id="about" class="section">

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row">

					<div class="col-md-6">
						<div class="section-header">
							<h2>Welcome to my Institute Management System</h2>
							<p class="lead">all the basics included</p>
						</div>

						<!-- feature -->
						<div class="feature">
							<i class="feature-icon fa fa-flask"></i>
							<div class="feature-content">
								<h4>Online Courses </h4>
								<p>Learn anywhere with more acccebility</p>
							</div>
						</div>
						
						<!-- feature -->
						<div class="feature">
							<i class="feature-icon fa fa-users"></i>
							<div class="feature-content">
								<h4>Expert Teachers</h4>
								<p>We have expert teachers who can share lot of experience</p>
							</div>
						</div>
					
					</div>



					<div class="col-md-6">
						<div class="about-img">
							<img src="./img/about.png" alt="">
						</div>
					</div>

				</div>
                             
                                                                    <div class="col-md-6">
						<div class="section-header">
							<h2>Courses at IMS</h2>
							<p class="lead">Grab a Course to enhance your skills.</p>
						</div>

						<!-- feature -->
                                                <c:forEach items="${coursedata}" var="course">
						<div class="feature">
							<i class="feature-icon fa fa-book"></i>
							<div class="feature-content">
								<h4>${course.title} </h4>
								<p>Duration of ${course.duration}. </p>
                                                               <a href="${pageContext.request.contextPath}/Course/Detail?id=${blog.id}">learn more...</a>
							</div>
						</div>
                                                </c:forEach>
						<!-- /feature -->
                                                                    </div>
				<!-- row -->

			</div>
			<!-- container -->
		</div>
		<!-- /About -->

		<!-- Why us -->
		<div id="why-us" class="section">

			<!-- container -->
			<div class="container">

				
                                <div id="why-us" class="section">

			<!-- container -->
			<div class="container">
				<hr class="section-hr">

				<!-- row -->
				<div class="row">

					<div class="col-md-8">
                                     <iframe width="800vh" height="600vh" src="https://www.youtube.com/embed/sFukyIIM1XI" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
						</div>
<!--recent posts block-->
					<div class="col-md-3 col-md-offset-1">
							<div class="widget posts-widget">
							<h3>Recents Posts</h3>
                                                        <c:forEach items="${blogdata}" var="blog">
                                                            
							<!-- single posts -->
							<div class="single-post">
								<a class="single-post-img" href="${pageContext.request.contextPath}/Blog/Detail?id=${blog.id}">
									<img src="${pageContext.request.contextPath}/blogimage/${blog.image}" alt="blog image">
								</a>
								<a href="${pageContext.request.contextPath}/Blog/Detail?id=${blog.id}">${blog.title}</a>
								<p><small>Date: ${blog.date}</small></p>
							</div>
                                                        </c:forEach>
							<!-- /single posts -->
						</div>
					</div>

				</div>
				<!-- /row -->

			</div>
			<!-- /container -->

		</div>
                        </div>            
                        </div>
                
                
                <div id="contact-cta" class="section">

			<!-- Backgound Image -->
			<div class="bg-image bg-parallax overlay" style="background-image:url(./img/cta2-background.jpg)"></div>
			<!-- Backgound Image -->

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row">

					<div class="col-md-8 col-md-offset-2 text-center">
						<h2 class="white-text">Contact Us</h2>
						<p class="lead white-text">Contact Us for more information or any other questions.</p>
						<a class="main-button icon-button" href="${pageContext.request.contextPath}/Contact">Contact Us Now</a>
					</div>

				</div>
				<!-- /row -->

			</div>
			<!-- /container -->

		</div>
		<!-- /Contact CTA -->

		<!-- Footer -->
		  <%@include file="footerfront.jsp" %>
		<!-- /Footer -->

		<!-- preloader -->
		<div id='preloader'><div class='preloader'></div></div>
		<!-- /preloader -->


		<!-- jQuery Plugins -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>

	</body>
</html>
