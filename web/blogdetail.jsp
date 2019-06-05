<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>HTML Education Template</title>

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

		<!-- Hero-area -->
		<div class="hero-area section">

			<!-- Backgound Image -->
                        <div class="bg-image bg-parallax overlay" style="background-image:url(<c:url value="/img/blog-post-background.jpg"/>)"></div>
			<!-- /Backgound Image -->

			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1 text-center">
						<ul class="hero-area-tree">
							<li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/Blog">Blog</a></li>
							<li>${blogdetail.category}</li>
						</ul>
						<h1 class="white-text">${blogdetail.title}</h1>
						<ul class="blog-post-meta">
							<li class="blog-meta-author">By : <a href="#">${blogdetail.author}</a></li>
							<li>${blogdetail.date}</li>
							<li class="blog-meta-comments"><a href="#"><i class="fa fa-comments"></i> 35</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<!-- /Hero-area -->

		<!-- Blog -->
		<div id="blog" class="section">

			<!-- container -->
			<div class="container">

				<!-- row -->
				<div class="row"><div class="col-md-6">
								<div class="single-blog">
									<div class="blog-img">
                                                                                    <img src="${pageContext.request.contextPath}/blogimage/${blogdetail.image}" alt="blog image">
                                                                                    
									</div>
									
								</div>
							</div>
					<!-- main blog -->
					<div id="main" class="col-md-9">
                                           
						<!-- blog post -->
						<div class="blog-post">
                                                    <p>${blogdetail.article}</p>
							</div>
						<!-- /blog post -->

						<!-- blog share -->
						<div class="blog-share">
							<h4>Share This Post:</h4>
							<a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
							<a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
							<a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
						</div>
						<!-- /blog share -->

						<!-- blog comments -->
						<div class="blog-comments">
							<h3>5 Comments</h3>

							<!-- single comment -->
							<div class="media">
								<div class="media-left">
									<img src="./img/avatar.png" alt="">
								</div>
								<div class="media-body">
									<h4 class="media-heading">John Doe</h4>
									<p>Cu his iudico appareat ullamcorper, at mea ignota nostrum. Nonumy argumentum id cum, eos adversarium contentiones id</p>
									<div class="date-reply"><span>Oct 18, 2017 - 4:00AM</span><a href="#" class="reply">Reply</a></div>
								</div>

								<!-- comment reply -->
								<div class="media">
									<div class="media-left">
										<img src="./img/avatar.png" alt="">
									</div>
									<div class="media-body">
										<h4 class="media-heading">John Doe</h4>
										<p>Cu his iudico appareat ullamcorper, at mea ignota nostrum. Nonumy argumentum id cum, eos adversarium contentiones id</p>
										<div class="date-reply"><span>Oct 18, 2017 - 4:00AM</span><a href="#" class="reply">Reply</a></div>
									</div>
								</div>
								<!-- /comment reply -->

								<!-- comment reply -->
								<div class="media">
									<div class="media-left">
										<img src="./img/avatar.png" alt="">
									</div>
									<div class="media-body">
										<h4 class="media-heading">John Doe</h4>
										<p>Cu his iudico appareat ullamcorper, at mea ignota nostrum. Nonumy argumentum id cum, eos adversarium contentiones id</p>
										<div class="date-reply"><span>Oct 18, 2017 - 4:00AM</span><a href="#" class="reply">Reply</a></div>
									</div>
								</div>
								<!-- /comment reply -->

							</div>
							<!-- /single comment -->

							<!-- single comment -->
							<div class="media">
								<div class="media-left">
									<img src="./img/avatar.png" alt="">
								</div>
								<div class="media-body">
									<h4 class="media-heading">John Doe</h4>
									<p>Cu his iudico appareat ullamcorper, at mea ignota nostrum. Nonumy argumentum id cum, eos adversarium contentiones id</p>
									<div class="date-reply"><span>Oct 18, 2017 - 4:00AM</span><a href="#" class="reply">Reply</a></div>
								</div>
							</div>
							<!-- /single comment -->

							<!-- blog reply form -->
							<div class="blog-reply-form">
								<h3>Leave Comment</h3>
								<form>
									<input class="input name-input" type="text" name="name" placeholder="Name">
									<input class="input email-input" type="email" name="email" placeholder="Email">
									<textarea class="input" name="message" placeholder="Enter your Message"></textarea>
									<button class="main-button icon-button">Submit</button>
								</form>
							</div>
							<!-- /blog reply form -->

						</div>
						<!-- /blog comments -->
					</div>
					<!-- /main blog -->

					
				</div>
				<!-- row -->

			</div>
			<!-- container -->

		</div>
		<!-- /Blog -->

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
