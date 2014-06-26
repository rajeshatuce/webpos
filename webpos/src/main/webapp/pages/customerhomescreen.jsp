<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/favicon.ico">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/starter-template.css" rel="stylesheet">
     <link href="../css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../js/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../js/ie10-viewport-bug-workaround.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>    
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
            <li><a href="#">Cart</a></li>
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

    <div class="container-fluid">
      <div class="row">
             <div class="col-sm-3 col-md-2 sidebar">
               <ul class="nav nav-sidebar">
            		<li class="active"><a href="#">What's New</a></li>
            		<li ><a href="#" class="sideSubMenu" data-content="This is the content for the popover Apparel">Apparel</a></li>
            		<li><a href="#" class="sideSubMenu" data-content="This is the content for the popover Books">Books</a></li>
            		<li><a href="#" class="sideSubMenu" data-content="This is the content for the popover Cosmetics">Cosmetics</a></li>
            		<li><a href="#" class="sideSubMenu" data-content="This is the content for the popover Computers">Computers</a></li>
            		<li><a href="#" class="sideSubMenu" data-content="This is the content for the popover Gifts">Gifts & Stationary</a></li>
            		<li><a href="#" class="sideSubMenu" data-content="This is the content for the popover Grocery">Grocery</a></li>
            		<li><a href="#" class="sideSubMenu" data-content="This is the content for the popover Mobile">Mobile</a></li>
          </ul>
             </div>
             <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
             		<div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
        <button type="button" class="btn btn-lg btn-danger popover-dismiss" data-toggle="popover" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?">Dismissible popover</button>
        <a id="example1" href="#" data-content="This is the content for the popover." >Your Popover Text Here.</a>
      </div>
             </div>
      </div>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/customerhomescreen.js"></script>
  </body>
</html>

