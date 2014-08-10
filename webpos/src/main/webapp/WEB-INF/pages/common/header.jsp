<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div role="navigation" class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand"><img src="../img/webshop.jpg"/><span style="padding-left:5px;">Web Shop</span></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#" id="myShoppingCartBtn"><img  style="padding-right:2px;" height="20" src="../img/mycart.png"/>(<span id="myShoppingCartBtnTxt">${mycartcount}</span>)</a></li>
            <li><a href="#">Signup</a></li>
            <li><a href="#">Login</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
           <div class="input-group">
           <input type="text" placeholder="Search..." class="form-control">
             <span class="input-group-btn">
        <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
      </span>
           </div>
          </form>
        </div>
      </div>
      </div>
      
      <div id="shoppingcart" title="My Shopping Cart" class="myDialog">
        <div id="myCartAjaxLoad" class="midPosition">
          <img src="../img/loader.gif"/>
        </div>
        <div id="myCartContent" class="">
        </div>
      </div>
      