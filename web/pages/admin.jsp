<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.dto.CountCarModelDTO" %>
<%@ page import="app.dao.*" %>
<%@ page import="app.entity.*" %>
<%@ page import="app.dto.MostReservedVehicleDTO" %>
<%@ page import="app.dto.ClientDTO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/admin.css">
    <link rel="stylesheet" href="../assets/css/global.css">
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    boolean hasCookie = false;

    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("idAdmin")) {
            hasCookie = true;
        }
    }

    if (!hasCookie) response.sendRedirect(request.getContextPath());
%>

<%
    CarBrandDAO carBrandDAO = new CarBrandDAO(CarBrand.class);
    ClientDAO clientDAO = new ClientDAO(Client.class);
    ReservationDAO reservationDAO = new ReservationDAO(Reservation.class);
    CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);
    VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);
    AdminDAO adminDAO = new AdminDAO(Admin.class);

    List<CarBrand> carBrandList = carBrandDAO.getAll();
    List<CarModel> carModelList = carModelDAO.getAll();
    List<Vehicle> vehicleList = vehicleDAO.getAll();
    List<Reservation> reservationList = reservationDAO.getAll();
    List<Client> clientList = clientDAO.getAll();

    Integer numberOfCarModels = carBrandDAO.getAll().size();
    Integer numberOfRegisteredCar = vehicleDAO.getAll().size();
    Integer numberOfClients = clientDAO.getAll().size();

    Vehicle selectedVehicle = new Vehicle();
    String company = adminDAO.findById(1).getFullName();
    if (request.getParameter("idVehicle") != null) {
        selectedVehicle = vehicleDAO.findById(Integer.valueOf(request.getParameter("idVehicle")));
        request.setAttribute("selectedVehicle", selectedVehicle);

    }

    request.setAttribute("company", company);
    request.setAttribute("carBrandList", carBrandList);
    request.setAttribute("numberOfCarModels", numberOfCarModels);
    request.setAttribute("numberOfRegisteredCar", numberOfRegisteredCar);
    request.setAttribute("numberOfClients", numberOfClients);

%>

<%

    Gson gsonObj = new Gson();
    Map<Object, Object> map = null;
    List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
    List<CountCarModelDTO> data = vehicleDAO.countVehicleByCarModel();

    for (CountCarModelDTO dto :
            data) {
        map = new HashMap<Object, Object>();
        map.put("label", dto.getCarModelTitle());
        map.put("y", dto.getValue());
        list.add(map);
    }


    String dataPoints = gsonObj.toJson(list);

    Gson carBrandGson = new Gson();
    Map<Object, Object> carBrandMap = null;
    List<Map<Object, Object>> mapArrayList = new ArrayList<Map<Object, Object>>();
    List<CountCarModelDTO> carBrandData = vehicleDAO.countAllVehicleByCarBrand();

    for (CountCarModelDTO dto :
            carBrandData) {
        carBrandMap = new HashMap<Object, Object>();
        carBrandMap.put("label", dto.getCarModelTitle());
        carBrandMap.put("y", dto.getValue());
        mapArrayList.add(carBrandMap);
    }


    String carBrandDataPoint = carBrandGson.toJson(mapArrayList);

    Gson mostPopularGson = new Gson();
    Map<Object, Object> mostPopularMap = null;
    List<Map<Object, Object>> mostPopularList = new ArrayList<Map<Object, Object>>();
    List<MostReservedVehicleDTO> mostPopularData = reservationDAO.countMostReservedVehicles();

    for (MostReservedVehicleDTO dto :
            mostPopularData) {
        mostPopularMap = new HashMap<Object, Object>();
        mostPopularMap.put("label", dto.getCarModelTitle());
        mostPopularMap.put("y", dto.getAmount());
        mostPopularList.add(mostPopularMap);
    }


    String mostPopularDataPoint = mostPopularGson.toJson(mostPopularList);

    Gson mostLoyaltyClientGson = new Gson();
    Map<Object, Object> mostLoyaltyClientMap = null;
    List<Map<Object, Object>> mostLoyaltyClientList = new ArrayList<Map<Object, Object>>();
    List<ClientDTO> mostLoyaltyClientListData = clientDAO.countMostLoyaltyClients();

    for (ClientDTO dto :
            mostLoyaltyClientListData) {
        mostLoyaltyClientMap = new HashMap<Object, Object>();
        mostLoyaltyClientMap.put("label", dto.getFullName());
        mostLoyaltyClientMap.put("y", dto.getAmount());
        mostLoyaltyClientList.add(mostLoyaltyClientMap);
    }


    String mostLoyaltyClientsDataPoint = mostLoyaltyClientGson.toJson(mostLoyaltyClientList);


