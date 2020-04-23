<%--
  Created by IntelliJ IDEA.
  User: Lange
  Date: 20/04/2020
  Time: 12.31
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header.inc" %>

<div class="icon1">
    <img src="images/Rejsning.jpg">
</div>
<div>
    <p class="text2 uppercase">
        QUICK-BYG TILBUD - CARPORT MED REJSNING<br>
    </p>
    <p class="text2">
        <br>
        Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram.
        <br><br>
        Tilbud og skitsetegning fremsendes med post hurtigst muligt.
        Standardbyggevejledning medfølger ved bestilling.
        <br><br>
        Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"
        Felter markeret * SKAL udfyldes!
        <br>
        <br>
        <br>
        Ønsket carport mål:
    </p>
</div>
<br>
<br>
<br>
<br>
<div class="container col-lg-5">
    <div class="form-group">
<form>
        <label class="mt-4">Carport Bredde</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>

        <br>

        <label class="mt-4">Carport Længde</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>

        <label class="mt-4">Tag type og farve</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>
        <label class="mt-4">Carport farve</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>
    <label class="mt-4">Taghældning</label>
    <select class="form-control">
        <option value="kg">Kg</option>
        <option value="gm">Gm</option>
        <option value="pound">Pound</option>
        <option value="MetricTon">Metric ton</option>
        <option value="litre">Litre</option>
        <option value="ounce">Ounce</option>
    </select>
    <br>
    <br>

    <div class="mt-4">
        <label><input type="checkbox" name="colorCheckbox" value="check">Fravælg redskabsrum</label>
    </div>
    <div class="check box">

        <p class="text2">
            Redskabsrum:<br>
            NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*
            <br>
            <br>
        </p>
        <label class="mt-4">Redskabsrum bredde</label>
        <select class="form-control" >
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>

        <label class="mt-4">Redskabsrum Længde</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>

        <label class="mt-4">Redskabsrum beklædnings type</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>

        <label class="mt-4">Redskabsrum gulv</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>

        <label class="mt-4">Redskabsrum position</label>
        <select class="form-control">
            <option value="kg">Kg</option>
            <option value="gm">Gm</option>
            <option value="pound">Pound</option>
            <option value="MetricTon">Metric ton</option>
            <option value="litre">Litre</option>
            <option value="ounce">Ounce</option>
        </select>
    </div>
    <br>
    <br>
    <br>
    <br>
    <label for="navn">Navn:</label><br>
    <input style="width: 450px" type="text" id="navn" name="fname"><br>

    <label for="adresse">Adresse:</label><br>
    <input style="width: 450px" type="text" id="adresse" name="adresse"><br>

    <label for="pnr">Postnummer:</label><br>
    <input style="width: 450px" type="text" id="pnr" name="pnr"><br>

    <label for="by">By:</label><br>
    <input style="width: 450px" type="text" id="by" name="by"><br>

    <label for="tlf">Telefon</label><br>
    <input style="width: 450px" type="text" id="tlf" name="tlf"><br>

    <label for="email">Email</label><br>
    <input style="width: 450px" type="email" id="email" name="email">

    <button class="btn btn-sm btn-primary mt-2 btn-block" type="submit">Send forespørgsel</button>
</form>
        <br>
        <br>
        <p class="text2">
            Evt. bemærkninger<br>
            * Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet maksimalt måle 210x330 cm.</p>

    </div>
    <br>
</div>



<script type="text/javascript">
    $(document).ready(function() {
        $('input[type="checkbox"]').click(function() {
            var inputValue = $(this).attr("value");
            $("." + inputValue).toggle();
        });
    });
</script>
</body>
</html>