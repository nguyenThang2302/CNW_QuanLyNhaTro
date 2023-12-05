<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css/style.css">

<title>Register</title>
</head>
<body>
	<div class="content">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 contents">
					<div class="row justify-content-center">
						<div class="col-md-12">
							<div class="form-block">
								<div class="mb-4">
									<h3>
										Đăng kí hệ thống <strong>Quản lý nhà trọ</strong>
									</h3>
								</div>
								<form action="RegisterController" method="post" onsubmit="return validateForm()">
									<div class="form-group first">
										<label for="fullname">Full Name</label> <input type="text"
											class="form-control" id="fullname" name="fullname">
									</div>
									<div class="form-group first">
										<label for="address">Address</label> <input type="text"
											class="form-control" id="address" name="address">
									</div>
									<div class="form-group first">
										<label for="email">Email</label> <input type="text"
											class="form-control" id="email" name="email">
									</div>
									<div class="form-group last mb-4">
										<label for="password">Mật khẩu</label> <input type="password"
											class="form-control" id="password" name="password">
									</div>
									<div class="form-group last mb-4">
										<label for="repeat_password">Xác nhận mật khẩu</label> <input
											type="password" class="form-control" id="repeat_password"
											name="repeat_password">
									</div>
									<div class="form-group first">
										<label for="role">Bạn là:</label> <select id="role"
											style="margin-left: 65px;" name="role">
											<option value="chutro">Người chủ trọ</option>
											<option value="thuetro">Người thuê trọ</option>
										</select>
									</div>
									<input type="submit" value="Đăng kí" name="register_account"
										class="btn btn-pill text-white btn-block btn-primary">
								</form>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>


	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
	<script>
		function validateForm() {
			var password = document.getElementById('password').value;
			var repeatPassword = document.getElementById('repeat_password').value;
			if (password !== repeatPassword) {
				alert("Mật khẩu và xác nhận mật khẩu không trùng khớp");
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>