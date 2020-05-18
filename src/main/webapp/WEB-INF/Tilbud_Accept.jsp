<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../indcludes/header.inc" %>
<div class="container col-lg-5" style="overflow-x:auto; border: 1px solid black; background-color: lightgray;color: black; font-weight: bold; font-size: 15px">
<p class="text2">
<br>
Styklisten
    <br>
        <c:forEach var="stykliste" items="${sessionScope.stykliste}">
            <table class="table table-view">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Navn:</th>
                    <th scope="col">Længde:</th>
                    <th scope="col">Beskrivelse:</th>
                    <th scope="col">Antal:</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${stykliste.navn}</td>
                    <td>${stykliste.laengde}</td>
                    <td>${stykliste.beskrivelse}</td>
                    <td>${stykliste.antal}</td>
                </tr>

                </tbody>
            </table>
        </c:forEach>
   Din pris er ialt: ${sessionScope.pris} kr.
</p>
</div>


</body>
</html>
