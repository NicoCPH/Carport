    <%@ page import="DBAccess.Carport_Mapper" %>
    <%@ page import="FunctionLayer.Fejl_haendtering" %><%--
    Created by IntelliJ IDEA.
    User: Lange
    Date: 20/04/2020
    Time: 12.31
    To change this template use File | Settings | File Templates.
    --%>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../indcludes/header.inc" %>
    <%!
    @Override
    public void jspInit() {
    try {

    Carport_Mapper.dropdown_Bredde();
    Carport_Mapper.dropdown_Laengde();
    Carport_Mapper.dropdown_Farve();
    Carport_Mapper.dropdown_Tagmatriale();
    Carport_Mapper.dropdown_Trae_type();
    Carport_Mapper.dropdown_Haeldning();
    Carport_Mapper.dropdown_Gulv();

    } catch (Fejl_haendtering e) {
    e.printStackTrace();
    }
    }
    %>

    <%
    request.setAttribute("gulv", Carport_Mapper.getDropdown_Gulv_List());
    request.setAttribute("bredde", Carport_Mapper.get_Dropdown_Bredde_List());
    request.setAttribute("laengde", Carport_Mapper.get_Dropdown_Laengde_List());
    request.setAttribute("farve", Carport_Mapper.get_Dropdown_Farve_List());
    request.setAttribute("traetype", Carport_Mapper.get_Dropdown_Traetype_List());
    request.setAttribute("tagmatriale", Carport_Mapper.getDropdown_Tagmatriale_List());
    request.setAttribute("haeldning", Carport_Mapper.getDropdown_Haeldning_List());


    %>
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
        <div>
    <form name="forespoergsel" action="FrontController" method="POST">
            <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Carport Bredde</label>
            <select class="form-control" name="bredde">
                <c:forEach var="bredde" begin="0" end="18" items="${bredde}">
                    <option value="${bredde.value.carportBreddeid}">${bredde.value.carportBredde}
                    </option>
                </c:forEach>
            </select>

        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Carport Længde</label>
        <select class="form-control" name="carportlaengde">
            <c:forEach var="laengde" begin="0" end="20" items="${laengde}">
                <option value="${laengde.value.carportLaengdeid}">${laengde.value.carportLaengde}
                </option>
            </c:forEach>
        </select>

        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Tag Type/farve</label>
        <select class="form-control" name="tagMateriale">
            <c:forEach var="tagmatriale" begin="0" end="14" items="${tagmatriale}">
                <option value="${tagmatriale.value.typeid}">${tagmatriale.value.type}
                </option>
            </c:forEach>
        </select>

        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Carport Farve</label>
        <select class="form-control" name="carportfarve">
            <c:forEach var="farve" items="${farve}">
                <option value="${farve.value.carportFarveid}">${farve.value.carportFarve}
                </option>
            </c:forEach>
        </select>

        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Carport Trætype</label>
        <select class="form-control" name="carporttraetype">
            <c:forEach var="traetype" begin="0" end="5" items="${traetype}">
                <option value="${traetype.value.carporttraeTypeid}">${traetype.value.carporttraeType}
                </option>
            </c:forEach>
        </select>

    <label class="mt-4">Taghældning</label>
    <select class="form-control" name="tagHaeldning">
        <c:forEach var="haeldning" begin="0" end="6" items="${haeldning}">
            <option value="${haeldning.value.haeldningid}">${haeldning.value.haeldning}%
             </option>
        </c:forEach>
    </select>
    <br>
    <br>
        <div class="mt-4">
        <label><input type ="checkbox" class="myCheckbox"  >Fravælg redskabsrum</label>
        </div>
        <div id="select_div">

    <p class="text2">
    Redskabsrum:<br>
        NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*
        <br>
        NB! Redskabsrummet må max være halvt så langt som carporten*
    <br>
    <br>
    </p>
        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Redskabsrum bredde</label>
        <select class="form-control"  name="redskabsrumsbredde">
            <c:forEach var="bredde" begin="0" end="19" items="${bredde}">
                <option value="${bredde.value.carportBreddeid}">${bredde.value.carportBredde}
                </option>
            </c:forEach>
        </select>

        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Redskabsrum Længde</label>
        <select class="form-control" name="redskabsrumslaengde">
            <c:forEach var="laengde" begin="0" end="8" items="${laengde}">
                <option value="${laengde.value.carportLaengdeid}">${laengde.value.carportLaengde}
                </option>
            </c:forEach>
        </select>

    <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Redskabsrum beklædnings type</label>
    <select class="form-control" name="redskabsrumbeklaedningstype">
    <c:forEach var="traetype" begin="0" end="5" items="${traetype}">
    <option value="${traetype.value.carporttraeTypeid}">${traetype.value.carporttraeType}
    </option>
    </c:forEach>
    </select>

            <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Redskabsrum gulv</label>
            <select class="form-control" name="redskabsrumGulv">
                <c:forEach var="gulv" begin="0" end="2" items="${gulv}">
                    <option value="${gulv.value.idGulv}">${gulv.value.gulv}
                    </option>
                </c:forEach>
            </select>
    </div>
    <br>
    <br>
    <br>
    <br>
        <div class='field'>
            <label for="navn">Navn:</label><br>
            <input style="width: 450px" type="text" id="navn" name="navn"><br>
        </div>
        <div class='field'>
            <label for="adresse">Adresse:</label><br>
            <input style="width: 450px" type="text" id="adresse" name="adresse"><br>
        </div>
        <div class='field'>
            <label for="pnr">Postnummer:</label><br>
            <input style="width: 450px" type="text" id="pnr" name="postNummer"><br>
        </div>
        <div class='field'>
            <label for="by">By:</label><br>
            <input style="width: 450px" type="text" id="by" name="by"><br>
        </div>
        <div class='field'>
            <label for="tlf">Telefon</label><br>
            <input style="width: 450px" type="text" id="tlf" name="tlf"><br>
        </div>
        <div class='field'>
            <label for="email">Email</label><br>
            <input style="width: 450px" type="email" id="email" name="email">
        </div>
        <div class='actions'>
            <input type="hidden" name="target" value="forespoergsel">
            <input  class="btn btn-sm btn-primary mt-2 btn-block" id="btnSubmit"  disabled="disabled" type="submit" value="Send Forespørgsel">
        </div>
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
        $(function () {
            $('.myCheckbox').change(function () {
                if ($(this).is(':checked')) {
                    $("div#select_div").hide();
                    $("div#select_div").children().prop('disabled', true);
                } else {
                    $("div#select_div").show();
                    $("div#select_div").children().prop('disabled', false);
                }
            });
        });

        $(document).ready(function() {
            $('.field input').keyup(function() {

                var empty = false;
                $('.field input').each(function() {
                    if ($(this).val().length == 0) {
                        empty = true;
                    }
                });

                if (empty) {
                    $('.actions input').attr('disabled', 'disabled');
                } else {
                    $('.actions input').attr('disabled', false);
                }
            });
        });
    </script>
    </body>
    </html>