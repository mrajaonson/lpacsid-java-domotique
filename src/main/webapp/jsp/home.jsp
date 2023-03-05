<%--
    Document   : home
    Created on : 21 févr. 2023, 14:38:52
    Author     : rajaonson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.javacnam.domotique.beans.MeteoDaily"%>
<%@ page import="fr.javacnam.domotique.beans.MeteoHourly"%>
<%@ page import="fr.javacnam.domotique.beans.Equipement"%>
<%@ page import="fr.javacnam.domotique.beans.TypeEquipement"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><jsp:include page="../css/bulma.min.css" /></style>
        <style><jsp:include page="../css/css.gg.css" /></style>
        <style><jsp:include page="../css/styles.css" /></style>
        <style><jsp:include page="../css/bootstrap-icons.css" /></style>
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
        <div class="columns m-3">
            <div class="column is-4">
                <div class="mb-5">
                    <article class="tile is-child notification is-info">
                        <div class="card-content">
                            <p class="title" id="currentDate"></p>
                        </div>
                    </article>
                </div>

                <%--Affichage des prévisions températures--%>
                <div class="mb-5">
                    <article class="tile is-child notification is-warning">
                        <p class="title">Température extérieure</p>
                        <table class="table" style="background-color: transparent;">
                            <%-- Récupération des données météo --%>
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
                </div>

                <div class="mb-5">
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
            </div>
            <div class="column">
                <%-- Récupération des types équipements --%>
                <% List<TypeEquipement> typesEquipement = (List<TypeEquipement>) request.getSession().getAttribute("typesEquipement"); %>
                <% List<Equipement> equipements = (List<Equipement>) request.getSession().getAttribute("userEquipements"); %>
                <div class="grid-container">
                    <% for (TypeEquipement typeEquipement : typesEquipement) {  %>
                    <div class="mr-3 mb-3">
                        <article class="tile is-child notification is-success">
                            <div class="content">
                                <p class="title"><%= typeEquipement.getType().toUpperCase() %></p>
                                <p class="subtitle"></p>
                                <div class="content">
                                    <% for (Equipement equipement : equipements) {
                                        if (equipement.getType().equals(typeEquipement.getType())) { %>
                                    <div class="columns">
                                        <% if (equipement.getType().equals("lumiere")) { %>
                                        <% String iconClass = equipement.getValeur() > 0 ? "bi bi-lightbulb-fill has-text-warning" : "bi bi-lightbulb-off";%>
                                        <div class="column is-1">
                                            <span class="icon">
                                                <i class="<%= iconClass %>" style="font-size: 1.8rem;"></i>
                                            </span>
                                        </div>
                                        <% } %>
                                        <div class="column">
                                            <%= equipement.getPiece() %> - <%= equipement.getNom() %>
                                        </div>
                                        <div class="column">
                                            <div class="buttons has-addons">
                                                <% String buttonClass1 = equipement.getValeur() > 0 ? "" : "is-info is-selected";
                                            String buttonClass2 = equipement.getValeur() > 0 ? "is-info is-selected" : "";%>
                                                <form action="Home" method="post">
                                                    <input type="hidden" name="<%= equipement.getId() %>" value="-" />
                                                    <button class="button is-small <%= buttonClass1 %>" type="submit" name="<%= equipement.getId() %>"></button>
                                                </form>
                                                <form action="Home" method="post">
                                                    <input type="hidden" name="<%= equipement.getId() %>" value="+" />
                                                    <button class="button is-small <%= buttonClass2 %>" type="submit" name="<%= equipement.getId() %>"></button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                    }
                                    }
                                    %>
                                </div>
                            </div>
                        </article>
                    </div>
                    <%
                      }
                    %>
                </div>
            </div>
        </div>

        <%-- FOOTER --%>
        <jsp:include page="footer.jsp" />
    </body>
</html>
