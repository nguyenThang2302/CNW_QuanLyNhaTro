<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Tạo phòng</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Icons font CSS-->
<link
	href="../template/createHouse/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link
	href="../template/createHouse/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="../template/createHouse/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link
	href="../template/createHouse/vendor/datepicker/daterangepicker.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="../template/createHouse/css/main.css" rel="stylesheet"
	media="all">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
		<div class="wrapper wrapper--w790">
			<div class="card card-5">
				<div class="card-heading">
					<h2 class="title">Tạo hoá đơn</h2>
				</div>
				<div class="card-body">
					<form action="../landlord/boarding-house" method="POST">
						<input id="room_id" class="input--style-5" type="text"
							style="display: none;" name="room_id">
						<div class="form-row">
							<div class="name">Additional Cost</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="number"
										name="additionalCost">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Room Cost</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="number" name="roomCost">
								</div>
							</div>
						</div>
						
						<div class="form-row">
							<div class="name">Status</div>
							<div class="value">
								<div class="input-group">
									<select class="input--style-5" name="status">
										<option>DEBT</option>
										<option>PAID</option>

									</select>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Current Electric Meter</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="number"
										name="currentElectricMeter">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Current Water Meter</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="number"
										name="currentWaterMeter">
								</div>
							</div>
						</div>
						
						<div>
							<button class="btn btn--radius-2 btn--red" type="submit"
								name="createInvoice">Tạo hoá đơn</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="../template/createHouse/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="../template/createHouse/vendor/select2/select2.min.js"></script>
	<script src="../template/createHouse/vendor/datepicker/moment.min.js"></script>
	<script
		src="../template/createHouse/vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="../template/createHouse/js/global.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(document).ready(function() {
				var currentURL = window.location.href;
				var url = new URL(currentURL);
				var idbdhParam = url.searchParams.get("add_new_invoice");
				$('#room_id').val(idbdhParam).attr('value', idbdhParam);
			});
		});
	</script>
</body>
</html>