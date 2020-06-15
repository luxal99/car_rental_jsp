<%--
  Created by IntelliJ IDEA.
  User: luxal
  Date: 4/26/20
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>Error page</title>

    <style>

        @import url('https://fonts.googleapis.com/css?family=Manrope&display=swap');

        body {
            background-color: #F7F7F7;
        }

        div {
            font-family: 'Manrope', sans-serif;
        }

        .ups-h1 {
            font-size: 80px;
        }

        .error-div {
            padding-left: 10%;
            padding-right: 10%;
            background-color: #F7F7F7;
            height: 100vh;
            padding-top: 5em;
        }

    </style>
</head>
<body>
<div>
    <div class="error-div">
        <div class="row">
            <div class="col " style="padding-top: 10em">
                <h1 class="ups-h1">Upsss!!!</h1>
                <h2>Possible error</h2>
                <ul class="text-center" style="padding-top: 1em">
                    <li class="text-left"><h4>If you input not valid account number</h4></li>
                    <li class="text-left"><h4>Page not found</h4></li>
                    <li class="text-left"><h4>In transfer process you don't have enough money</h4></li>

                </ul>
            </div>
            <div class="col">
                <img class="img-fluid"
                     src="https://firebasestorage.googleapis.com/v0/b/soy-smile-249718.appspot.com/o/432-4320881_robot-vector-hd-png-download.png?alt=media&token=e03590b2-f8c0-43ab-a140-2c75dbe3a69d">
            </div>
        </div>
    </div>
</div>
</body>
</html>
