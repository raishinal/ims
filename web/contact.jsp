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

		<title>IMS Contact</title>

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
                <!--ggogle map integration-->
                <style type="text/css">
                    div#map_itn{
                        width:100%;
                        height:360px;
                        background-color: #00733e; 
                    }
                </style>
                <script async defer
                        src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA0JebYH5mqE9fJu4dpjjk1Ly63sE4QE4c&callback=loadMap">
                            </script>
                            <script type="text/javascript">
                                function loadMap(){
                                    var latlng=new google.maps.LatLng(27.707065,85.322503);
                                    var myOptions={
                                        zoom:15,
                                        center: latlng,
                                        mapTypeId:'terrain'
                                    };
                                    var map=new google.maps.Map(document.getElementById("map_itn"),myOptions);
                                    var marker=new google.maps.Marker({
                                        position: latlng,
                                        map:map,
                                        title:"IT Training Nepal, Putalisadak."
                                    });
                                }
                                </script>

    </head>
    <body onload="loadMap()">

		<!-- Header -->
			 <%@include file="/headerfront.jsp" %>
		<div class="hero-area section">

			<!-- Backgound Image -->
			<div class="bg-image bg-parallax overlay" style="background-image:url(./img/page-background.jpg)"></div>
			<!-- /Backgound Image -->

			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1 text-center">
						<ul class="hero-area-tree">
							<li><a href="index.html">Home</a></li>
							<li>Contact</li>
						</ul>
						<h1 class="white-text">Get In Touch</h1>

					</div>
				</div>
			</div>

		</div>
		<!-- /Hero-area -->

		<!-- Contact -->
		<div id="contact" class="section">

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row">

					<!-- contact form -->
					<div class="col-md-6">
						<div class="contact-form">
							<h4>Send A Message</h4>
                                                        <form action="${pageContext.request.contextPath}/Mailer" method="post">
								<input class="input" type="text" name="name" placeholder="Name">
								<input class="input" type="email" name="email" placeholder="Email">
								<input class="input" type="text" name="subject" placeholder="Subject">
								<textarea class="input" name="message" placeholder="Enter your Message"></textarea>
								<button type="submit" class="main-button icon-button pull-right">Send Message</button>
							</form>
                                                        <span style="color: red">${status1}</span>
                                                        <span style="color: green">${status1}</span>
						</div>
					</div>
					<!-- /contact form -->

					<!-- contact information -->
					<div class="col-md-5 col-md-offset-1">
						<h4>Contact Information</h4>
						<ul class="contact-details">
							<li><i class="fa fa-envelope"></i>ims@gmail.com</li>
							<li><i class="fa fa-phone"></i>00977-01-444110</li>
							<li><i class="fa fa-map-marker"></i>Basanat Marg,Chabhil</li>
						</ul>

						<!-- contact map -->
						<div id="map_itn"></div>
						<!-- /contact map -->

					</div>
					<!-- contact information -->

				</div>
				<!-- /row -->

			</div>
			<!-- /container -->

		</div>
		<!-- /Contact -->

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
