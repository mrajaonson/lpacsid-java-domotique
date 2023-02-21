<%-- 
    Document   : auth
    Created on : 21 févr. 2023, 11:20:54
    Author     : rajaonson
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><jsp:include page="../css/bulma.min.css" /></style>
        <style><jsp:include page="../css/css.gg.css" /></style>
        <title>Auth</title>
    </head>
    <body>
        <div class="container" style="width: 30%; margin-top: 5em">
            <form class="box" action="Auth" method="post">
                <h1 class="title">Connexion</h1>
                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="text" id="login" name="login" required placeholder="Login">
                        <span class="icon is-left">
                            <i class="gg-user"></i>
                        </span>
                    </p>
                </div>
                <div class="field">
                    <p class="control has-icons-left">
                        <input class="input" type="password" id="pass" name="pass" required placeholder="Mot de passe">
                        <span class="icon is-small is-left">
                            <i class="gg-lock"></i>
                        </span>
                    </p>
                </div>
                <input class="button is-success" type="submit" value="Se connecter" name="connexion">
            </form>
        </div>
    </body>
</html>
