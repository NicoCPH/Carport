<%@ page import="DBAccess.CarportMapper" %>
<%@ page import="FunctionLayer.ExceptionHandler" %>
<%@ page import="DBAccess.StyklisteMapper" %>
<%@include file="indcludes/header1.inc" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    @Override
    public void jspInit() {
        try {
            StyklisteMapper.stykListe();
        } catch (ExceptionHandler e) {
            e.printStackTrace();
        }
    }
%>
<div>
<br>
<br>
<br>
<div class="container">
    <div class="col-11 mt-5">
        <div class="text-center">
            <p class="font-weight-bold">
            <a href="FrontController?target=redirect&destination=Forside_Saelger">
                <button class="btn btn-sm mt-2 " style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 350px">Sælger side</button>
            </a>
            </p>
        </div>
    </div>
</div>
<br>
<br>
<br>
<div class="container">

    <div class="col-11 mt-5">
        <div class="text-center">
            <p class="font-weight-bold">
            <a href="FrontController?target=redirect&destination=Forside_Kunde">
                   <button class="btn btn-sm mt-2" style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 350px">Kunde side</button>
            </a>
            </p>
        </div>
    </div>
</div>

</body>
</div>
</html>