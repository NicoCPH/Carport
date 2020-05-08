
<%@ page import="DBAccess.Stykliste_Mapper" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../indcludes/header.inc" %>
<%

    request.setAttribute("stykliste", Stykliste_Mapper.getMaterialeMap());



<p class="text2">
Tak for din forespørgsel ${sessionScope.navn}, vi vil vende tilbage snarest!
    <br>
    Der er sendt en email til: ${sessionScope.email}
    <br>
    <br>
    Her er en tegning over din valgte carport.
    <br>
    ${requestScope.carporttegning}
    <br>
    <br>
    <br>
<div class="container col-lg-5" style="border: 1px solid black; background-color: lightgray;color: black; font-weight: bold; font-size: 15px">
    Konstruktions Beskrivelse:<br>
        ${sessionScope.beskrivelse}<br><br>
    Dit Tilbud er: ${sessionScope.pris}

<br>

<a href="FrontController?target=redirect&destination=Tilbud_Accept">
    <button class="btn btn-sm mt-2 " style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 350px">Accepter Tilbud</button>
</a>
</div>
</p>
</body>
</html>
