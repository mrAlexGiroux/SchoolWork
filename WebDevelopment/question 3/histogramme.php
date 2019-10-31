<?php
  $collections = [14, 10, 16, 15, 5, 20, 17, 8, 7, 12, 19, 9, 18, 3, 2, 13];
  if (isset($_GET['tri'])) {
    $tri = $_GET['tri'];
    if ($tri == "croissant") {
      asort($collections);
    }
    else {
      arsort($collections);
    }
  }
  
?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>420-219-SF</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
      i { margin-right: 10px; }
	  .navbar-inner h1 { color: white;  }
	  body { margin-top: 30px; }
	  .span1, .span2, .span3, .span4, .span5, .span6, 
	  .span7, .span8, .span9, .span10,.span11,.span12 { background-color: #ddd; border-radius: 5px; }
      .masquer { display: none; }
      li {height:200px; text-align:center; list-style-type:none; margin-bottom:10px;
          display:table-cell; vertical-align:bottom; padding-right: 2px; }
    </style>
</head>

<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <span class="label label-info">420-219-SF</span><h1>Développement multimédia</h1>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="col-md-12">
        <div class="row">
          <h1>Histogramme</h1>
          <div>
            <ul>
            <?php
              foreach ($collections as $longueur) {
                echo '<li><img src="blue.png" width="50" height="' . $longueur * 10 . '" alt="barre"/></li>';
              }
            ?>
            </ul>
          </div>
          <hr/>
          <a href="histogramme.php?tri=croissant" class="btn btn-primary">Ordre croissant</a>
          <a href="histogramme.php?tri=decroissant" class="btn btn-success">Ordre inverse</a>
          <a href="histogramme.php" class="btn btn-warning">Ordre naturel</a>
        </div>
      </div>
    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script>
	</script>
  </body>
</html>