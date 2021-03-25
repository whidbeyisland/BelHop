/*!
    * Start Bootstrap - Freelancer v6.0.5 (https://startbootstrap.com/theme/freelancer)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
    */
    (function($) {
    "use strict"; // Start of use strict



    /*
    $(document).ready(function() {
      $('#login-button2').click(function(){
        alert('Does this work?');
      });
    });
    */
    
    $('#create-account-button').click(function(){
      $.ajax({
        type: "POST",
        url: "/api/accounts",
        data: JSON.stringify({
          email: document.getElementById('create-account-email').value,
          password: document.getElementById('create-account-password').value,
          owner: document.getElementById('create-account-owner').checked,
          firstName: document.getElementById('create-account-first-name').value,
          middleName: document.getElementById('create-account-middle-name').value,
          lastName: document.getElementById('create-account-last-name').value,
          address: document.getElementById('create-account-address').value,
          addressPart2: document.getElementById('create-account-address-part-2').value,
          city: document.getElementById('create-account-city').value,
          state: document.getElementById('create-account-state').value,
          zip: document.getElementById('create-account-zip').value,
          zipPlus4: document.getElementById('create-account-zip-plus-4').value
        }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response) {
          alert(JSON.stringify(response));
          window.location.replace('./login');
        },
        error: function(xhr, status, error) {
          alert(xhr.responseText);
        }
      });
    });

    $('#login-button').click(function(){
      var correctPass = '';
      event.preventDefault();
      alert('hello world!');
      //TODO: change this to a GET request *for the specific account entered in the email field*, not for all accounts
      //email: document.getElementById('login-email').value
      $.ajax({
        type: "GET",
        url: "/api/accounts",
        success: function(response) {
          //TODO: change this to access the "password" property of the response
          alert(response[0].email);
        },
        error: function(xhr, status, error) {
          alert(xhr.responseText);
        }

        //TODO: implement session handling of account if the user successfully logs in
      });
    });


  
    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
      if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
        if (target.length) {
          $('html, body').animate({
            scrollTop: (target.offset().top - 71)
          }, 1000, "easeInOutExpo");
          return false;
        }
      }
    });
  
    // Scroll to top button appear
    $(document).scroll(function() {
      var scrollDistance = $(this).scrollTop();
      if (scrollDistance > 100) {
        $('.scroll-to-top').fadeIn();
      } else {
        $('.scroll-to-top').fadeOut();
      }
    });
  
    // Closes responsive menu when a scroll trigger link is clicked
    $('.js-scroll-trigger').click(function() {
      $('.navbar-collapse').collapse('hide');
    });
  
    // Activate scrollspy to add active class to navbar items on scroll
    $('body').scrollspy({
      target: '#mainNav',
      offset: 80
    });
  
    /*
    // Collapse Navbar
    var navbarCollapse = function() {
      if ($("#mainNav").offset().top > 100) {
        $("#mainNav").addClass("navbar-shrink");
      } else {
        $("#mainNav").removeClass("navbar-shrink");
      }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);
    */
  
    // Floating label headings for the contact form
    $(function() {
      $("body").on("input propertychange", ".floating-label-form-group", function(e) {
        $(this).toggleClass("floating-label-form-group-with-value", !!$(e.target).val());
      }).on("focus", ".floating-label-form-group", function() {
        $(this).addClass("floating-label-form-group-with-focus");
      }).on("blur", ".floating-label-form-group", function() {
        $(this).removeClass("floating-label-form-group-with-focus");
      });
    });

  })(jQuery); // End of use strict