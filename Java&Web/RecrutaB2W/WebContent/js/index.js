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
// var formOffset = $("form").offset().top
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