%>
<div class="row">
    <div class="col-3 menu">
        <div style="padding-top: 2em">
            <div class="row">
                <div class="col text-right">
                    <img src="https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/Avis-Logo.png?alt=media&token=3bad39c3-4e72-4de1-a4fa-c39dc175b7e7"
                         class="img-fluid" width="150px">
                </div>
                <div class="col text-left">
                    <h4><%=company%>
                    </h4>
                </div>
            </div>
        </div>
        <div class="nav flex-column nav-pills" style="padding-top: 2em" id="v-pills-tab" role="tablist"
             aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab"
               aria-controls="v-pills-home" aria-selected="true">Dashboard</a>
            <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
               aria-controls="v-pills-profile" aria-selected="false">Vehicle</a>
            <a class="nav-link" id="v-pills-profile-reservation-tab" data-toggle="pill"
               href="#v-pills-profile-reservation" role="tab"
               aria-controls="v-pills-profile" aria-selected="false">Reservation</a>

        </div>
    </div>
    <div class="col-9">
        <div class="text-right" style="padding-top: 1em;padding-left: 1em">

        </div>
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div class="row text-center">
                    <div class="col">
                        <div type="button" class="btn car-brand-div" data-toggle="modal" data-target="#exampleModal">
                            <div class="row">
                                <div class="col car">
                                    <h4>Number of car models</h4>
                                    <h3>${numberOfCarModels}</h3>
                                </div>
                                <div class="col" style="padding-top: 1em">
                                    <img src="http://localhost:8080/home/assets/img/caricon.png" class="img-fluid"
                                         width="80px">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div type="button" class="btn car-brand-div" data-toggle="modal" data-target="#vehicleModal">
                            <div class="row">
                                <div class="col">
                                    <h4>Number of registered cars</h4>
                                    <h3>${numberOfRegisteredCar}</h3>
                                </div>
                                <div class="col" style="padding-top: 1em">
                                    <img src="http://localhost:8080/home/assets/img/registration.png" class="img-fluid"
                                         width="80px">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div type="button" class="btn car-brand-div" data-toggle="modal" data-target="#clientModal">
                            <div class="row">
                                <div class="col">
                                    <h4>Number of clients</h4>
                                    <h3>${numberOfClients}</h3>
                                </div>
                                <div class="col" style="padding-top: 1em">
                                    <img src="http://localhost:8080/home/assets/img/client.png" class="img-fluid"
                                         width="80px">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row text-center" style="padding-top: 2em">
                    <div class="col-sm chart-container text-left">
                        <div id="chartContainer" style="height: 370px; width: 100%;"></div>
                    </div>
                    <div class="col-sm chart-container text-left">
                        <div id="chartContainer1" style="height: 370px; width: 100%;"></div>
                    </div>
                </div>
                <div class="table-div">
                    <table class="table text-right">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Account Number</th>
                            <th scope="col">Client</th>
                            <th scope="col">Handle</th>
                        </tr>
                        </thead>
                        <tbody>


                        <% for (int i = reservationList.size() - 1; i > reservationList.size() - 5; i--) { %>

                        <tr>
                            <td><%= reservationList.get(i).getIdClient().getFullName() %>
                            </td>
                            <td><%= reservationList.get(i).getIdClient().getEmail()%>
                            </td>
                            <td><%= reservationList.get(i).getStartDate()%>
                            </td>
                            <td><%= reservationList.get(i).getEndDate() %>
                            </td>
                            <td><%= reservationList.get(i).getIdVehicle().getIdCarModel().getIdCarBrand().getTitle() + " " + reservationList.get(i).getIdVehicle().getIdCarModel().getTitle() + " " + reservationList.get(i).getIdVehicle().getPower()%>
                            </td>
                            <td><%=  reservationList.get(i).getTotal() %>
                            </td>

                        </tr>
                        <% }
                        %>
                        </tbody>
                    </table>
                </div>
                <div>
                    <div class="col-sm chart-container text-left">
                        <div id="chartContainer3" style="height: 370px; width: 100%;"></div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <table class="table text-right">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Account Number</th>
                        <th scope="col">Client</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody>


                    <% for (Vehicle vehicle : vehicleList) { %>

                    <tr>
                        <td><%= vehicle.getIdCarModel().getIdCarBrand().getTitle() %>
                        </td>
                        <td><%= vehicle.getIdCarModel().getTitle() %>
                        </td>
                        <td><%= vehicle.getPower() %>
                        </td>
                        <td><%= vehicle.getMileage() %>
                        </td>
                        <td><%= vehicle.getRegNum() %>
                        </td>
                        <td><%= vehicle.getPricePerDay() %>
                        </td>
                        <td>
                            <button type="button" class="btn " data-toggle="modal" data-target="#vehicleEditModal">
                                Edit
                            </button>
                            <form method="get" action="">
                                <button class="edit-btn" type="submit">Select vehiclesk
                                </button>
                                <button class="delete-btn" type="submit">Change account
                                </button>
                                <input type="hidden" name="idVehicle" value="<%=vehicle.getId()%>"/>
                            </form>
                        </td>
                        <td></td>

                    </tr>
                    <% }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="v-pills-profile-reservation" role="tabpanel"
                 aria-labelledby="v-pills-profile-tab">
                <table class="table text-right">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Account Number</th>
                        <th scope="col">Client</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody>


                    <% for (Reservation reservation : reservationList) { %>

                    <tr>
                        <td><%= reservation.getIdClient().getFullName() %>
                        </td>
                        <td><%= reservation.getIdClient().getEmail() %>
                        </td>
                        <td><%= reservation.getStartDate()%>
                        </td>
                        <td><%= reservation.getEndDate() %>
                        </td>
                        <td><%= reservation.getIdVehicle().getIdCarModel().getIdCarBrand().getTitle() + " " + reservation.getIdVehicle().getIdCarModel().getTitle() + " " + reservation.getIdVehicle().getPower() %>
                        </td>
                        <td><%= reservation.getTotal() %>
                        </td>
                        <td>
                            <button type="button" class="btn " data-toggle="modal" data-target="#vehicleEditModal">
                                Edit
                            </button>
                            <form method="get" action="">
                                <button class="edit-btn" type="submit">Select vehiclesk
                                </button>
                                <button class="delete-btn" type="submit">Change account
                                </button>
                                <input type="hidden" name="idVehicle" value="<%=reservation.getId()%>"/>
                            </form>
                        </td>
                        <td></td>

                    </tr>
                    <% }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Button trigger modal -->

        <%--Modals--%>

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
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
                            <div class="form-group">
                                <select name="carBrand" class="form-control form-control-lg">
                                    <% for (int i = 0; i < carBrandList.size(); i += 1) { %>

                                    <option value="<%= carBrandList.get(i).getId() %>"><%=carBrandList.get(i).getTitle()%>
                                    </option>

                                    <% }

                                    %>
                                </select>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Car Model</label>
                                    <input type="text" class="form-control" name="title" id="exampleInputPassword1"
                                           placeholder="Model">
                                </div>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn red-btn">Save changes</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="vehicleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="post" enctype="multipart/form-data" action="http://localhost:3000/upload">
                        <div class="form-group">
                            <select name="idCarModel" class="form-control form-control-lg">
                                <% for (int i = 0; i < carModelList.size(); i += 1) { %>

                                <option value="<%= carModelList.get(i).getId() %>"><%= carModelList.get(i).getIdCarBrand().getTitle() + " " + carModelList.get(i).getTitle()%>
                                </option>

                                <% }

                                %>
                            </select>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Power</label>
                                <input type="text" class="form-control" name="vehiclePower"
                                       placeholder="Model">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Vehicle Mileage</label>
                                <input type="text" class="form-control" name="vehicleMileage"
                                       placeholder="Model">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Reg No.</label>
                                <input type="text" class="form-control" name="vehicleReg"
                                       placeholder="Model">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Price per day</label>
                                <input type="text" class="form-control" name="vehiclePrice"
                                       placeholder="Model">
                            </div>
                        </div>
                        <input type="file" name="image">
                        <br/><br/>
                        <input type="submit" class="red-btn" value="Submit">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="vehicleEditModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form name="editForm" method="post" enctype="multipart/form-data"
                          action="http://localhost:3000/upload">
                        <div class="form-group">
                            <div class="form-group">

                                <label for="exampleInputPassword1">Power</label>
                                <input type="text" value="<%=selectedVehicle.getPower()%>" class="form-control"
                                       name="vehiclePower"
                                       placeholder="Model">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Vehicle Mileage</label>
                                <input type="text" value="<%=selectedVehicle.getMileage()%>" class="form-control"
                                       name="vehicleMileage"
                                       placeholder="Model">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Reg No.</label>
                                <input type="text" value="<%=selectedVehicle.getRegNum()%>" class="form-control"
                                       name="vehicleReg"
                                       placeholder="Model">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Price per day</label>
                                <input type="text" value="<%=selectedVehicle.getPricePerDay()%>" class="form-control"
                                       name="vehiclePrice"
                                       placeholder="Model">
                            </div>

                            <div class="text-center" style="padding-top: 1em;padding-bottom: 1em">
                                <img class="img-fluid" src="<%=selectedVehicle.getImage()%>">
                            </div>

                            <div class="text-center" style="padding-top: 1em;padding-bottom: 1em">
                                <input type="hidden" name="idVehicle" value="<%=selectedVehicle.getId()%>">
                            </div>
                        </div>
                        <input type="file" name="image">
                        <br/><br/>
                        <input type="submit" class="red-btn" value="Submit">
                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal fade" id="clientModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Account Number</th>
                            <th scope="col">Client</th>
                        </tr>
                        </thead>
                        <tbody>


                        <% for (Client client : clientList) { %>

                        <tr>
                            <td><%= client.getFullName()%>
                            </td>
                            <td><%= client.getEmail()%>
                            </td>
                            <td><%= client.getTelephone()%>
                            </td>

                        </tr>
                        <% }
                        %>
                        </tbody>
                    </table>
                </div>
                <div class="chart-container text-left">
                    <div id="chartContainer4" style="height: 370px;width: 90%"></div>
                </div>
            </div>

        </div>
    </div>
