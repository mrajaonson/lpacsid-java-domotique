<%--
    Document   : home
    Created on : 21 févr. 2023, 14:38:52
    Author     : rajaonson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.javacnam.domotique.beans.MeteoDaily"%>
<%@ page import="fr.javacnam.domotique.beans.MeteoHourly"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><jsp:include page="../css/bulma.min.css" /></style>
        <style><jsp:include page="../css/css.gg.css" /></style>
        <style><jsp:include page="../css/styles.css" /></style>
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
            
            window.addEventListener('load', afficherDate);
            setInterval(afficherDate, 1000);
        </script>

        <%-- CONTENU --%>
        <div class="m-5">
            <%-- Rangée 1 --%>
            <div class="tile is-ancestor">
                <div class="tile is-vertical is-8">
                    <div class="tile">
                        <div class="tile is-parent is-vertical">
                            <article class="tile is-child notification is-primary">
                                <div class="card-content">
                                    <p class="title" id="currentDate"></p>
                                </div>
                            </article>
                            <%--Affichage des prévisions températures--%>
                            <article class="tile is-child notification is-warning">
                                <p class="title">Température extérieure</p>
                                <table class="table" style="background-color: transparent;">
                                    <% List<MeteoDaily> prevMeteoDaily = (List<MeteoDaily>) request.getSession().getAttribute("previsionMeteoDaily"); %>
                                    <thead>
                                        <tr>
                                            <th></th>
                                                <% for (MeteoDaily meteoDailyTH : prevMeteoDaily) { %>
                                            <td><%= meteoDailyTH.getFormattedTime() %></td>
                                            <%
                                              }
                                            %>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th>Min</th>
                                                <% for (MeteoDaily meteoDailyMin : prevMeteoDaily) {  %>
                                            <td><%= meteoDailyMin.getTemperatureMin() %></td>
                                            <%
                                              }
                                            %>
                                        </tr>
                                        <tr>
                                            <th>Max</th>
                                                <% for (MeteoDaily meteoDailyMax : prevMeteoDaily) {  %>
                                            <td><%= meteoDailyMax.getTemperatureMax() %></td>
                                            <%
                                              }
                                            %>
                                        </tr>
                                    </tbody>
                                </table>

                                <p>Par heure</p>

                                <%--Affichage météo du jour--%>
                                <div class="table-container" style="width: 25em;">
                                    <table class="table" style="background-color: transparent;">
                                        <% List<MeteoHourly> dailyMeteoHourly = (List<MeteoHourly>) request.getSession().getAttribute("dailyMeteoHourly"); %>
                                        <thead>
                                            <tr>
                                                <th></th>
                                                    <% for (MeteoHourly meteoHourlyTH : dailyMeteoHourly) { %>
                                                <td><%= meteoHourlyTH.getFormattedTime() %></td>
                                                <%
                                                  }
                                                %>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th></th>
                                                    <% for (MeteoHourly meteoHourlyTD : dailyMeteoHourly) {  %>
                                                <td><%= meteoHourlyTD.getTemperature() %></td>
                                                <%
                                                  }
                                                %>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </article>

                            <%--Affichage des éphémérides--%>
                            <article class="tile is-child notification is-warning">
                                <p class="title">Ephémérides</p>
                                <table class="table" style="background-color: transparent;">
                                    <thead>
                                        <tr>
                                            <th></th>
                                                <% for (MeteoDaily meteoDailySun : prevMeteoDaily) { %>
                                            <td><%= meteoDailySun.getFormattedTime() %></td>
                                            <%
                                              }
                                            %>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th>
                                                <span class="icon">
                                                    <i class="gg-sun"></i>
                                                </span>
                                            </th>
                                            <% for (MeteoDaily meteoDailySunrise : prevMeteoDaily) {  %>
                                            <td><%= meteoDailySunrise.getSunrise() %></td>
                                            <%
                                              }
                                            %>
                                        </tr>
                                        <tr>
                                            <th>
                                                <span class="icon">
                                                    <i class="gg-moon"></i>
                                                </span>
                                            </th>
                                            <% for (MeteoDaily meteoDailySunset : prevMeteoDaily) {  %>
                                            <td><%= meteoDailySunset.getSunset() %></td>
                                            <%
                                              }
                                            %>
                                        </tr>
                                    </tbody>
                                </table>
                            </article>
                        </div>
                        <div class="tile is-parent">
                            <article class="tile is-child notification is-info">
                                <p class="title">Volets</p>
                                <p class="subtitle"></p>
                            </article>
                        </div>
                    </div>
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child notification is-success">
                        <div class="content">
                            <p class="title">Lumières</p>
                            <p class="subtitle"></p>
                            <div class="content">
                                <!-- Content -->
                            </div>
                        </div>
                    </article>
                </div>
            </div>
            <%-- Rangée 2 --%>
            <div class="tile is-ancestor">
                <div class="tile is-parent">
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child notification is-success">
                        <div class="content">
                            <p class="title">Automatisation</p>
                            <p class="subtitle"></p>
                            <div class="content">
                                <!-- Content -->
                            </div>
                        </div>
                    </article>
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child notification is-success">
                        <div class="content">
                            <p class="title">Chauffage</p>
                            <p class="subtitle"></p>
                            <div class="content">
                                <!-- Content -->
                            </div>
                        </div>
                    </article>
                </div>
            </div>

        </div>

        <%-- FOOTER --%>
        <jsp:include page="footer.jsp" />
    </body>
</html>
