<%--
    Document   : home
    Created on : 21 févr. 2023, 14:38:52
    Author     : rajaonson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><jsp:include page="../css/bulma.min.css" /></style>
        <style><jsp:include page="../css/css.gg.css" /></style>
        <title>Home</title>
    </head>
    <body>
        <%-- HEADER --%>
        <jsp:include page="header.jsp" />

        <%-- affichage js date et heure --%>
        <script>
            function afficherDate() {
                const now = new Date();
                const date = now.toLocaleString();
                document.getElementById("currentDate").innerHTML = date;
            }

            setInterval(afficherDate, 1000);
        </script>

        <%-- CONTENU --%>
        <div class="tile is-ancestor m-3">
            <div class="tile is-vertical is-8">
                <div class="tile">
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-primary">
                            <div class="card-content">
                                <p class="title" id="currentDate"></p>
                            </div>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Température extérieure</p>
                            <p>Aujourd'hui</p>
                            <p>Min : ${meteoDaily.getTemperatureMin()}°C</p>
                            <p>Max : ${meteoDaily.getTemperatureMax()}°C</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Ephémérides</p>
                            <p>
                                <span class="icon">
                                    <i class="gg-sun"></i>
                                </span>
                                <span> ${meteoDaily.getSunrise()}</span>
                            </p>
                            <p>
                                <span class="icon">
                                    <i class="gg-moon"></i>
                                </span>
                                <span>${meteoDaily.getSunset()}</span>
                            </p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child notification is-info">
                            <p class="title">Lumières</p>
                            <p class="subtitle"></p>
                        </article>
                    </div>
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child notification is-success">
                        <p class="title">...</p>
                        <p class="subtitle"></p>
                        <div class="content">
                            <!-- Content -->
                        </div>
                    </article>
                </div>
            </div>
            <div class="tile is-parent">
                <article class="tile is-child notification is-success">
                    <div class="content">
                        <p class="title">...</p>
                        <p class="subtitle"></p>
                        <div class="content">
                            <!-- Content -->
                        </div>
                    </div>
                </article>
            </div>
        </div>

        <%-- FOOTER --%>
        <jsp:include page="footer.jsp" />
    </body>
</html>
