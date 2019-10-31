<?php
session_start();

if(!isset($_SESSION['poids'])) {
    header('Location: index.php');
} else {
    $poids = $_SESSION['poids'];
    $resultats = $_SESSION['resultats'];
	
	$nombreEchecs = 0;
	
	foreach($resultats as $position => $resultat) {
		$pourcentage = $resultat['note'] / $poids * 100;
		$resultats[$position]['pourcentage'] = $pourcentage;
		if ($pourcentage < 60)
			$nombreEchecs++;
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
          <h1>R&eacute;sultats scolaires</h1>
          <table class="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Etudiant</th>
                <th class="text-center">Note</th>
                <th class="text-center">Pct</th>
                <th>Mention</th>
              </tr>
            </thead>
            <tbody>
<?php
  foreach($resultats as $resultat)
  {
?>
              <tr>
                <td><?= $resultat['nom'] ?></td>
                <td class="text-center">
                  <?= number_format($resultat['note'],1) . " / " . $poids ?>
                </td>
                <td class="text-center"><?= $resultat['pourcentage'] ?>%</td>
                <td><?= ($resultat['pourcentage'] < 60) ? "Echec" : "" ?></td>
              </tr>
<?php
  }
?>
            </tbody>
          </table>
          <h3>Nombre d'&eacute;checs: <span class="text-primary"><?= $nombreEchecs ?></span>
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