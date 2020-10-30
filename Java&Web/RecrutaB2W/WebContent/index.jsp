<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Recruta B2W</title>
  <link rel="stylesheet" href="./css/global.css">
  <link rel="stylesheet" href="./css/index.css">
  <link href="./img/B2W_Digital_logo.png" rel="icon" type="image/x-icon" />

</head>

<body>

  <header>
    <figure>
      <a href="index.jsp"><img src="./img/B2W_Digital_logo.png" class="logo" alt=""></a> </figure>
    <span class="mobile-btn"></span>
    <nav class="menu-nav mobile-menu">
      <ul class="title-list">
        <li>
          <h1><a href="#sobre">Sobre a B2W</a></h1>
        </li>
        <li>
          <h1><a href="#problema">Problema</a></h1>
        </li>
        <li>
          <h1><a href="#solucao">SoluÃ§Ã£o</a></h1>
        </li>
        <li>
          <h1><a href="#contato">Contato</a></h1>
        </li>
      </ul>
    </nav>
  </header>

  <main class="general">

    <section class="content-background">

      <div class="saudacoes">
        <h1>OlÃ¡ B2W,<br /> somos
          <span class="txt-type" data-wait="3000" data-words='["desenvolvedores","entusiastas","a NextStep"]'></span>
        </h1>
      </div>

      <div class="slogan">
        <h2>
          Junto com vocÃª no seu prÃ³ximo passo!
        </h2>
      </div>

      <div class="buttons">
        <div class="saiba-mais">
          <a href="#sobre" class="btn-saiba-mais">SAIBA MAIS</a>
        </div>

        <button class="teste-sistema">
          <a href="login.jsp">Teste o sistema</a>
        </button>
      </div>

    </section>

    <section class="content-infos" id="sobre">
      <div class="content-infos__text">

        <div class="content-infos__text--visible">

          <h1>A B2W</h1>
          <h2>Um pouco sobre a maior empresa e-commerce brasileira</h2>

          <p>
            O propÃ³sito da B2W Ã© <strong>conectar pessoas, negÃ³cios, produtos e serviÃ§os em uma mesma plataforma
              digital</strong>. Por isso, a B2W Digital quer, cada vez mais, estar sempre prÃ³xima dos clientes,
            oferecendo
            a melhor experiÃªncia de compra e desenvolvendo os melhores talentos.
          </p>
        </div>

        <div class="content-infos__text--hidden">
          <p>
            LÃ­der na AmÃ©rica Latina, a B2W Digital tem um modelo de negÃ³cio Ãºnico, multicanal, multimarca e
            multinegÃ³cio.
            A Companhia atua nas seguintes frentes: e-commerce nas marcas Americanas.com, Submarino, Shoptime e Sou
            Barato; plataformas de serviÃ§os de crÃ©dito ao consumidor, com o Submarino Finance e o Digital Finance;
            plataforma de tecnologia; plataforma de logÃ­stica, distribuiÃ§Ã£o e atendimento ao cliente; e Marketplace.
          </p>

          <p>
            VocÃª pode conhecer mais detalhes sobre a Companhia no site <a href="https://ri.b2w.digital/">
              <strong>www.b2wdigital.com</strong></a>
          </p>
        </div>

        <button class="content-infos__text--button">
          Leia Mais
        </button>

      </div>

      <figure class="content-infos__image">
        <img src="./img/ecommerce.gif" class="ecommerce" alt="">
      </figure>
    </section>

    <section class="content-infos" id="problema">
      <div class="content-infos__text">
        <div class="content-infos__text--visible">
          <h1>Problema</h1>
          <h2>
            Atuaremos no recrutamento, apÃ³s o algoritmo de filtragem e antes da entrevista.
          </h2>

          <p>
            Existe uma lacuna nessa entre a filtragem e a entrevista, onde a companhia tem uma visÃ£o que contempla
            <i>hard
              skills</i>, sem conhecer traÃ§os da personalidade do candidato.
          </p>
        </div>

        <div class="content-infos__text--hidden">

          <p>
            Isso gera uma pressÃ£o no recrutador jÃ¡ que a entrevista, que Ã© um espaÃ§o de tempo curto, Ã© o principal
            momento
            para se ter um contato mais pessoal com o candidato.
          </p>

          <p>AlÃ©m disso, o recrutador tambÃ©m deve verificar informaÃ§Ãµes bÃ¡sicas sobre o candidato na hora da entrevista,
            o
            que acaba reduzindo o tempo Ãºtil da entrevista, alÃ©m de sua qualidade.</p>
          <p>
        </div>

        <button class="content-infos__text--button">
          Leia Mais
        </button>

      </div>

      <figure class="content-infos__image">
        <img src="./img/7-most-common-mistakes.png" alt="">
      </figure>

    </section>

    <section class="content-infos" id="solucao">
      <div class="content-infos__text">

        <div class="content-infos__text--visible">
          <h1>SoluÃ§Ã£o - Recruta B2W</h1>

          <h2>
            Queremos coletar informaÃ§Ãµes sobre as <i>soft skills</i> do candidato, antes da entrevista, e atravÃ©s de um
            app
          </h2>


          <p>
            Essa informaÃ§Ãµes coletadas serÃ£o disponibilizadas para o recrutamento a fim de proporcionar uma visÃ£o mais
            ampla sobre o candidato.
          </p>
        </div>


        <div class="content-infos__text--hidden">
          <p>
            Algumas respostas bÃ¡sicas de entrevista tambÃ©m serÃ£o coletadas, permitindo assim ao recrutador focar-se em
            detalhes, ou em questÃµes que nÃ£o foram abordadas no app.
          </p>


          <p>
            O app contarÃ¡ com um teste de personalidade, um chatbot para a coleta geral de informaÃ§Ãµes referentes Ã 
            entrevista, e um vÃ­deo de apresentaÃ§Ã£o, o qual terÃ¡ tanto vÃ­deo quanto Ã¡udio analisados por um algoritmo de
            detecÃ§Ã£o de modos de fala e de emoÃ§Ãµes.
          </p>
        </div>

        <button class="content-infos__text--button">
          Leia Mais
        </button>

      </div>

      <figure class="content-infos__image">
        <img src="./img/interviews-e1433244493315.jpg" alt="" class="curriculo">
      </figure>

    </section>

    <section class="carousel">
    </section>

    <section class="content-infos" id="integrantes">

      <div class="content-infos__text">
        <h1>Integrantes:</h1>

        <h2>Turma: 1Âº TDST | NextStep</h2>

        <ul>
          <li>Celso L. da Silva Filho, <br />RM 86158 - <strong>Banco de dados.</strong> </li>
          <li>Eduardo VinÃ­cius B. Costa, <br />RM 85915 - <strong>Front-end.</strong> </li>
          <li>Guilherme R. De Souza, <br />RM 85499 - <strong>Back-end.</strong> </li>
          <li>Rogerio Pizzo dos Santos, <br /> RM 84088 - <strong>Infraestrutura.</strong> </li>
          <li>William Butler Poletto, <br /> RM 85008 - <strong>GestÃ£o.</strong></li>
        </ul>
      </div>
    </section>

    <section class="contato" id="contato">

      <div class="title">
        <h1>Contate-nos!</h1>
      </div>

      <form class="contato__form">

        <div class="secao">
          <label for="nome">Nome:</label>
          <input type="text" name="" id="nome" placeholder="Nome">
        </div>


        <div class="secao">
          <label for="emaik">Email:</label>
          <input type="text" name="" id="email" placeholder="Email">
        </div>

        <div class="secao">
          <label for="telefone">Telefone:</label>
          <input type="text" name="" id="telefone" placeholder="Telefone">
        </div>

        <div class="secao">
          <label for="emaik">Assunto:</label>
          <input type="text" name="" id="assunto" placeholder="Assunto">
        </div>

        <div class="msg">
          <label for="mensagem">Mensagem:</label>
          <textarea name="" id="mensagem" cols="30" rows="10" placeholder="Mensagem"></textarea>
          <button type="submit" class="btn-enviar">Enviar</button>
        </div>

      </form>
    </section>

    <section class="credits">

      <figure>

        <a href="https://www.fiap.com.br/" target="_blank"><img class="fiap-logo" src="./img/fiap-logo.png" alt=""></a>


      </figure>

    </section>


  </main>


  <div class="c-scroll-up">
    <img src="img/arrow-up.png" alt="">
  </div>

  <%@ include file="./WEB-INF/snippets/footer.html" %>
  <%@ include file="./WEB-INF/snippets/imports/libs-footer.jsp" %>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
  <script src="https://smtpjs.com/v3/smtp.js"></script>
  <script type="text/javascript" src="js/index.js"></script>

</body>

</html>