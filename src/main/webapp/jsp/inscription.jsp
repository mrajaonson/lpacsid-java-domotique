<%-- 
    Document   : inscription
    Created on : 8 mars 2023, 15:41:45
    Author     : rajaonson
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><jsp:include page="../css/bulma.min.css" /></style>
        <style><jsp:include page="../css/bootstrap-icons.css" /></style>
        <style><jsp:include page="../css/style-footer.css" /></style>
        <title>Auth</title>
    </head>
    <body>
        <%-- HEADER --%>
        <jsp:include page="header-auth.jsp" />

        <div class="container" style="width: 30%; margin-top: 5em">
            <form class="box" action="Inscription" method="post">
                <h1 class="title">Créer un compte</h1>
                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="text" id="login" name="login" required placeholder="Saisir un nom d'utilisateur">
                        <span class="icon is-left">
                            <i class="bi bi-person" style="font-size: 2rem;"></i>
                        </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="password" id="pass" name="pass" required placeholder="Saisir un mot de passe">
                        <span class="icon is-small is-left">
                            <i class="bi bi-lock" style="font-size: 1.8rem;"></i>
                        </span>
                    </p>
                </div>
                <input class="button is-success" type="submit" value="Valider" name="inscription">
            </form>
        </div>

        <%-- FOOTER --%>
        <jsp:include page="footer.jsp" />
    </body>
</html>

