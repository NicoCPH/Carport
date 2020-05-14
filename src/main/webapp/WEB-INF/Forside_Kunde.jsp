<%@ page import="DBAccess.CarportMapper" %>
<%@ page import="FunctionLayer.Fejl_haendtering" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header.inc" %>

<div>
    <p class="text2 uppercase">
        QUICK-BYG TILBUD<br>
    </p>
    <p class="text2">
        Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
        <br>
        <br>
        Tilbud og skitsetegning fremsendes med post hurtigst muligt.
        <br>
        Ved bestilling medfølger standardbyggevejledning.
        <br>
        <br>
        Rekvirér tilbud - start med at vælge type:
    </p>
</div>
<br>
<br>
<br>
<br>
<div class="container">
    <div class="col-11">
        <div class="text-center">
            <p class="font-weight-bold">
                Carport med fladt tag.
            </p>
            <a href="FrontController?target=redirect&destination=Carport_Fladt">
                <img alt="Fladt tag" src="images/fladt%20tag.jpg">
            </a>
        </div>
    </div>
</div>
<br>
<br>
<br>
<div class="container">

    <div class="col-11">
        <div class="text-center">
            <p class="font-weight-bold">
                Carport med rejsning
            </p>
            <a href="FrontController?target=redirect&destination=Carport_Rejsning">
                <img alt="Rejsning" src="images/Rejsning.jpg">
            </a>
        </div>
    </div>
</div>
</body>