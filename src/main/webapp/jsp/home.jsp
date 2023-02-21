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
        <nav class="navbar is-info" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="Home">
                    <span class="icon">
                        <i class="gg-home" aria-hidden="true"></i>
                    </span>
                </a>

                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item">
                        Accueil
                    </a>

                    <a class="navbar-item">
                        Documentation
                    </a>


                    <a class="navbar-item">
                        A propos
                    </a>
                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <form method="post" action="Home">
                            <input type="hidden" name="action" value="deconnexion">
                            <button class="button is-light" type="submit">Déconnexion</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>
