<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../indcludes/header.inc" %>
<p class="text2">
Tak for din forespørgsel ${sessionScope.navn}, vi vil vende tilbage snarest!
    <br>
    Der er sendt en email til: ${sessionScope.email}
</p>
</body>
</html>
