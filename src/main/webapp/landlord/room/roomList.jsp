<%@page import="model.bean.Room"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Danh sách phòng của trọ</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Roboto', sans-serif;
}

.table-responsive {
	margin: 30px 0;
}

.table-wrapper {
	min-width: 1000px;
	background: #fff;
	padding: 20px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 10px;
	margin: 0 0 10px;
}

.table-title h2 {
	margin: 8px 0 0;
	font-size: 22px;
}

.search-box {
	position: relative;
	float: right;
}

.search-box input {
	height: 34px;
	border-radius: 20px;
	padding-left: 35px;
	border-color: #ddd;
	box-shadow: none;
}

.search-box input:focus {
	border-color: #3FBAE4;
}

.search-box i {
	color: #a0a5b1;
	position: absolute;
	font-size: 19px;
	top: 8px;
	left: 10px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child {
	width: 130px;
}

table.table td a {
	color: #a0a5b1;
	display: inline-block;
	margin: 0 5px;
}

table.table td a.view {
	color: #03A9F4;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

.pagination {
	float: right;
	margin: 0 0 5px;
}

.pagination li a {
	border: none;
	font-size: 95%;
	width: 30px;
	height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 30px !important;
	text-align: center;
	padding: 0;
}

.pagination li a:hover {
	color: #666;
}

.pagination li.active a {
	background: #03A9F4;
}

.pagination li.active a:hover {
	background: #0397d6;
}

.pagination li.disabled i {
	color: #ccc;
}

.pagination li i {
	font-size: 16px;
	padding-top: 6px
}

.hint-text {
	float: left;
	margin-top: 6px;
	font-size: 95%;
}
</style>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
</head>
<body>
	<%
	ArrayList<Room> listRoom = (ArrayList<Room>) request.getAttribute("listRoom");
	%>
	<div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<a href="../landlord/room/create.jsp"
							class="btn btn--radius-2 btn--red" id="btn_add_room">Create
							new</a>
						<div class="col-sm-8">
							<h2>
								Danh sách <b>phòng của nhà trọ</b>
							</h2>
						</div>
						<div class="col-sm-4">
							<div class="search-box">
								<i class="material-icons">&#xE8B6;</i> <input type="text"
									class="form-control" placeholder="Search&hellip;">
							</div>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th>ID</th>
							<th>Tên <i class="fa fa-sort"></i></th>
							<th>Số người ở</th>
							<th>Chỉ số điện hiện tại <i class="fa fa-sort"></i></th>
							<th>Chỉ số nước hiện tại</th>
							<th>Giá cho thuê <i class="fa fa-sort"></i></th>
							<th>Tình trạng</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < listRoom.size(); i++) {
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=listRoom.get(i).getId()%></td>
							<td><%=listRoom.get(i).getName()%></td>
							<td><%=listRoom.get(i).getNumber_of_people_in_room()%></td>
							<td><%=listRoom.get(i).getCurrent_electric_meter()%></td>
							<td><%=listRoom.get(i).getCurrent_water_meter()%></td>
							<td><%=listRoom.get(i).getRoom_cost()%></td>
							<td><%=listRoom.get(i).getStatus()%></td>
							<td><a
								href="../landlord/boarding-house?detailroom=<%=listRoom.get(i).getId()%>"
								class="view" title="View" data-toggle="tooltip"><i
									class="material-icons">&#xE417;</i></a> <a
								href="../landlord/boarding-house?updateroom=<%=listRoom.get(i).getId()%>"
								class="edit" title="Edit" data-toggle="tooltip"><i
									class="material-icons">&#xE254;</i></a> <a
								href="../landlord/boarding-house?deleteroom=<%=listRoom.get(i).getId()%>"
								class="delete" title="Delete" data-toggle="tooltip"><i
									class="material-icons">&#xE872;</i></a> <a
								href="../landlord/boarding-house?view_invoice=<%=listRoom.get(i).getId()%>"
								class="view" title="Create" data-toggle="tooltip">View
									Invoice</a><a
								href="../landlord/boarding-house?add_new_invoice=<%=listRoom.get(i).getId()%>"
								class="view" title="Create" data-toggle="tooltip">Create
									Invoice</a></td>


						</tr>
						<%
						}
						%>
					</tbody>

				</table>
				<%
				if (request.getSession().getAttribute("status") != null) {
				%>
				<span class="alert alert-danger"><%=request.getSession().getAttribute("status")%></span>
				<%
				}
				request.getSession().removeAttribute("status");
				%>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(
				function() {
					var currentURL = window.location.href;
					var url = new URL(currentURL);
					var idbdhParam = url.searchParams.get("allroom");
					var deleteRoomLink = $(".delete");
					var btnAddRoom = $("#btn_add_room");
					var currentHrefAddRoom = btnAddRoom.attr("href");
					var currentHref = deleteRoomLink.attr("href");
					deleteRoomLink.attr("href", currentHref + "&idbdh="
							+ idbdhParam);
					btnAddRoom.attr("href", currentHrefAddRoom + "?idbdh="
							+ idbdhParam);
				});
	</script>
</body>
</html>