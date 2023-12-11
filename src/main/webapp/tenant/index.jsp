<%@page import="model.bean.User"%>
<%@page import="model.bean.BoardingHouse"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- theme meta -->
<meta name="theme-name" content="quixlab" />

<title>Manager For Tenant</title>
<!-- Favicon icon -->
<!--  <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png"> -->
<!-- Pignose Calender -->
<link
	href="../template/tenant/plugins/pg-calendar/css/pignose.calendar.min.css"
	rel="stylesheet">
<!-- Chartist -->
<link rel="stylesheet"
	href="../template/tenant/plugins/chartist/css/chartist.min.css">
<link rel="stylesheet"
	href="../template/tenant/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
<!-- Custom Stylesheet -->
<link href="../template/tenant/css/style.css" rel="stylesheet">
<style>
img {
	width: 60px;
}
</style>
</head>
<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none"
					stroke-width="3" stroke-miterlimit="10" />
            </svg>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<div class="brand-logo">
				<a href="index.html"> <b class="logo-abbr"><img
						src="images/logo.png" alt=""> </b> <span class="logo-compact"><img
						src="./images/logo-compact.png" alt=""></span> <span
					class="brand-title"> <img src="images/logo-text.png" alt="">
				</span>
				</a>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<div class="header-content clearfix">

				<div class="nav-control">
					<div class="hamburger">
						<span class="toggle-icon"><i class="icon-menu"></i></span>
					</div>
				</div>
				<div class="header-left">
					<div class="input-group icons">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-transparent border-0 pr-2 pr-sm-3"
								id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
						</div>
						<input type="search" class="form-control"
							placeholder="Search Dashboard" aria-label="Search Dashboard">
						<div class="drop-down animated flipInX d-md-none">
							<form action="#">
								<input type="text" class="form-control" placeholder="Search">
							</form>
						</div>
					</div>
				</div>
				<div class="header-right">
					<ul class="clearfix">
						<li class="icons dropdown"><a href="javascript:void(0)"
							data-toggle="dropdown"> <i class="mdi mdi-email-outline"></i>
								<span class="badge badge-pill gradient-1">3</span>
						</a>
							<div class="drop-down animated fadeIn dropdown-menu">
								<div
									class="dropdown-content-heading d-flex justify-content-between">
									<span class="">3 New Messages</span> <a
										href="javascript:void()" class="d-inline-block"> <span
										class="badge badge-pill gradient-1">3</span>
									</a>
								</div>
								<div class="dropdown-content-body">
									<ul>
										<li class="notification-unread"><a
											href="javascript:void()"> <img
												class="float-left mr-3 avatar-img" src="images/avatar/1.jpg"
												alt="">
												<div class="notification-content">
													<div class="notification-heading">Saiful Islam</div>
													<div class="notification-timestamp">08 Hours ago</div>
													<div class="notification-text">Hi Teddy, Just wanted
														to let you ...</div>
												</div>
										</a></li>
										<li class="notification-unread"><a
											href="javascript:void()"> <img
												class="float-left mr-3 avatar-img" src="images/avatar/2.jpg"
												alt="">
												<div class="notification-content">
													<div class="notification-heading">Adam Smith</div>
													<div class="notification-timestamp">08 Hours ago</div>
													<div class="notification-text">Can you do me a
														favour?</div>
												</div>
										</a></li>
										<li><a href="javascript:void()"> <img
												class="float-left mr-3 avatar-img" src="images/avatar/3.jpg"
												alt="">
												<div class="notification-content">
													<div class="notification-heading">Barak Obama</div>
													<div class="notification-timestamp">08 Hours ago</div>
													<div class="notification-text">Hi Teddy, Just wanted
														to let you ...</div>
												</div>
										</a></li>
										<li><a href="javascript:void()"> <img
												class="float-left mr-3 avatar-img" src="images/avatar/4.jpg"
												alt="">
												<div class="notification-content">
													<div class="notification-heading">Hilari Clinton</div>
													<div class="notification-timestamp">08 Hours ago</div>
													<div class="notification-text">Hello</div>
												</div>
										</a></li>
									</ul>

								</div>
							</div></li>
						<li class="icons dropdown"><a href="javascript:void(0)"
							data-toggle="dropdown"> <i class="mdi mdi-bell-outline"></i>
								<span class="badge badge-pill gradient-2">3</span>
						</a>
							<div
								class="drop-down animated fadeIn dropdown-menu dropdown-notfication">
								<div
									class="dropdown-content-heading d-flex justify-content-between">
									<span class="">2 New Notifications</span> <a
										href="javascript:void()" class="d-inline-block"> <span
										class="badge badge-pill gradient-2">5</span>
									</a>
								</div>
								<div class="dropdown-content-body">
									<ul>
										<li><a href="javascript:void()"> <span
												class="mr-3 avatar-icon bg-success-lighten-2"><i
													class="icon-present"></i></span>
												<div class="notification-content">
													<h6 class="notification-heading">Events near you</h6>
													<span class="notification-text">Within next 5 days</span>
												</div>
										</a></li>
										<li><a href="javascript:void()"> <span
												class="mr-3 avatar-icon bg-danger-lighten-2"><i
													class="icon-present"></i></span>
												<div class="notification-content">
													<h6 class="notification-heading">Event Started</h6>
													<span class="notification-text">One hour ago</span>
												</div>
										</a></li>
										<li><a href="javascript:void()"> <span
												class="mr-3 avatar-icon bg-success-lighten-2"><i
													class="icon-present"></i></span>
												<div class="notification-content">
													<h6 class="notification-heading">Event Ended
														Successfully</h6>
													<span class="notification-text">One hour ago</span>
												</div>
										</a></li>
										<li><a href="javascript:void()"> <span
												class="mr-3 avatar-icon bg-danger-lighten-2"><i
													class="icon-present"></i></span>
												<div class="notification-content">
													<h6 class="notification-heading">Events to Join</h6>
													<span class="notification-text">After two days</span>
												</div>
										</a></li>
									</ul>

								</div>
							</div></li>
						<li class="icons dropdown d-none d-md-flex"><a
							href="javascript:void(0)" class="log-user" data-toggle="dropdown">
								<span>English</span> <i class="fa fa-angle-down f-s-14"
								aria-hidden="true"></i>
						</a>
							<div
								class="drop-down dropdown-language animated fadeIn  dropdown-menu">
								<div class="dropdown-content-body">
									<ul>
										<li><a href="javascript:void()">English</a></li>
										<li><a href="javascript:void()">Dutch</a></li>
									</ul>
								</div>
							</div></li>
						<%
						User user = (User) request.getSession().getAttribute("user");
						%>
						<li class="icons dropdown">
							<div class="user-img c-pointer position-relative"
								data-toggle="dropdown">

								<h5><%=user.getFullName()%></h5>
							</div>
							<div
								class="drop-down dropdown-profile animated fadeIn dropdown-menu">
								<div class="dropdown-content-body">
									<ul>
										<li><a href="app-profile.html"><i class="icon-user"></i>
												<span>Profile</span></a></li>
										<li><a href="javascript:void()"> <i
												class="icon-envelope-open"></i> <span>Inbox</span>
												<div class="badge gradient-3 badge-pill gradient-1">3</div>
										</a></li>

										<hr class="my-2">
										<li><a href="page-lock.html"><i class="icon-lock"></i>
												<span>Lock Screen</span></a></li>
										<li><a href="../user/logout"><i class="icon-key"></i>
												<span>Logout</span></a></li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<div class="nk-sidebar">
			<div class="nk-nav-scroll">
				<ul class="metismenu" id="menu">
					<li class="nav-label">View Boarding House</li>
					<li><a class="has-arrow" href="../tenant/boarding-house"
						aria-expanded="false"> <i class="icon-speedometer menu-icon"></i><span
							class="nav-text">Boarding House</span>
					</a></li>
					<li><a class="has-arrow"
						href="../tenant/room?view_invoice=<%=user.getEmail() %>"
						aria-expanded="false"> <i class="icon-speedometer menu-icon"></i><span
							class="nav-text">View Invoice</span>
					</a></li>
				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<%
		List<BoardingHouse> boardingHouses = (List<BoardingHouse>) request.getAttribute("boardingHouses");
		%>
		<div class="content-body">

			<div class="row">
				<div class="col-lg-3 col-sm-6">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img
									src="https://icons.iconarchive.com/icons/paomedia/small-n-flat/256/house-icon.png"
									class="rounded-circle" alt="">
								<h5 class="mt-3 mb-1"><%=user.getFullName()%></h5>
								<p class="m-0">TENANT</p>
								<!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">

				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<div class="active-member">
								<div class="table-responsive">
									<h4 class="card-title">List Boarding House is rented</h4>
									<table class="table table-xs mb-0">
										<thead>
											<tr>
												<th>Name</th>
												<th>Address</th>
												<th>Electricity unit price</th>
												<th>Water unit price</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<%
												for (int i = 0; i < boardingHouses.size(); i++) {
												%>
												<td><img
													src="https://coffective.com/wp-content/uploads/2018/06/icon-house-blue.png"
													class=" rounded-circle mr-3" alt=""><%=boardingHouses.get(i).getName()%></td>
												<td><%=boardingHouses.get(i).getAddress()%></td>
												<td><span><%=boardingHouses.get(i).getElectricityUnitPrice()%></span>
												</td>
												<td><span><%=boardingHouses.get(i).getWaterUnitPrice()%></span>
												</td>
												<td><a href="../tenant/room"><i
														class="fa fa-circle-o text-success  mr-2"></i> View Room </a></td>
												<%
												}
												%>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-3 col-sm-6">
					<div class="card">
						<div class="social-graph-wrapper widget-facebook">
							<span class="s-icon"><i class="fa fa-facebook"></i></span>
						</div>
						<div class="row">
							<div class="col-6 border-right">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">89k</h4>
									<p class="m-0">Friends</p>
								</div>
							</div>
							<div class="col-6">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">119k</h4>
									<p class="m-0">Followers</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<div class="card">
						<div class="social-graph-wrapper widget-linkedin">
							<span class="s-icon"><i class="fa fa-linkedin"></i></span>
						</div>
						<div class="row">
							<div class="col-6 border-right">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">89k</h4>
									<p class="m-0">Friends</p>
								</div>
							</div>
							<div class="col-6">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">119k</h4>
									<p class="m-0">Followers</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<div class="card">
						<div class="social-graph-wrapper widget-googleplus">
							<span class="s-icon"><i class="fa fa-google-plus"></i></span>
						</div>
						<div class="row">
							<div class="col-6 border-right">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">89k</h4>
									<p class="m-0">Friends</p>
								</div>
							</div>
							<div class="col-6">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">119k</h4>
									<p class="m-0">Followers</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6">
					<div class="card">
						<div class="social-graph-wrapper widget-twitter">
							<span class="s-icon"><i class="fa fa-twitter"></i></span>
						</div>
						<div class="row">
							<div class="col-6 border-right">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">89k</h4>
									<p class="m-0">Friends</p>
								</div>
							</div>
							<div class="col-6">
								<div class="pt-3 pb-3 pl-0 pr-0 text-center">
									<h4 class="m-1">119k</h4>
									<p class="m-0">Followers</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- #/ container -->
	</div>
	</div>
	<script src="../template/tenant/plugins/common/common.min.js"></script>
	<script src="../template/tenant/js/custom.min.js"></script>
	<script src="../template/tenant/js/settings.js"></script>
	<script src="../template/tenant/js/gleek.js"></script>
	<script src="../template/tenant/js/styleSwitcher.js"></script>

	<!-- Chartjs -->
	<script src="../template/tenant/plugins/chart.js/Chart.bundle.min.js"></script>
	<!-- Circle progress -->
	<script
		src="../template/tenant/plugins/circle-progress/circle-progress.min.js"></script>
	<!-- Datamap -->
	<script src="../template/tenant/plugins/d3v3/index.js"></script>
	<script src="../template/tenant/plugins/topojson/topojson.min.js"></script>
	<script src="../template/tenant/plugins/datamaps/datamaps.world.min.js"></script>
	<!-- Morrisjs -->
	<script src="../template/tenant/plugins/raphael/raphael.min.js"></script>
	<script src="../template/tenant/plugins/morris/morris.min.js"></script>
	<!-- Pignose Calender -->
	<script src="../template/tenant/plugins/moment/moment.min.js"></script>
	<script
		src="../template/tenant/plugins/pg-calendar/js/pignose.calendar.min.js"></script>
	<!-- ChartistJS -->
	<script src="../template/tenant/plugins/chartist/js/chartist.min.js"></script>
	<script
		src="../template/tenant/plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>



	<script src="../template/tenant/js/dashboard/dashboard-1.js"></script>

</body>
</html>