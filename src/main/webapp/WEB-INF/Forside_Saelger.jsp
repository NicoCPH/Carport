<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header1.inc" %>

<br>
<br>
<div class="container">
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

            <table class="table table-striped table-responsive">
                <thead>
                <tr>
                    <th scope="col">ID:</th>
                    <th scope="col">Navn:</th>
                    <th scope="col">Email:</th>
                    <th scope="col">Længde:</th>
                    <th scope="col">Bredde:</th>
                    <th scope="col">Redskab:</th>
                    <th scope="col">Adresse:</th>
                    <th scope="col">By:</th>
                    <th scope="col">Postnummer:</th>
                    <th scope="col">Hældning:</th>
                    <th scope="col">Pris:</th>
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
                        </c:otherwise>
                    </c:choose></td>
                    <td>${show.adresse}</td>
                    <td>${show.kundeby}</td>
                    <td>${show.kundepostnummer}</td>
                    <td>${show.haeldning}</td>
                    <td>${show.pris}</td>
                    <td><button  class="btn btn-sm mt-2 toggler" vis_data="${show.id}" style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 150px" >
                    Opdater pris</button></td>
                </tr>
                <input type="hidden" name="target" value="Opdater_pris">
                <tr class="vis${show.id}" style="display:none">
                    <td></td>
                    <td><label>
                        <input name="pris" type="number" class="form-control mb-3">
                        <button name="id"  value="${show.id}" class="btn btn-sm mt-2"  style="background-color: #0c2069; color: #C0C0C0; font-weight: bold; width: 150px" >
                            Opdater pris</button>
                    </label></td>

                </tr>
                </tbody>
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
</script>
</body>
</html>
