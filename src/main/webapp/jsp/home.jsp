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
        <!--HEADER-->
        <jsp:include page="header.jsp" />

        <!--CONTENU-->
        <div class="tile is-ancestor m-3">
            <div class="tile is-vertical is-8">
                <div class="tile">
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-primary">
                            <div class="card-content">
                                <p class="title">${currentDate}</p>
                            </div>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Température extérieure</p>
                            <p class="subtitle"></p>
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

        <!--footer-->
        <jsp:include page="footer.jsp" />
    </body>
</html>
