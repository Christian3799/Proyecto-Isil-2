<%@ page import="pe.isil.model.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 28/10/2019
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Películas</title>
</head>
<body>
    <h1>Películas</h1>

    <table>
        <thead>
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Año lanzamiento</th>
                <th>Tiempo de alquiler</th>
                <th>Popularidad en alquiler</th>
                <th>Duracion</th>
                <th>Costo por daños</th>
                <th>Rating</th>
                <th>Contenido exclusivo</th>
            </tr>
        </thead>

        <tbody>
            <%
                List<Film> films = (List<Film>) request.getAttribute("films");
                for(int i=0; i<films.size(); i++) {
            %>
        <tr>
            <td><% films.get(i).getTitle(); %></td>
            <td><% films.get(i).getDescription(); %></td>
            <td><% films.get(i).getRelease_year(); %></td>
            <td><% films.get(i).getRentalDuration(); %></td>
            <td><% films.get(i).getRentalRate(); %></td>
            <td><% films.get(i).getLength(); %></td>
            <td><% films.get(i).getReplacementCost(); %></td>
            <td><% films.get(i).getRating(); %></td>
            <td><% films.get(i).getSpecialFeatures(); %></td>
        </tr>}

        </tbody>
    </table>
</body>
</html>
