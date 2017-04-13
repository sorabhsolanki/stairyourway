<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Stair Your Way</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/animate.min.css" rel="stylesheet">
    <link href="resources/css/lightbox.css" rel="stylesheet">
	<link href="resources/css/main.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
	    <script src="resources/js/html5shiv.js"></script>
	    <script src="resources/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resources/images/ico/apple-touch-icon-57-precomposed.png">

    <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/lightbox.min.js"></script>

        <script type="text/javascript" src="resources/js/wow.min.js"></script>
        <script type="text/javascript" src="resources/js/main.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type='text/javascript'>
	$(document).ready(function() {

		$("#signup").click(function() {
                $(location).attr('href', '${pageContext.request.contextPath}/signup');
            });

        $("#logout").click(function() {
               $(location).attr('href', '${pageContext.request.contextPath}/logout')
        });

        $("#signin").click(function() {
                $(location).attr('href', '${pageContext.request.contextPath}/signin');
        });

	});
</script>


</head><!--/head-->

<body>
	<header id="header">      
        
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="index.html">
                    	<h1><img src="resources/images/logo.png" alt="logo"></h1>
                    </a>
                    
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">${requestScope.user}</li>
                                          
                    </ul>
                </div>
                <div class="search">
                    <form role="form">
                       <c:if test="${requestScope.user != 'Unknown'}">
                        <a href="#" id="logout">logout</a>
                       </c:if>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <!--/#header-->

    <section id="home-slider">
        <div class="container">
            <div class="main-slider">
                <div class="slide-text" id="slide-text">
                    <h1>Stair Your Way</h1>
                    <p>Stair climbing is a unique form of exercise that can have a powerful and positive impact on your health over time.</p>
                    <a href="#" id="signup" class="btn btn-common">SIGN UP</a>
                    <a href="#" id="signin" class="btn btn-common">SIGN IN</a>
                   <h1>Top 10 climbers of the day</h1>
                </div>

                <img src="resources/images/home/slider/slide1/house.png" class="img-responsive slider-house" alt="slider image">
                <img src="resources/images/home/slider/slide1/circle1.png" class="slider-circle1" alt="slider image">
                <img src="resources/images/home/slider/slide1/circle2.png" class="slider-circle2" alt="slider image">
                <img src="resources/images/home/slider/slide1/cloud1.png" class="slider-cloud1" alt="slider image">
                <img src="resources/images/home/slider/slide1/cloud2.png" class="slider-cloud2" alt="slider image">
                <img src="resources/images/home/slider/slide1/cloud3.png" class="slider-cloud3" alt="slider image">
                <img src="resources/images/home/slider/slide1/sun.png" class="slider-sun" alt="slider image">
                <img src="resources/images/home/cycle.png" class="slider-cycle" alt="">
            </div>
        </div>
        <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
    </section>
    <!--/#home-slider-->

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>


                </div>
                <div class="row">
                <div class="col-sm-4 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
                </div>
                <div class="row">
                <div class="col-sm-4 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
 <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>tau</h2>
                    </div>
                </div>
                </div>

            </div>
        </div>
    </section>
    <!--/#services-->

    
    <!--/#action-->

    
     <!--/#features-->

    <section id="clients">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="clients text-center wow fadeInUp" data-wow-duration="500ms" data-wow-delay="300ms">
                        <p><img src="resources/images/home/clients.png" class="img-responsive" alt=""></p>
                        <h1 class="title">How many floors you go up or came down by stairs</h1>
                        <p></p>
                    </div>
                    <div class="clients-logo wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">

                        <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number6.png" class="img-responsive" alt="">
                        <P><a href="#" class="btn btn-common">Up stairs.</a></P></a>
                        </div>
                        <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number5.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Up stairs.</a></P></a>
                        </div>
                         <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number4.png" class="img-responsive" alt="">
                            <P><a href="#" class="btn btn-common">Up stairs.</a></P></a>
                        </div>
<div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number3.png" class="img-responsive" alt="">
                        <P><a href="#" class="btn btn-common">Up stairs.</a></P></a>
                        </div>
                        <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number2.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Up stairs.</a></P></a>
                        </div>
                         <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number1.png" class="img-responsive" alt="">
                            <P><a href="#" class="btn btn-common">Up stairs.</a></P></a>
                        </div>

<div class="col-xs-3 col-sm-2">

                            <a href="#"><img src="resources/images/home/number6.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Down stairs.</a></P></a>
                        </div>
                        <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number5.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Down stairs.</a></P></a></a>
                        </div>
                         <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number4.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Down stairs.</a></P></a></a>
                        </div>
 <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number3.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Down stairs.</a></P></a></a>
                        </div>
 <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number2.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Down stairs.</a></P></a></a>
                        </div>
 <div class="col-xs-3 col-sm-2">
                            <a href="#"><img src="resources/images/home/number1.png" class="img-responsive" alt="">
                           <P><a href="#" class="btn btn-common">Down stairs.</a></P></a></a>
                        </div>

                        

                    </div>
                </div>
            </div>
        </div>
     </section>
    <!--/#clients-->

    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="resources/images/home/under.png" class="img-responsive inline" alt="">
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="testimonial bottom">
                        <h2>Testimonial</h2>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="resources/images/home/profile1.png" alt=""></a>
                            </div>
                            <div class="media-body">
                                <blockquote>Nisi commodo bresaola, leberkas venison eiusmod bacon occaecat labore tail.</blockquote>
                                <h3><a href="#">- Jhon Kalis</a></h3>
                            </div>
                         </div>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="resources/images/home/profile2.png" alt=""></a>
                            </div>
                            <div class="media-body">
                                <blockquote>Capicola nisi flank sed minim sunt aliqua rump pancetta leberkas venison eiusmod.</blockquote>
                                <h3><a href="">- Abraham Josef</a></h3>
                            </div>
                        </div>   
                    </div> 
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="contact-info bottom">
                        <h2>Contacts</h2>
                        <address>
                        E-mail: <a href="mailto:someone@example.com">email@email.com</a> <br> 
                        Phone: +1 (123) 456 7890 <br> 
                        Fax: +1 (123) 456 7891 <br> 
                        </address>

                        <h2>Address</h2>
                        <address>
                        Unit C2, St.Vincent's Trading Est., <br> 
                        Feeder Road, <br> 
                        Bristol, BS2 0UY <br> 
                        United Kingdom <br> 
                        </address>
                    </div>
                </div>
                <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
                        <h2>Send a message</h2>
                        <form id="main-contact-form" name="contact-form" method="post" action="sendemail.php">
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" required="required" placeholder="Email Id">
                            </div>
                            <div class="form-group">
                                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your text here"></textarea>
                            </div>                        
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-submit" value="Submit">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="copyright-text text-center">
                        <p>&copy; Stair your way 2017. Reserved.</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/#footer-->

</body>
</html>
