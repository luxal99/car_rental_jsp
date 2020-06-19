<%@ page import="app.dao.ClientDAO" %>
<%@ page import="app.entity.Client" %>
<%@ page import="app.util.HashPassword" %>
<%@ page import="app.dao.ReservationDAO" %>
<%@ page import="app.entity.Reservation" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>

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
    <link rel="stylesheet" href="../assets/css/global.css">
    <link rel="stylesheet" href="../assets/css/client.css">
</head>
<body>
<%
    ClientDAO clientDAO = new ClientDAO(Client.class);
    Client loggedClient = new Client();
    Cookie[] cookies = request.getCookies();
    boolean hasCookie = false;

    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("client")) {
            hasCookie = true;
            loggedClient = clientDAO.findById(Integer.valueOf(HashPassword.decrypt(cookie.getValue())));
        }
    }

    if (!hasCookie) response.sendRedirect(request.getContextPath());

    request.setAttribute("loggedClient", loggedClient);
%>

<%

    ReservationDAO reservationDAO = new ReservationDAO(Reservation.class);
    List<Reservation> reservationList = reservationDAO.findAllReservationByClientId(loggedClient.getId());

    Double totalSpent = reservationDAO.countTotalSpentByUser(loggedClient.getId());


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
                    <h4>Welcome, ${loggedClient.fullName}</h4>
                </div>
            </div>
        </div>
        <div class="nav flex-column nav-pills" style="padding-top: 2em" id="v-pills-tab" role="tablist"
             aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab"
               aria-controls="v-pills-home" aria-selected="true">Dashboard</a><br>
            <a class="nav-link active" id="v-pills-home-profile" data-toggle="pill" href="#v-pills-profile" role="tab"
               aria-controls="v-pills-home" aria-selected="true">Profile</a>

        </div>
    </div>
    <div class="col-9">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div>
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
                            <td><%= reservation.getIdClient().getEmail()%>
                            </td>
                            <td><%= reservation.getStartDate()%>
                            </td>
                            <td><%= reservation.getEndDate() %>
                            </td>
                            <td><%= reservation.getIdVehicle().getIdCarModel().getIdCarBrand().getTitle() + " " + reservation.getIdVehicle().getIdCarModel().getTitle() + " " + reservation.getIdVehicle().getPower()%>
                            </td>
                            <td><%=  reservation.getTotal() %>
                            </td>

                        </tr>
                        <% }
                        %>
                        </tbody>
                    </table>
                    <div class="text-right">
                        <h1>Total <%=totalSpent%>
                        </h1>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade show active" id="v-pills-profile" role="tabpanel"
                 aria-labelledby="v-pills-home-profile">
                <div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
