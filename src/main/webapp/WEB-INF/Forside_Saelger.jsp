<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header1.inc" %>

<br>
<br>

<div class="container">

    <a class="btn btn-block btn-primary text-center btn-sm" style="width:150px; left: 1%; position: absolute"
       href="FrontController?target=redirect&destination=index">Til Forsiden</a>

<form name="Vis_forespoergsel" action="FrontController" method="POST" class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal align">Vis forespørgsel via Email</h1>
<label for="inputEmailEditUser" class="sr-only">Email address</label>
<input name="email" value="kunde@cph.dk" type="email" id="inputEmailEditUser" class="form-control mb-3"
       placeholder="Email adresse" required autofocus>
<input type="hidden" name="target" value="Vis_forespoergsel">
<button class="btn btn-sm bg-primary btn-primary btn-block text-center" type="submit">Vis Forespørgesler</button>
</form>

<br>



        <div class="container">


        <!-- Show all orders to a specific customer -->
        <form name="Opdater_pris" action="FrontController" method="POST">
        <c:forEach var="show" items="${showorders}">

            <table class="table table-hover table-bordered border-dark table-responsive">
                <thead class="thead-light">
                <tr>
                    <th scope="col">ID:</th>
                    <th scope="col">Navn:</th>
                    <th scope="col">Email:</th>
                    <th scope="col">Længde:</th>
                    <th scope="col">Bredde:</th>
                    <th scope="col">Redskab:</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${show.id}</td>
                    <td>${show.navn}</td>
                    <td>${show.kundeemail}</td>
                    <td>${show.laengde}</td>
                    <td>${show.bredde}</td>
                    <td><c:choose>
                        <c:when test="${show.gulv.equals('0')}">
                            Intet redskab
                        </c:when>
                        <c:otherwise>
                            Med redskab
                <thead class="thead-light">
                    <th scope="col">Redskab Længde:</th>
                    <th scope="col">Redskab Bredde:</th>
            </thead>
                    <td>${show.redskab_laengde}</td>
                    <td>${show.redskabs_bredde}</td>


                        </c:otherwise>
                    </c:choose>
                <thead class="thead-light">
                <th scope="col">Postnummer:</th>
                <th scope="col">Hældning:</th>
                <th scope="col">Pris:</th>
                </thead>
                    <td>${show.kundepostnummer}</td>
                    <td>${show.haeldning}</td>
                    <td>${show.pris}</td>
                    <td><button  class="btn btn-sm mt-2 toggler" vis_data="${show.id}" style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 150px" >
                    Opdater pris</button></td>

                <input type="hidden" name="target" value="Opdater_pris">
                <tr class="vis${show.id}" style="display:none">
                    <td></td>
                    <td><label> Indtast ny pris
                        <input name="pris" type="text" class="form-control mb-3">
                        <input type="hidden" name="alto" value="${show.pris}"/>
                        <span>Pris forskel:</span>
                        <input type="text" name="ml" />
                        <button name="id"  value="${show.id}" class="btn btn-sm mt-2"  style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 150px" >
                            Opdater</button>
                    </label></td>

                </tr>

            </table>
            </form>
        </c:forEach>
        <!-- End table -->

    </div>
</div>

<script>

    $(document).ready(function(){
        $(".toggler").click(function(e){
            e.preventDefault();
            $('.vis'+$(this).attr('vis_data')).toggle();
        });
    });
    $(document).ready(function(){
        $(".toggler").click(function(e){
            e.preventDefault();
            $('.show'+$(this).attr('show_data')).toggle();
        });
    });


</script>
<script>
    $(':input').bind('keypress keydown keyup change',function(){
        var acho = parseFloat($(':input[name="pris"]').val()),
            alto = parseFloat($(':input[name="alto"]').val());

        var v = '';
        if (!isNaN(acho) && !isNaN(alto)){
            v = (acho - alto);
        }
        $(':input[name="ml"]').val(v.toString());
    });
</script>
</body>
</html>
