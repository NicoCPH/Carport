    <%@ page import="DBAccess.CarportMapper" %>
    <%@ page import="FunctionLayer.Fejl_haendtering" %>
    <%@ page import="FunctionLayer.Objekter.Carport" %><%--
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
     CarportMapper.dropdownBredde();
     CarportMapper.dropdownLaengde();
     CarportMapper.dropdownFarve();
     CarportMapper.dropdownTagmatriale();
     CarportMapper.dropdownTraetype();
     CarportMapper.dropdownGulv();
    } catch (Fejl_haendtering e) {
        e.printStackTrace();
    }
    }
    %>

        <%

        request.setAttribute("gulv", CarportMapper.getDropdown_Gulv_List());
        request.setAttribute("bredde", CarportMapper.get_Dropdown_Bredde_List());
        request.setAttribute("laengde", CarportMapper.get_Dropdown_Laengde_List());
        request.setAttribute("farve", CarportMapper.get_Dropdown_Farve_List());
        request.setAttribute("traetype", CarportMapper.get_Dropdown_Traetype_List());
        request.setAttribute("tagmatriale", CarportMapper.getDropdown_Tagmatriale_List());


        %>
    <div class="icon1">
    <img src="images/fladt%20tag.jpg">
    </div>
    <div>
    <p class="text2 uppercase">
    QUICK-BYG TILBUD - CARPORT MED FLADT TAG<br>
    </p>
    <p class="text2">
    <br>
    Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
    <br><br>
    Tilbud og skitsetegning fremsendes med post hurtigst muligt.
    Ved bestilling medfølger standardbyggevejledning.
    <br><br>
    Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"
    Felter markeret * SKAL udfyldes!
    <br>
    <br>
    <br>
    Ønsket carport mål:
    </p>
    <br>
    <br>
    <br>
    </div>


    <div class="container col-lg-5">
    <div>
    <form name="forespoergsel" action="FrontController" method="POST">
       <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Carport Bredde</label>
       <select class="form-control" name="bredde">
           <c:forEach var="bredde" items="${bredde}">
               <option value="${bredde.value.carportBreddeid}">${bredde.value.carportBredde}
               </option>
           </c:forEach>
       </select>

    <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Carport Længde</label>
    <select class="form-control" name="carportlaengde">
    <c:forEach var="laengde" items="${laengde}">
        <option value="${laengde.value.carportLaengdeid}">${laengde.value.carportLaengde}
        </option>
    </c:forEach>
    </select>

    <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Tag Type</label>
    <select class="form-control" name="tagMateriale">
    <c:forEach var="tagmatriale" begin="15" end="15" items="${tagmatriale}">
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
            <c:forEach var="traetype" items="${traetype}">
                <option value="${traetype.value.carporttraeTypeid}">${traetype.value.carporttraeType}
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
            <c:forEach var="bredde" begin="0" end="20" items="${bredde}">
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
            <c:forEach var="traetype" items="${traetype}">
                <option value="${traetype.value.carporttraeTypeid}">${traetype.value.carporttraeType}
                </option>
            </c:forEach>
        </select>

        <label class="mt-4" style="background-color: white;color: #5f5f5f; font-weight: bold">Redskabsrum gulv</label>
        <select class="form-control" name="redskabsrumGulv">
            <c:forEach var="gulv" items="${gulv}">
                <option value="${gulv.value.idGulv}">${gulv.value.gulv}
                </option>
            </c:forEach>
        </select>
    </div>
    <br>
    <br>
    <br>
    <br>
    <label for="navn">Navn:</label><br>
    <input style="width: 450px" type="text" id="navn" name="navn"><br>

    <label for="adresse">Adresse:</label><br>
    <input style="width: 450px" type="text" id="adresse" name="adresse"><br>

    <label for="pnr">Postnummer:</label><br>
    <input style="width: 450px" type="text" id="pnr" name="postNummer"><br>

    <label for="by">By:</label><br>
    <input style="width: 450px" type="text" id="by" name="by"><br>

    <label for="tlf">Telefon</label><br>
    <input style="width: 450px" type="text" id="tlf" name="tlf"><br>

    <label for="email">Email</label><br>
    <input style="width: 450px" type="email" id="email" name="email">
       <input type="hidden" name="target" value="forespoergsel">
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
    </script>
    </body>
    </html>