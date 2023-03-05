<%-- 
    Document   : configuration
    Created on : 23 févr. 2023, 19:17:42
    Author     : rajaonson
--%>

<%@ page import="java.util.List" %>
<%@ page import="fr.javacnam.domotique.beans.Piece"%>
<%@ page import="fr.javacnam.domotique.beans.Equipement"%>
<%@ page import="fr.javacnam.domotique.beans.TypeEquipement"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><jsp:include page="../css/bulma.min.css" /></style>
        <style><jsp:include page="../css/css.gg.css" /></style>
        <style><jsp:include page="../css/styles.css" /></style>
        <title>Configuration</title>
    </head>
    <body>
        <%-- HEADER --%>
        <jsp:include page="header.jsp" />

        <%--Modal nouvelle pièce--%>
        <div id="ajout-piece-modal" class="modal">
            <div class="modal-background"></div>
            <div class="modal-content">
                <%-- Ajout d'une nouvelle pièce --%>
                <div class="card m-4">
                    <div class="card-content">
                        <form action="Configuration" method="post">
                            <h4 class="title is-4">Ajouter une nouvelle pièce</h4>
                            <div class="field">
                                <label class="label">Nom de la pièce</label>
                                <input class="input" type="text" id="nomPiece" name="nomPiece" required>
                            </div>
                            <input class="button is-success" type="submit" value="Ajouter" name="ajouterPiece">
                            <input class="button modal-close-button" type="reset" value="Annuler">
                        </form>
                    </div>
                </div>
            </div>

            <button class="modal-close is-large" aria-label="close"></button>
        </div>

        <%--Ajout équipement modal--%>
        <div id="ajout-equipement-modal" class="modal">
            <div class="modal-background"></div>
            <div class="modal-content">
                <%-- Ajout d'une nouvelle pièce --%>
                <div class="card m-4">
                    <div class="card-content">
                        <form action="Configuration" method="post">
                            <h4 class="title is-4">Ajouter un nouvel équipement</h4>
                            <div class="field">
                                <label class="label">Choisir une pièce</label>
                                <div class="select">
                                    <select name="pieceEquipement" id="piece" required>
                                        <%
                                            List<Piece> piecesOption = (List<Piece>) request.getSession().getAttribute("userPieces");
                                            for (Piece piece : piecesOption) {
                                        %>
                                        <option><%= piece.getNom() %></option>
                                        <%
                                          }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Choisir le type d'équipement</label>
                                <div class="select">
                                    <select name="typeEquipement" id="type" required>
                                        <%
                                            List<TypeEquipement> typesEquipement = (List<TypeEquipement>) request.getSession().getAttribute("typesEquipement");
                                            for (TypeEquipement typeEquipement : typesEquipement) {
                                        %>
                                        <option><%= typeEquipement.getType() %></option>
                                        <%
                                          }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Nom de l'équipement</label>
                                <input class="input" type="text" id="nomEquipement" name="nomEquipement" required>
                            </div>
                            <input class="button is-success" type="submit" value="Ajouter" name="ajouterEquipement">
                            <input class="button modal-close-button" type="reset" value="Annuler">
                        </form>
                    </div>
                </div>
            </div>

            <button class="modal-close is-large" aria-label="close"></button>
        </div>

        <button class="js-modal-trigger button is-primary m-4" data-target="ajout-piece-modal">
            Ajouter une nouvelle pièce
        </button>

        <button class="js-modal-trigger button is-primary m-4" data-target="ajout-equipement-modal">
            Ajouter un nouvel équipement
        </button>

        <script><jsp:include page="../js/modal.js" /></script>

        <%-- Liste des pièces et équipements --%>
        <div class="columns">
            <%--Liste des pièces--%>
            <div class="column m-4 is-4">
                <h2 class="title is-2">Liste des pièces</h2>
                <%
                  List<Piece> pieces = (List<Piece>) request.getSession().getAttribute("userPieces");
                  for (Piece piece : pieces) {
                %>
                <div class="card m-2">
                    <div class="card-content">
                        <div class="columns is-vcentered">
                            <div class="column">
                                <%= piece.getNom() %>
                            </div>
                            <form class="mr-3" method="post" action="Configuration">
                                <input type="hidden" name="deletePiece" value="<%= piece.getId() %>">
                                <button class="button is-danger" type="submit" name="deletePiece">
                                    <span class="icon is-small">
                                        <i class="gg-trash"></i>
                                    </span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <%
                  }
                %>
            </div>

            <%--Liste des équipements--%>
            <div class="column m-4 is-4">
                <h2 class="title is-2">Liste des équipements</h2>
                <%
                  List<Equipement> equipements = (List<Equipement>) request.getSession().getAttribute("userEquipements");
                  for (Equipement equipement : equipements) {
                %>
                <div class="card m-2">
                    <div class="card-content">
                        <div class="columns is-vcentered">
                            <div class="column">
                                <%= equipement.getPiece() %> - <%= equipement.getNom() %>
                            </div>
                            <form class="mr-3" method="post" action="Configuration">
                                <input type="hidden" name="deleteEquipement" value="<%= equipement.getId() %>">
                                <button class="button is-danger" type="submit" name="deleteEquipement">
                                    <span class="icon is-small">
                                        <i class="gg-trash"></i>
                                    </span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <%
                  }
                %>
            </div>
        </div>

        <%-- FOOTER --%>
        <jsp:include page="footer.jsp" />
    </body>
</html>
