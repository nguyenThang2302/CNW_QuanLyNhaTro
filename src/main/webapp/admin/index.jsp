<%@page import="model.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Focus - Bootstrap Admin Dashboard</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="../template/admin/images/favicon.png">
<!-- Custom Stylesheet -->
<link href="../template/admin/css/style.css" rel="stylesheet">

</head>

<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="sk-three-bounce">
			<div class="sk-child sk-bounce1"></div>
			<div class="sk-child sk-bounce2"></div>
			<div class="sk-child sk-bounce3"></div>
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
			<a href="index" class="brand-logo"> <img class="logo-abbr"
				src="../template/admin/images/logo.png" alt=""> <img class="logo-compact"
				src="../template/admin/images/logo-text.png" alt=""> <img class="brand-title"
				src="../template/admin/images/logo-text.png" alt="">
			</a>

			<div class="nav-control">
				<div class="hamburger">
					<span class="line"></span><span class="line"></span><span
						class="line"></span>
				</div>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<div class="header-content">
				<nav class="navbar navbar-expand">
					<div class="collapse navbar-collapse justify-content-between">
						<div class="header-left">
							<div class="search_bar dropdown">
								<span class="search_icon p-3 c-pointer" data-toggle="dropdown">
									<i class="mdi mdi-magnify"></i>
								</span>
								<div class="dropdown-menu p-0 m-0">
									<form>
										<input class="form-control" type="search" placeholder="Search"
											aria-label="Search">
									</form>
								</div>
							</div>
						</div>

						<ul class="navbar-nav header-right">
							<li class="nav-item dropdown notification_dropdown"><a
								class="nav-link" href="#" role="button" data-toggle="dropdown">
									<i class="mdi mdi-bell"></i>
									<div class="pulse-css"></div>
							</a>
								<div class="dropdown-menu dropdown-menu-right">
									<ul class="list-unstyled">
										<li class="media dropdown-item"><span class="success"><i
												class="ti-user"></i></span>
											<div class="media-body">
												<a href="#">
													<p>
														<strong>Martin</strong> has added a <strong>customer</strong>
														Successfully
													</p>
												</a>
											</div> <span class="notify-time">3:20 am</span></li>
										<li class="media dropdown-item"><span class="primary"><i
												class="ti-shopping-cart"></i></span>
											<div class="media-body">
												<a href="#">
													<p>
														<strong>Jennifer</strong> purchased Light Dashboard 2.0.
													</p>
												</a>
											</div> <span class="notify-time">3:20 am</span></li>
										<li class="media dropdown-item"><span class="danger"><i
												class="ti-bookmark"></i></span>
											<div class="media-body">
												<a href="#">
													<p>
														<strong>Robin</strong> marked a <strong>ticket</strong> as
														unsolved.
													</p>
												</a>
											</div> <span class="notify-time">3:20 am</span></li>
										<li class="media dropdown-item"><span class="primary"><i
												class="ti-heart"></i></span>
											<div class="media-body">
												<a href="#">
													<p>
														<strong>David</strong> purchased Light Dashboard 1.0.
													</p>
												</a>
											</div> <span class="notify-time">3:20 am</span></li>
										<li class="media dropdown-item"><span class="success"><i
												class="ti-image"></i></span>
											<div class="media-body">
												<a href="#">
													<p>
														<strong> James.</strong> has added a<strong>customer</strong>
														Successfully
													</p>
												</a>
											</div> <span class="notify-time">3:20 am</span></li>
									</ul>
									<a class="all-notification" href="#">See all notifications
										<i class="ti-arrow-right"></i>
									</a>
								</div></li>
							<li class="nav-item dropdown header-profile"><a
								class="nav-link" href="#" role="button" data-toggle="dropdown">
									<i class="mdi mdi-account"></i>
							</a>
								<div class="dropdown-menu dropdown-menu-right">
									<a href="../template/admin/app-profile.html" class="dropdown-item"> <i
										class="icon-user"></i> <span class="ml-2">Profile </span>
									</a> <a href="../template/admin/email-inbox.html" class="dropdown-item"> <i
										class="icon-envelope-open"></i> <span class="ml-2">Inbox
									</span>
									</a> <a href="../template/admin/page-login.html" class="dropdown-item"> <i
										class="icon-key"></i> <span class="ml-2">Logout </span>
									</a>
								</div></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<div class="quixnav">
			<div class="quixnav-scroll">
				<ul class="metismenu" id="menu">
					<li class="nav-label first">Main Menu</li>
					<!-- <li><a href="index.html"><i class="icon icon-single-04"></i><span class="nav-text">M</span></a>
                    </li> -->
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-single-04"></i><span
							class="nav-text">Manage</span></a>
						<ul aria-expanded="false">
							<li><a href="../admin/list_landlord">Landlord</a></li>
							<li><a href="../admin/list_tenant">Tenant</a></li>
						</ul></li>

					<li class="nav-label">Apps</li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Apps</span></a>
						<ul aria-expanded="false">
							<li><a href="../template/admin/app-profile.html">Profile</a></li>
							<li><a class="has-arrow" href="javascript:void()"
								aria-expanded="false">Email</a>
								<ul aria-expanded="false">
									<li><a href="../template/admin/email-compose.html">Compose</a></li>
									<li><a href="../template/admin/email-inbox.html">Inbox</a></li>
									<li><a href="../template/admin/email-read.html">Read</a></li>
								</ul></li>
							<li><a href="../template/admin/app-calender.html">Calendar</a></li>
						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-chart-bar-33"></i><span
							class="nav-text">Charts</span></a>
						<ul aria-expanded="false">
							<li><a href="../template/admin/chart-flot.html">Flot</a></li>
							<li><a href="../template/admin/chart-morris.html">Morris</a></li>
							<li><a href="../template/admin/chart-chartjs.html">Chartjs</a></li>
							<li><a href="../template/admin/chart-chartist.html">Chartist</a></li>
							<li><a href="../template/admin/chart-sparkline.html">Sparkline</a></li>
							<li><a href="../template/admin/chart-peity.html">Peity</a></li>
						</ul></li>
					<li class="nav-label">Components</li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-world-2"></i><span
							class="nav-text">Bootstrap</span></a>
						<ul aria-expanded="false">
							<li><a href="../template/admin/ui-accordion.html">Accordion</a></li>
							<li><a href="../template/admin/ui-alert.html">Alert</a></li>
							<li><a href="../template/admin/ui-badge.html">Badge</a></li>
							<li><a href="../template/admin/ui-button.html">Button</a></li>
							<li><a href="../template/admin/ui-modal.html">Modal</a></li>
							<li><a href="../template/admin/ui-button-group.html">Button Group</a></li>
							<li><a href="../template/admin/ui-list-group.html">List Group</a></li>
							<li><a href="../template/admin/ui-media-object.html">Media Object</a></li>
							<li><a href="../template/admin/ui-card.html">Cards</a></li>
							<li><a href="../template/admin/ui-carousel.html">Carousel</a></li>
							<li><a href="../template/admin/ui-dropdown.html">Dropdown</a></li>
							<li><a href="../template/admin/ui-popover.html">Popover</a></li>
							<li><a href="../template/admin/ui-progressbar.html">Progressbar</a></li>
							<li><a href="../template/admin/ui-tab.html">Tab</a></li>
							<li><a href="../template/admin/ui-typography.html">Typography</a></li>
							<li><a href="../template/admin/ui-pagination.html">Pagination</a></li>
							<li><a href="../template/admin/ui-grid.html">Grid</a></li>

						</ul></li>

					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-plug"></i><span
							class="nav-text">Plugins</span></a>
						<ul aria-expanded="false">
							<li><a href="../template/admin/uc-select2.html">Select 2</a></li>
							<li><a href="../template/admin/uc-nestable.html">Nestedable</a></li>
							<li><a href="../template/admin/uc-noui-slider.html">Noui Slider</a></li>
							<li><a href="../template/admin/uc-sweetalert.html">Sweet Alert</a></li>
							<li><a href="../template/admin/uc-toastr.html">Toastr</a></li>
							<li><a href="../template/admin/map-jqvmap.html">Jqv Map</a></li>
						</ul></li>
					<li><a href="widget-basic.html" aria-expanded="false"><i
							class="icon icon-globe-2"></i><span class="nav-text">Widget</span></a></li>
					<li class="nav-label">Forms</li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-form"></i><span
							class="nav-text">Forms</span></a>
						<ul aria-expanded="false">
							<li><a href="../template/admin/form-element.html">Form Elements</a></li>
							<li><a href="../template/admin/form-wizard.html">Wizard</a></li>
							<li><a href="../template/admin/form-editor-summernote.html">Summernote</a></li>
							<li><a href="form-pickers.html">Pickers</a></li>
							<li><a href="form-validation-jquery.html">Jquery
									Validate</a></li>
						</ul></li>
					<li class="nav-label">Table</li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-layout-25"></i><span
							class="nav-text">Table</span></a>
						<ul aria-expanded="false">
							<li><a href="table-bootstrap-basic.html">Bootstrap</a></li>
							<li><a href="table-datatable-basic.html">Datatable</a></li>
						</ul></li>

					<li class="nav-label">Extra</li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-single-copy-06"></i><span
							class="nav-text">Pages</span></a>
						<ul aria-expanded="false">
							<li><a href="../template/admin/page-register.html">Register</a></li>
							<li><a href="../template/admin/page-login.html">Login</a></li>
							<li><a class="has-arrow" href="javascript:void()"
								aria-expanded="false">Error</a>
								<ul aria-expanded="false">
									<li><a href="../template/admin/page-error-400.html">Error 400</a></li>
									<li><a href="../template/admin/page-error-403.html">Error 403</a></li>
									<li><a href="../template/admin/page-error-404.html">Error 404</a></li>
									<li><a href="../template/admin/page-error-500.html">Error 500</a></li>
									<li><a href="../template/admin/page-error-503.html">Error 503</a></li>
								</ul></li>
							<li><a href="../template/admin/page-lock-screen.html">Lock Screen</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">
			<div class="container-fluid">
				<div class="row page-titles mx-0">
					<div class="col-sm-6 p-md-0">
						<div class="welcome-text">
							<h4>Hi, welcome back!</h4>
							<p class="mb-0">Your business dashboard template</p>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Table</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Bootstrap</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Basic</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-responsive-sm">
										<thead>
											<tr>
												<th class="black_color">ID</th>
												<th class="black_color">Full Name</th>
												<th class="black_color">Email</th>
												<th class="black_color">Address</th>
												<th class="black_color">Status</th>
												<th class="black_color">Action</th>

											</tr>
										</thead>
										<tbody>
											<%
											List<User> users = (List<User>) request.getAttribute("users");
											for (int i = 0; i < users.size(); i++) {
											%>
											<tr>
												<th class="black_color"><%=users.get(i).getId()%> </th>
												<td class="black_color"><%=users.get(i).getFullName()%></td>
												<td class="black_color"><%=users.get(i).getEmail()%></td>
												<td class="black_color"><%=users.get(i).getAddress()%></td>
												<td class="black_color"><span class="badge badge-success form-select"><%=users.get(i).getRole()%></span></td>
												<td class="black_color"><a class="btn btn-primary"
													href="update?email=<%=users.get(i).getEmail()%>">Update</a>
											</tr>
											<%
											}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--**********************************
            Content body end
        ***********************************-->


		<!--**********************************
            Footer start
        ***********************************-->
		<div class="footer">
			<div class="copyright">
				<p>
					Copyright � Designed &amp; Developed by <a href="#" target="_blank">Quixkit</a>
					2019
				</p>
			</div>
		</div>
		<!--**********************************
            Footer end
        ***********************************-->

		<!--**********************************
           Support ticket button start
        ***********************************-->

		<!--**********************************
           Support ticket button end
        ***********************************-->


	</div>
	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<!-- Required vendors -->
	<script src="../template/admin/vendor/global/global.min.js"></script>
	<script src="../template/admin/js/quixnav-init.js"></script>
	<script src="../template/admin/js/custom.min.js"></script>
</body>

</html>