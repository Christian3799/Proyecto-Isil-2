<%@ page import="pe.isil.model.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu Desplegable</title>
    <style type="text/css">

        * {
            margin:0px;
            padding:0px;
        }

        #header {
            margin:auto;
            width:500px;
            font-family:Arial, Helvetica, sans-serif;
        }

        ul, ol {
            list-style:none;
        }

        .nav > li {
            float:left;
        }

        .nav li a {
            background-color:#000;
            color:#fff;
            width: 100%;
            text-decoration:none;
            padding:10px 12px;
            display:block;
        }

        .nav li a:hover {
            background-color:#434343;
        }

        .nav li ul {
            display:none;
            position:absolute;
            min-width:140px;
        }

        .nav li:hover > ul {
            display:block;
        }

        .nav li ul li {
            position:relative;
        }

        .nav li ul li ul {
            right:-140px;
            top:0px;
        }

    </style>
</head>
<body>
<div id="header">
    <ul class="nav">
        <li><a href="">Inicio</a></li>
        <li><a href="">PELICULA</a>
            <ul>
                <li><a href="TERROR.jsp">TERROR</a></li>
                <li><a href="">COMEDIA</a></li>
                <li><a href="">SUSPENSO</a></li>
                <li><a href="">DRAMA</a></li>
            </ul>
        </li>
        <li><a href="">Compra</a>
            <ul>
                <li><a href="">Tarjeta</a></li>
                <li><a href="">Al contado</a></li>
                <li><a href="">Transferencia</a></li>
                <li><a href="">Chekee</a></li>
            </ul>
        </li>
        <li><a href="">Tiendas</a></li>
    </ul>
</div>
</body>
</html>
