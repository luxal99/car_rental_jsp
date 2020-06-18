<%@ page import="app.dao.CarModelDAO" %>
<%@ page import="app.entity.CarModel" %>
<%@ page import="app.dao.VehicleDAO" %>
<%@ page import="app.entity.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.time.Duration" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/reservation.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    <script src="assets/js/index.js"></script>
    <link rel="stylesheet" href="../assets/css/global.css">
</head>
<body>

<%
    Long duration = ChronoUnit.DAYS.between(
            new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("startDate")).toInstant(),
            new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("endDate")).toInstant());

    request.setAttribute("duration", duration);
    ;

    String image = null;
    CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);
    VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);

    try {
        ChronoUnit.DAYS.between(
                new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("startDate")).toInstant(),
                new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("endDate")).toInstant());
    } catch (Exception e) {
        response.sendRedirect(request.getContextPath());
    }

    if (duration < 0) {
        response.sendRedirect(request.getContextPath());
    }
    request.setAttribute("duration", duration);

    CarModel carModel = carModelDAO.findById(Integer.valueOf(request.getParameter("idCarModel")));

    for (Vehicle vehicle :
            vehicleDAO.getAll()) {
        if (vehicle.getIdCarModel().getId() == carModel.getId()) {
            image = vehicle.getImage();
            request.setAttribute("image", image);
            request.setAttribute("vehicle", vehicle);
            break;
        }
    }

%>

<div class="header">
    </h2>
    <nav class="navbar navbar-expand-lg ">
        <a class="navbar-brand" href="#">
            <img src="https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/Avis-Logo.png?alt=media&token=3bad39c3-4e72-4de1-a4fa-c39dc175b7e7"
                 class="img-fluid" width="100px">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="header-div">
        <div class="row" style="padding-top: 10em">
            <div class="col-sm text-right">
                <img src="${image}" class="img-fluid">
            </div>
            <div class="col-sm">
                <h2>${vehicle.idCarModel.idCarBrand.title} ${vehicle.idCarModel.title}</h2>
                <h4>Price per day: ${vehicle.pricePerDay}</h4>
                <% for (Vehicle vehicle :
                        vehicleDAO.findAllVehicleByCarModel(Integer.valueOf(request.getParameter("idCarModel")))) { %>
                <div class="type-div">
                    <h2><%=vehicle.getPower()%>
                    </h2>
                </div>
                <%} %>

                <h2 style="padding-top: 1em">Total: <span
                        style="color: #FF4C16">${duration * vehicle.pricePerDay}</span></h2>
                <div>
                    <button class="red-btn" type="submit">Reserve</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
