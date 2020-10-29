<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<%@ include file="./WEB-INF/snippets/imports/libs-head.jsp" %>
    <title>Recruta B2W</title>
    <link rel="stylesheet" href="./css/login.css">
</head>

<body>

    <header>
        <figure>
            <a href="index.html"><img src="./img/B2W_Digital_logo.png" class="logo" alt=""></a>
        </figure>
        <span class="mobile-btn"></span>
        <nav class="menu-nav mobile-menu">
        </nav>
    </header>
    <div class="general">
        <div class="login">
            <h2>Login de Acesso</h2>
            <form action="">
                <div class="field">
                    <label for="idmail">E-mail:*</label>
                    <input type="text" name="cpmail" id="IDMAIL" placeholder="Digite seu e-mail" required="required">
                </div>

                <div class="field">
                    <label for="idpass">Senha:*</label>
                    <div class="input-password">
                        <input type="password" id="pass" placeholder="Digite sua senha">
                        <img src="./img/olho.webp" id="olho" class="olho">
                    </div>
                </div>

                <div class="acessar">
                    <input type="submit" value="Acessar" class="btn-acessar">
                </div>
            </form>
        </div>
    </div>
    <%@ include file="./WEB-INF/snippets/footer.html" %>
    <%@ include file="./WEB-INF/snippets/imports/libs-footer.jsp"%>
    <script type="text/javascript" src="js/login.js"></script>
</body>

</html>