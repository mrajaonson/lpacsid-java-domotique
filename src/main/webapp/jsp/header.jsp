<%-- 
    Document   : header
    Created on : 21 févr. 2023, 22:15:49
    Author     : rajaonson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                Configuration
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
