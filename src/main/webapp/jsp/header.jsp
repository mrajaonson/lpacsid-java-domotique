<%-- 
    Document   : header
    Created on : 21 févr. 2023, 22:15:49
    Author     : rajaonson
--%>

<style><jsp:include page="../css/bootstrap-icons.css" /></style>
<nav class="navbar is-info" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="Home">
            <span class="icon">
                <i class="bi bi-house-door" style="font-size: 2rem"></i>
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
            <a class="navbar-item" href="Home">
                Accueil
            </a>

            <a class="navbar-item" href="Configuration">
                Configuration
            </a>


            <a class="navbar-item">
                A propos
            </a>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <form class="mr-3" method="post" action="Home">
                    <input type="hidden" name="action" value="fetchdata">
                    <button class="button is-info" type="submit">
                        <span class="icon is-small">
                            <i class="bi bi-arrow-repeat" style="font-size: 2rem"></i>
                        </span>
                    </button>
                </form>
                <form method="post" action="Home">
                    <input type="hidden" name="action" value="deconnexion">
                    <button class="button is-light" type="submit">Déconnexion</button>
                </form>
            </div>
        </div>
    </div>
</nav>
