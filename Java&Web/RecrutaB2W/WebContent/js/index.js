console.log("foi")

document.addEventListener('DOMContentLoaded',init);

function init(){
  const txtElement = document.querySelector('.txt-type');
  const words = JSON.parse(txtElement.getAttribute('data-words'));
  const wait = txtElement.getAttribute('data-wait');

  new TypeWriter(txtElement,words,wait);
}

const TypeWriter = function(txtElement,words,wait = 3000){
  this.txtElement = txtElement;
  this.words = words;
  this.txt = "";
  this.wordIndex = 0;
  this.wait = parseInt(wait,10);
  this.type();
  this.isDeleting = false;
}

TypeWriter.prototype.type = function(){
  
  const current = this.wordIndex % this.words.length;

  const fulltxt = this.words[current];
  const last = this.words[this.words.length-1];

  if(this.isDeleting){
    this.txt = fulltxt.substring(0,this.txt.length-1)
  }

  else{
    this.txt = fulltxt.substring(0,this.txt.length+1)
  }


  this.txtElement.innerHTML = `<span class="txt">${this.txt}</span>`;

  let typeSpeed = 100;

  if(this.isDeleting){
    typeSpeed /= 2; 
  }

  if(!this.isDeleting && this.txt === fulltxt){
    typeSpeed = this.wait;
    this.isDeleting = true;
  }

  else if(this.isDeleting && this.txt ===''){ 
    this.isDeleting = false;
    this.wordIndex++;
    typeSpeed = 200; //velocidade de digitação
  }  

  setTimeout(() => this.type(), typeSpeed); 
}

$(".carousel").slick({
  lazyLoad: 'ondemand',
  dots:true,
  arrows:true,
  autoplay:5000,
  infinite:true
})

const mobileButton = document.querySelector('.mobile-btn');
mobileButton.onclick = function() {
  this.classList.toggle('active');
  document.querySelector('.mobile-menu').classList.toggle('active');
}

const menuItems = document.querySelectorAll('a[href^="#"]');
const voltarTopo = document.querySelector(".logo");

voltarTopo.addEventListener("click", function(){
  window.scroll({
    top:0,
    behavior:"smooth",
  })
})

var scrollBtn = $(".c-scroll-up")
var formOffset = $("form").offset().top
var formHeight = $("form").innerHeight()


$(window).scroll(function() {
    if ($(window).scrollTop() > formOffset - formHeight) {
      scrollBtn.addClass('is--active');
    } else {
      scrollBtn.removeClass('is--active');
    }
});
  
scrollBtn.on('click', function(e) {
  e.preventDefault();
  $('html, body').animate({scrollTop:0}, '500');
});


menuItems.forEach(item => {
  item.addEventListener('click',scrollToIdOnClick)
})

function scrollToIdOnClick(e){
  event.preventDefault();
  const element = e.target;
  const id = element.getAttribute('href');
  const to = document.querySelector(id).offsetTop;
  const menuHeaderTamanho = document.querySelector("header")
  window.scroll({
    top:to - 90,
    behavior:"smooth",
  });
}

let btn_email = document.getElementById("#btn-email")

btn_email.addEventListener("click", 
function enviarEmail(e){

  e.preventDefault();

  let nome = document.querySelector("#nome").value;
  let email = document.querySelector("#email").value;
  let telefone = document.querySelector("#telefone").value;
  let assunto = document.querySelector("#assunto").value;
  let mensagem = document.querySelector("#mensagem").value;

  let nossoEmail = "oode.awny@gmail.com";


  Email.send({

    SecureToken : "a31a0d3c-67d7-4ac2-95a1-1d09e2971a1b",
    // a31a0d3c-67d7-4ac2-95a1-1d09e2971a1b
    To : nossoEmail,
    From : nossoEmail,
    Subject : assunto,
    Body : mensagem
    }).then(
      message => alert("E-mail enviado, obrigado!"),
                console.log(nossoEmail,assunto,mensagem)
  );
})

