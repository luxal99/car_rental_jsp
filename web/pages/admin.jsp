<%@ page import="app.entity.CarBrand" %>
<%@ page import="app.dao.CarBrandDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="app.dao.CarModelDAO" %>
<%@ page import="app.entity.CarModel" %>
<%@ page import="app.dao.VehicleDAO" %>
<%@ page import="app.entity.Vehicle" %>
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
    CarBrandDAO carBrandDAO = new CarBrandDAO(CarBrand.class);
    CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);
    VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);

    List<CarBrand> carBrandList = carBrandDAO.getAll();
    List<CarModel> carModelList = carModelDAO.getAll();

    Integer numberOfCarModels = carBrandDAO.getAll().size();
    Integer numberOfRegisteredCar = vehicleDAO.getAll().size();


    request.setAttribute("carBrandList", carBrandList);
    request.setAttribute("numberOfCarModels", numberOfCarModels);

%>
<div class="row">
    <div class="col-3 menu">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab"
               aria-controls="v-pills-home" aria-selected="true">Clients</a>
            <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
               aria-controls="v-pills-profile" aria-selected="false">Accounts</a>

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
                        <div type="button" class="btn car-brand-div" data-toggle="modal" data-target="#exampleModal">
                            <div class="row">
                                <div class="col"></div>
                                <div class="col">
                                    <img src="http://localhost:8080/home/assets/img/car-icon.png" class="img-fluid"
                                         width="50px">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <h1>Aleksa</h1>
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
                    <form method="post" action="${pageContext.request.contextPath}/vehicle">
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
</div>
</body>
</html>
