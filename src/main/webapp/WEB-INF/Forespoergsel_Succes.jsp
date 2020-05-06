<%@ page import="DBAccess.StyklisteMapper" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header.inc" %>
<%

    request.setAttribute("stykliste", StyklisteMapper.getMaterialeMap());


%>
<p class="text2">
Tak for din forespørgsel ${sessionScope.navn}, vi vil vende tilbage snarest!
    <br>
    Der er sendt en email til: ${sessionScope.email}
    <br>
    <br>
    <a href="FrontController?target=Carport_Tegning">Se tegning af carport</a>

    ${requestScope.carporttegning}
    <br>
    <br>
    <br>
<div class="container col-lg-5" style="border: 1px solid black; background-color: lightgray;color: black; font-weight: bold; font-size: 15px">
    Konstruktions Beskrivelse:<br>
        ${sessionScope.beskrivelse}<br><br>
    Dit Tilbud er: ${sessionScope.pris}
</div>

</p>
</body>
</html>
