<%@ page import="app.dao.CarModelDAO" %>
<%@ page import="app.entity.CarModel" %>
<%@ page import="app.dao.VehicleDAO" %>
<%@ page import="app.entity.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="app.entity.Client" %>
<%@ page import="app.dao.ClientDAO" %>
<%@ page import="app.util.HashPassword" %>
<%@ page import="java.time.temporal.Temporal" %>
<%@ page import="app.dao.ReservationDAO" %>
<%@ page import="app.entity.Reservation" %>
<%@ page import="app.dto.MostReservedVehicleDTO" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/reservation.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../assets/css/global.css">
</head>
<body>

<%
    Long duration = null;
    SimpleDateFormat startDate = new SimpleDateFormat("yyyy-mm-dd");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-mm-dd");
    CarModel carModel = new CarModel();
    Integer idCarModel = 0;
    Integer counter = 0;


    String image = null;

    ClientDAO clientDAO = new ClientDAO(Client.class);
    CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);
    VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);
    ReservationDAO reservationDAO = new ReservationDAO(Reservation.class);

    List<MostReservedVehicleDTO> mostReservedVehicleDTOList = reservationDAO.countMostReservedVehicles();

    Client loggedClient = new Client();

    Cookie[] cookies = request.getCookies();

    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("client")) {
            loggedClient = clientDAO.findById(Integer.valueOf(HashPassword.decrypt(cookie.getValue())));
        }
    }

    try {

        /**
         * If we don't have parameter @idCarModel in request
         * then we read last inputed from cookie
         */
        if (request.getParameter("idCarModel") == null) {

            Temporal t1 = null;
            Temporal t2 = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    carModel = carModelDAO.findById(Integer.valueOf(cookie.getValue()));
                    idCarModel = carModel.getId();
                } else if (cookie.getName().equals("startDate"))    {
                    request.setAttribute("startDate", cookie.getValue());
                    t1 = startDate.parse(cookie.getValue()).toInstant();

                } else if (cookie.getName().equals("endDate")) {
                    t2 = endDate.parse(cookie.getValue()).toInstant();
                    request.setAttribute("endDate", cookie.getValue());
                }
            }

            duration = ChronoUnit.DAYS.between(t1, t2);
            request.setAttribute("duration", duration);

        } else {
            /**
             * When we have parameter @idCarModel
             * then we read that parameter and find all vehicle by that parameter
             * and put last read parameter to cookie
             */
            carModel = carModelDAO.findById(Integer.valueOf(request.getParameter("idCarModel")));
            idCarModel = carModel.getId();
            Cookie cookie = new Cookie("id", carModel.getId().toString());
            Cookie startDateCookie = new Cookie("startDate", request.getParameter("startDate"));
            Cookie endDateCookie = new Cookie("endDate", request.getParameter("endDate"));

            cookie.setPath(request.getContextPath() + "/pages/reservation.jsp");
            startDateCookie.setPath(request.getContextPath() + "/pages/reservation.jsp");
            endDateCookie.setPath(request.getContextPath() + "/pages/reservation.jsp");


            duration = ChronoUnit.DAYS.between(
                    startDate.parse(request.getParameter("startDate")).toInstant(),
                    endDate.parse(request.getParameter("endDate")).toInstant());

            request.setAttribute("duration", duration);
            request.setAttribute("startDate", request.getParameter("startDate"));
            request.setAttribute("endDate", request.getParameter("endDate"));

            response.addCookie(cookie);
            response.addCookie(startDateCookie);
            response.addCookie(endDateCookie);


        }

        /**
         * Check input date
         * @endDate greater then @startDate function would redirect to /home
         * @startDate lower then current date function would redirect to /home
         */
        if (duration <= 0) {
            response.sendRedirect(request.getContextPath());
        }

//        Search for all vehicle by @idCarModel
        for (Vehicle vehicle :
                vehicleDAO.getAll()) {
            if (vehicle.getIdCarModel().getId() == carModel.getId()) {
                image = vehicle.getImage();
                request.setAttribute("image", image);
                request.setAttribute("vehicle", vehicle);
                break;
            }
        }
    } catch (Exception exception) {
        response.sendRedirect(request.getContextPath());
    }


%>


<%
    /*
    Run when we select type of vehicle.Ex -> if we can vehicle
    with power of 140ks and power of 120ks
     */
    Vehicle selectedVehicle = new Vehicle();
    if (request.getParameter("idVehicle") != null) {
        selectedVehicle = vehicleDAO.findById(Integer.valueOf(request.getParameter("idVehicle")));
        request.setAttribute("selectedVehicle", selectedVehicle);
    }

%>


