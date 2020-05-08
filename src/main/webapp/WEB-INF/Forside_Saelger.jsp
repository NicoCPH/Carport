<%@ page import="DBAccess.Forespoergsels_Mapper" %>
<%@ page import="FunctionLayer.Fejl_haendtering" %>
<%@ page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header1.inc" %>

<%

    try {
        String email = request.getParameter("email");
        request.setAttribute("showorders", Forespoergsels_Mapper.Alle_Forespoerelser(email));
        } catch (Fejl_haendtering exceptionHandler) {
            exceptionHandler.printStackTrace();
        }


%>
<br>
<br>
<div class="container">
<form name="Vis_forespoergsel" action="FrontController" method="POST" class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal align">Vis forespørgsel via Email</h1>
<label for="inputEmailEditUser" class="sr-only">Email address</label>
<input name="email" value="kunde@cph.dk" type="email" id="inputEmailEditUser" class="form-control mb-3"
       placeholder="Email adresse" required autofocus>
<input type="hidden" name="target" value="Vis_forespoergsel">
<button class="btn btn-sm bg-primary btn-primary btn-block text-center" type="submit">Opdater</button>
</form>

    <div class="container">
        <!-- Show all orders to a specific customer -->
        <c:forEach var="show" items="${showorders}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Navn:</th>
                    <th scope="col">Email:</th>
                    <th scope="col">Længde:</th>
                    <th scope="col">Bredde:</th>
                    <th scope="col">Farve:</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${show.navn}</td>
                    <td>${show.kundeemail}</td>
                    <td>${show.laengde}</td>
                    <td>${show.bredde}</td>
                    <td>${show.farve}</td>
                </tr>
                </tbody>
            </table>
        </c:forEach>
        <!-- End table -->
    </div>
</div>
</body>
</html>
