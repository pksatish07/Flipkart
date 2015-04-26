<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="bootstrap/css/jquery.bxslider.css">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/jquery.bxslider.min.js"></script>
<style>
.carousel-inner>.item>img,.carousel-inner>.item>a>img {
	width: 100%;
	margin: auto;
}

#ecar {
	width: 50px;
	padding-left: 20px;
}

#glow {
	box-shadow: 8px 8px 8px #888888;
}

#glow:hover {
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0px 0px 20px 0px rgba(255, 153, 0, 0.67);
	-moz-box-shadow: 0px 0px 20px 0px rgba(255, 153, 0, 0.67);
	box-shadow: 0px 0px 20px 0px rgba(255, 153, 0, 0.67);
}
</style>
</head>
<body>

	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-9">
				<div id="myCarousel" class="carousel slide" data-ride="carousel"
					data-interval="5000">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
						<li data-target="#myCarousel" data-slide-to="4"></li>
					</ol>

					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<a
								href="displayProduct?product=Electrolux ET70ENERM 7 kg Fully Automatic"><img
								src="carousel/electrolux.jpg" alt="1" width="660" height="545"></a>
						</div>

						<div class="item">
							<a
								href="displayProduct?product=Google Nexus 6(Midnight Blue, with 32 GB)"><img
								src="carousel/nexus6.jpg" alt="2" width="660" height="545"></a>
						</div>

						<div class="item">
							<a href="displayProduct?product=Lenovo A7000"><img
								src="carousel/lenovoA7000.jpg" alt="3" width="660" height="545"></a>
						</div>

						<div class="item">
							<a href="displayProduct?product=Lumia 640"><img
								src="carousel/lumia640.jpg" alt="4" width="660" height="545"></a>
						</div>
						<div class="item">
							<a href="displayProduct?product=Mi-Pad"><img
								src="carousel/Mi-Tab.jpg" alt="5" width="660" height="545"></a>
						</div>
					</div>

					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>

					</a>
				</div>
			</div>
			<div class="col-md-1">
				<div class="row">
					<a href="displayProduct?product=Lenovo Yoga 2 Tablet"><img
						src="ads/lenovo-yoga.png" height="100" id="glow"></a>
				</div>
				<br>
				<br>
				<div class="row">
					<a href="displayProduct?product=Lenovo A6000"><img
						src="ads/lenovoa6000.jpg" height="100" id="glow"></a>
				</div>
				<br>
				<br>
				<div class="row">
					<a href="displayProduct?product=Moto E(2nd Gen)"><img
						src="ads/motooffer.png" height="100" id="glow"></a>
				</div>
				<br>
				<br>
			</div>

		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading"
						style="background-color: black; height: 50px;">
						<div class="pull-left">
							<p style="color: white;">ELECTRONICS</p>
						</div>
						<div class="pull-right">
							<label style="color: white;">India's leading Electronics
								Megastore</label>
						</div>
					</div>


					<div class="panel-body"
						style="background-color: white; height: 160px;">

						<div id="eCarousel" class="carousel slide" data-ride="carousel"
							data-interval="false">


							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<div class="row">
										<div class="col-sm-3">
											<a href="displayProduct?product=Televisions"
												class="thumbnail"><img src="homepage/tv.jpg" alt="1"
												height="100" width="100" class="img-responsive"
												title="Televisions"></a>
										</div>
										<div class="col-sm-3">
											<a href="displayProduct?product=Tablets" class="thumbnail"><img
												src="homepage/tablets.jpg" height="100" width="100" alt="2"
												class="img-responsive" title="Tablets"></a>
										</div>
										<div class="col-sm-3">
											<a href="#" class="thumbnail"><img
												src="homepage/camera.jpg" height="100" width="100" alt="2"
												class="img-responsive" title="Cameras"></a>
										</div>
										<div class="col-sm-3">
											<a href="#" class="thumbnail"><img
												src="homepage/mobile_accessories.jpg" height="100"
												width="100" alt="2" class="img-responsive"
												title="Mobile Accessories"></a>
										</div>
									</div>
								</div>

								<div class="item">
									<div class="row">
										<div class="col-sm-3">
											<a href="#" class="thumbnail"><img
												src="homepage/air_conditioner.png" height="100" width="100"
												alt="2" class="img-responsive" title="Air Conditioners"></a>
										</div>
										<div class="col-sm-3">
											<a href="#" class="thumbnail"><img
												src="homepage/Phone.png" height="100" width="100" alt="2"
												class="img-responsive" title="Phoness"></a>
										</div>
									</div>
								</div>
							</div>

							<a id="ecar" class="left carousel-control" href="#eCarousel"
								role="button" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							</a> <a id="ecar" class="right carousel-control" href="#eCarousel"
								role="button" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>

							</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default" style="padding-top: 0px;">
					<div class="panel-heading"></div>
					<div class="panel-body"
						style="background-color: white; height: 360px;">

						<div class="col-md-3">
							<a href="" id="ecaroffers"><img src="homepage/headphone.jpg"
								class="img-responsive" id="glow" /></a>
						</div>
						<div class="col-md-6">
							<a href="displayProduct?product=Televisions" id="ecaroffers"><img
								src="homepage/tvoffer.jpg" class="img-responsive" id="glow" /></a>
						</div>
						<div class="col-md-3">
							<a href="" id="ecaroffers"><img src="homepage/redmi2.jpg"
								class="img-responsive" id="glow" /></a>
						</div>

					</div>
				</div>
				<div class="panel panel-default" style="padding-top: 0px;">
					<div class="panel-heading" style="height: 50px;">
						<div class="col-md-2">
							<p class="lead">
								<b>BESTSELLERS</b>
							</p>
						</div>
					</div>
					<div class="panel-body"
						style="background-color: white; height: 240px;">

						<div id="eBestCarousel" class="carousel slide"
							data-ride="carousel" data-interval="false">


							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<div class="row">
										<div class="col-sm-3">
											<a href="getproductAction?pid=1"><img width="70"
												height="70" class="img-responsive center-block"
												src="imageAction?productId=1" / style="text-align: center;">
												<br /></a>
											<div align="center">
												<p style="hover: color:black;">Moto E(2nd Gen)</p>
											</div>
											<div align="center">Price:6,999</div>
										</div>
										<div class="col-sm-3">
											<a href="getproductAction?pid=7"><img width="70"
												height="70" class="img-responsive center-block"
												src="imageAction?productId=7" / style="text-align: center;">
												<br /></a>
											<div align="center">
												<p style="hover: color:black;">Apple iPhone 6</p>
											</div>
											<div align="center">Price:61,000</div>
										</div>
										<div class="col-sm-3">
											<a href="getproductAction?pid=6"><img width="70"
												height="70" class="img-responsive center-block"
												src="imageAction?productId=6" / style="text-align: center;">
												<br /></a>
											<div align="center">
												<p style="hover: color:black;">Lenovo A6000</p>
											</div>
											<div align="center">Price:6,999</div>
										</div>
										<div class="col-sm-3">
											<a href="getproductAction?pid=27"><img width="70"
												height="70" class="img-responsive center-block"
												src="imageAction?productId=27" / style="text-align: center;">
												<br /></a>
											<div align="center">
												<p style="hover: color:black;">Ishin Printed Fashion Cotton Sari</p>
											</div>
											<div align="center">Price:1,299</div>
										</div>
									</div>
								</div>

								<div class="item">
									<div class="row">
										<div class="col-sm-3">
											<a href="getproductAction?pid=39"><img width="70"
												height="70" class="img-responsive center-block"
												src="imageAction?productId=39" / style="text-align: center;">
												<br /></a>
											<div align="center">
												<p style="hover: color:black;">Mi-Pad</p>
											</div>
											<div align="center">Price:12,999</div>
										</div>
										<div class="col-sm-3">
											<a href="getproductAction?pid=14"><img width="70"
												height="70" class="img-responsive center-block"
												src="imageAction?productId=14" / style="text-align: center;">
												<br /></a>
											<div align="center">
												<p style="hover: color:black;">Nike Super 123 Printed Men's Round Neck T-Shirt</p>
											</div>
											<div align="center">Price:1,830</div>
										</div>
									</div>
								</div>
							</div>

							<a id="ecar" class="left carousel-control" href="#eBestCarousel"
								role="button" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							</a> <a id="ecar" class="right carousel-control"
								href="#eBestCarousel" role="button" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>

							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