<div class="header">
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
                    <a class="nav-link" href="${pageContext.request.contextPath}">Home <span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/pages/client.jsp">Profile</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="header-div">
        <div class="row" style="padding-top: 10em">
            <div class="col-sm text-right">
                <img src="${image}" class="img-fluid">
            </div>
            <div style="border-left: 1px solid #eee" class="col-sm">

                <div class="row">
                    <div class="col">
                        <h2>${vehicle.idCarModel.idCarBrand.title} ${vehicle.idCarModel.title}</h2>
                    </div>
                    <div class="col text-right">
                        <h4>Start date: ${startDate}</h4>
                        <h4>End date: ${endDate}</h4>
                    </div>
                </div>
                <h4>Price per day: ${vehicle.pricePerDay}</h4>
                <% for (Vehicle vehicle :
                        vehicleDAO.findAllVehicleByCarModel(idCarModel)) { %>
                <form action="reservation.jsp" method="post">
                    <input type="hidden" name="idVehicle" value="<%=vehicle.getId()%>">
                    <input type="hidden" name="idClient" value="<%=loggedClient.getId()%>">
                    <input type="hidden" name="startDate" value="${startDate}">
                    <input type="hidden" name="endDate" value="${endDate}">
                    <input type="hidden" name="total" value="${duration * vehicle.pricePerDay}">
                    <button class="type-div" type="submit" style="width: 100%">
                        <h2><%=vehicle.getPower()%>
                        </h2>
                    </button>

                </form>

                <%} %>

                <h2 style="padding-top: 1em;padding-left: 1em">Total: <span
                        style="color: #FF4C16">${duration * vehicle.pricePerDay}</span></h2>
                <div>
                    <form action="reservation.jsp" method="post" id="dateForm">
                    </form>
                    <form method="post" action="${pageContext.request.contextPath}/reservation">
                        <input type="hidden" name="idVehicle" value="<%=selectedVehicle.getId()%>">
                        <input type="hidden" name="idClient" value="<%=loggedClient.getId()%>">
                        <input type="hidden" name="total" value="${duration * vehicle.pricePerDay}">
                        <input type="hidden" name="startDate" value="${startDate}">
                        <input type="hidden" name="endDate" value="${endDate}">
                        <div id="date-div" style="display: none;padding-top: 1em;padding-bottom: 1em">
                            <div class="row">

                                <input type="hidden" name="idCarModel" form="dateForm" value="<%=carModel.getId()%>">
                                <div class="col">
                                    <input type="date" value="${startDate}" form="dateForm" name="startDate"
                                           class="form-control">
                                </div>
                                <div class="col">
                                    <input type="date" name="endDate" form="dateForm" value="${endDate}"
                                           class="form-control"
                                           onchange="this.form.submit()">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <button class="red-btn" type="submit">Reserve
                            </button>
                            <button class="white-btn" type="button" onclick="editDate()">Edit date
                            </button>
                        </div>

                    </form>


                </div>
            </div>
        </div>
        <div class="vehicle-div" style="padding: 2em">
            <div class="most-used-container">
                <h2>Similar brand
                </h2>
                <div style="height: 1px;background-color: #eee"></div>
                <div class="row">
                    <% for (Vehicle vehicle :
                            vehicleDAO.findByCarBrand(carModel.getIdCarBrand().getId())) {
                        if (counter == 2) break;
                        counter++;
                    %>
                    <div class="col car-col">
                        <div class="text-center">
                            <img class="img-fluid" src="<%=vehicle.getImage()%>">
                            <h3 class="h3-brand"><%=vehicle.getIdCarModel().getIdCarBrand().getTitle()%>
                            </h3>
                            <h3 class="h3-model"><%=vehicle.getIdCarModel().getTitle()%>
                            </h3>
                            <form method="post" action="reservation.jsp">
                                <input type="hidden" name="idCarModel" value="<%=vehicle.getIdCarModel().getId()%>">
                                <input type="hidden" name="startDate" value="${startDate}">
                                <input type="hidden" name="endDate" value="${endDate}">
                                <button class="red-btn">Choose</button>
                            </form>
                        </div>
                    </div>


                    <%
                        }

                    %>

                </div>
                <h2>Most popular cars
                </h2>
                <div style="height: 1px;background-color: #eee"></div>
                <div class="row">
                    <% for (MostReservedVehicleDTO mostReservedVehicleDTO :
                            reservationDAO.countMostReservedVehicles()) {
                        if (counter == 5) break;
                        counter++;
                    %>
                    <div class="col car-col">
                        <div class="text-center">
                            <img class="img-fluid" src="<%=mostReservedVehicleDTO.getImage()%>">
                            <h3 class="h3-brand"><%=mostReservedVehicleDTO.getCarBrandTitle()%>
                            </h3>
                            <h3 class="h3-model"><%=mostReservedVehicleDTO.getCarModelTitle()%>
                            </h3>
                            <form method="post" action="reservation.jsp">
                                <input type="hidden" name="idCarModel" value="<%=mostReservedVehicleDTO.getId()%>">
                                <input type="hidden" name="startDate" value="${startDate}">
                                <input type="hidden" name="endDate" value="${endDate}">
                                <button class="red-btn">Choose</button>
                            </form>
                        </div>
                    </div>


                    <%
                        }

                    %>

                </div>
            </div>
        </div>
    </div>

</div>

<%--MODAL--%>


<div class="modal fade" id="reserveModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="${pageContext.request.contextPath}/model">

                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function editDate() {
        const x = document.getElementById("date-div");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
</body>
</html>
