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

		<title>IMS About</title>

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

		<!-- Header -->
			 <%@include file="/headerfront.jsp" %>
		<!-- /Header -->
<div class="hero-area section">

			<!-- Backgound Image -->
			<div class="bg-image bg-parallax overlay" style="background-image:url(./img/page-background.jpg)"></div>
			<!-- /Backgound Image -->

			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1 text-center">
						<ul class="hero-area-tree">
							<li><a href="index.html">Home</a></li>
							<li>Course</li>
						</ul>
						<h1 class="white-text">See Our Courses</h1>

					</div>
				</div>
			</div>

		</div>
		

		<!-- About -->
		<div id="about" class="section">

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row">

				
	<div class="col-md-6">
		<div class="section-header">
			<h2>Courses at IMS</h2>
			<p class="lead">Grab a Course to enhance your skills.</p>
		</div>

		<!-- feature -->
																				<c:forEach items="${courselist}" var="course">
		<div class="feature">
			<i class="feature-icon fa fa-book"></i>
			<div class="feature-content">
				<h4>${course.title} </h4>
				<p>We offer excelent training on this course, price at Rs.${course.price}.
																														It is scheduled to complete in ${course.duration}. </p>
																												<a href="${pageContext.request.contextPath}/Course/Detail?id=${course.id}">Learn more..</a>
			</div>
		</div>
																				</c:forEach>
		<!-- /feature -->


	</div>

	<div class="col-md-6">
		<div class="about-img">
			<img src="./img/about.png" alt="">
		</div>
	</div>

					

				</div>
				<!-- row -->

			</div>
			<!-- container -->
		</div>
		<!-- /About -->

	
		<!-- Contact CTA -->
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
