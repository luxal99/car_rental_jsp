<%@ page import="app.dao.CarBrandDAO" %>
<%@ page import="app.entity.CarBrand" %>
<%@ page import="java.util.List" %>
<%@ page import="app.entity.CarModel" %>
<%@ page import="app.dao.CarModelDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Rental Company | Welcome</title>
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
    <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>


<%

    CarBrandDAO carBrandDAO = new CarBrandDAO(CarBrand.class);
    CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);

    List<CarBrand> carBrandList = carBrandDAO.getAll();
    List<CarModel> carModelList = carModelDAO.getAll();
%>

<%
    if (request.getParameter("carBrandId") != null) {
        Integer carBrandId = Integer.valueOf(request.getParameter("carBrandId"));
        request.setAttribute("carBrandId", carBrandId);

        carModelFilterSearch(carBrandId);
    }

    if (request.getParameter("idCarModel") != null) {
        Integer idCarModel = Integer.valueOf(request.getParameter("idCarModel"));
        request.setAttribute("idCarModel", idCarModel);
    }


%>

<%!


    CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);
    List<CarModel> filtered = new ArrayList<CarModel>();

    public List<CarModel> carModelFilterSearch(Integer id) {

        List<CarModel> carModelList = carModelDAO.getAll();
        filtered.clear();
        for (CarModel carModel :
                carModelList) {
            if (carModel.getIdCarBrand().getId() == id) {
                filtered.add(carModel);
            }
        }
        return filtered;
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
    <div class="header-container">
        <div class="text-center">
            <h6>Lorem ipsum</h6>
            <h1 class="big-h1">Amazing car rental agency</h1>
        </div>
        <div class="row header-row">
            <div class="col">
                <img src="https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/PNGPIX-COM-White-Audi-TT-Clubsport-Turbo-Car-PNG-image.png?alt=media&token=d10aca0a-9ba1-4cb0-9168-433ec185eb1c"
                     alt="" class="img-fluid">
            </div>
            <div class="col">
                <h1 class="header-h1">Lorem Ipsum</h1>
                <h2 class="header-h2">30% SALE</h2>
                <div class="row">
                    <button class="red-btn"
                            onclick="location.href='${pageContext.request.contextPath}/pages/login.jsp'">LOGIN
                    </button>
                    <button class="white-btn" style="margin-left: 1em"
                            onclick="location.href='${pageContext.request.contextPath}/pages/registration.jsp'">REGISTER
                    </button>

                </div>
            </div>
        </div>
    </div>
    <div class="red-container">
        <form id="redirectForm" method="post" action="${pageContext.request.contextPath}/pages/reservation.jsp"></form>
        <form name="vehicleForm" action="index.jsp" method="get">
            <div class="row">

                <div class="col">
                    <select name="carBrandId" id="carBrandId" class="form-control form-control-lg"
                            onclick="selectCarBrand();" onchange="this.form.submit()">
                        <% for (int i = 0; i < carBrandList.size(); i += 1) { %>

                        <option value="<%= carBrandList.get(i).getId() %>"><%=carBrandList.get(i).getTitle()%>
                        </option>

                        <% }

                        %>
                    </select>

                </div>
                <div class="col">
                    <select name="idCarModel" id="carModel" onchange="this.form.submit()"
                            class="form-control form-control-lg">
                        <% for (int i = 0; i < filtered.size(); i += 1) { %>

                        <option value="<%= filtered.get(i).getId() %>"><%=filtered.get(i).getTitle()%>
                        </option>

                        <% }

                        %>
                    </select>
                </div>
                <div class="col">
                    <input type="date" name="startDate" form="redirectForm" class="form-control">
                </div>
                <div class="col">
                    <input type="date" form="redirectForm" name="endDate" class="form-control">
                </div>
                <div class="col">
                    <input type="hidden" name="idCarModel" value="${idCarModel}" form="redirectForm">
                    <button class="reg-btn btn" form="redirectForm" type="submit">MORE</button>
                </div>

            </div>

        </form>
    </div>
</div>

<%


%>
</body>
</html>
