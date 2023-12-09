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
<title>Admin</title>
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

					
				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
        <%User user=(User)request.getSession().getAttribute("user"); %> 
		<div class="content-body">
			<div class="container-fluid">
				<div class="row page-titles mx-0">
					<div class="col-sm-6 p-md-0">
						<div class="welcome-text">
							<h4>Hi, <%=user.getFullName() %></h4>
							<p class="mb-0">Your business</p>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Table</a></li>
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
					Copyright © Designed &amp; Developed by <a href="#" target="_blank">Quixkit</a>
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