</div>

</div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2", // "light1", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Count vehicle by car model"
            },
            data: [{
                type: "pie",
                toolTipContent: "<b>{label}</b>: {y}%",
                indexLabelFontSize: 16,
                indexLabel: "{label} - {y}%",
                dataPoints: <%out.print(dataPoints);%>
            }]
        });
        var chart2 = new CanvasJS.Chart("chartContainer1", {
            theme: "light1", // "light1", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Typical Day"
            },
            data: [{
                type: "pie",
                toolTipContent: "<b>{label}</b>: {y}",
                indexLabelFontSize: 16,
                indexLabel: "{label} - {y}%",
                dataPoints: <%out.print(carBrandDataPoint);%>
            }]
        });
        var chart4 = new CanvasJS.Chart("chartContainer4", {
            theme: "light1", // "light1", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Typical Day"
            },
            data: [{
                type: "pie",
                toolTipContent: "<b>{label}</b>: {y}",
                indexLabelFontSize: 16,
                indexLabel: "{label} - {y}",
                dataPoints: <%out.print(mostLoyaltyClientsDataPoint);%>
            }]
        });

        var chart3 = new CanvasJS.Chart("chartContainer3", {
            theme: "light1", // "light1", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Typical Day"
            },
            data: [{
                type: "bar",
                toolTipContent: "<b>{label}</b>: {y}",
                indexLabelFontSize: 16,
                indexLabel: "{label} - {y}%",
                dataPoints: <%out.print(mostPopularDataPoint);%>
            }]
        });

        chart.render();
        chart2.render();
        chart3.render();
        chart4.render();
    }
</script>

</div>
</body>
</html>
