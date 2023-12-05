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
	href="../../template/createHouse/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link
	href="../../template/createHouse/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="../../template/createHouse/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link
	href="../../template/createHouse/vendor/datepicker/daterangepicker.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="../../template/createHouse/css/main.css" rel="stylesheet"
	media="all">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
		<div class="wrapper wrapper--w790">
			<div class="card card-5">
				<div class="card-heading">
					<h2 class="title">Tạo phòng trọ</h2>
				</div>
				<div class="card-body">
					<form action="../boarding-house" method="POST">
						<input id="idbdh" class="input--style-5" type="text" style="display: none;"
							name="idbdh">
						<div class="form-row">
							<div class="name">Tên phòng</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="name">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Số lượng người ở</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="number_people">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Số chữ điện hiện tại:</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="electricty">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Số chữ nước hiện tại:</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="water">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Giá phòng:</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="price">
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn--radius-2 btn--red" type="submit"
								name="create_room">Tạo phòng</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="../../template/createHouse/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="../../template/createHouse/vendor/select2/select2.min.js"></script>
	<script src="../../template/createHouse/vendor/datepicker/moment.min.js"></script>
	<script
		src="../../template/createHouse/vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="../../template/createHouse/js/global.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var currentURL = window.location.href;
			var url = new URL(currentURL);
			var idbdhParam = url.searchParams.get("idbdh");
			$('#idbdh').val(idbdhParam).attr('value', idbdhParam);
		});
	</script>
</body>
</html>