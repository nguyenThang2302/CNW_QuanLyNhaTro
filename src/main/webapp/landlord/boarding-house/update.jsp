<%@page import="model.bean.BoardingHouse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Update boarding house</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->

    <!-- Icons font CSS-->
    <link href="../template/createHouse/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="../template/createHouse/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="../template/createHouse/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../template/createHouse/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../template/createHouse/css/main.css" rel="stylesheet" media="all">
</head>
<body>
	<% BoardingHouse boardingHouse=(BoardingHouse) request.getAttribute("boardingHouse") ;%>
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Update Boarding House</h2>
                </div>
                <div class="card-body">
                    <form action="../landlord/boarding-house" method="POST">
                    <div class="form-row">
                            <div class="name">ID</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="id" value="<%=boardingHouse.getId()%>"readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="name" value="<%=boardingHouse.getName()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Address</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="address" value="<%=boardingHouse.getAddress()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Electricity Unit Price</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="electricity" value="<%=boardingHouse.getElectricityUnitPrice()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Water Unit Price</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="water" value="<%=boardingHouse.getWaterUnitPrice()%>">
                                </div>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit" name="update">Update</button>
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
    <script src="../template/createHouse/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="../template/createHouse/js/global.js"></script>
</body>
</html>