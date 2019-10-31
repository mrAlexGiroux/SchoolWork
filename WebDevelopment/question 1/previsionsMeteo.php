<?php
	$previsions = [
		'Lundi' => [
			'tempMin' => -5,
			'tempMax' => 0,
			'condition' => 'soleil'
		],
		'Mardi' => [
			'tempMin' => 5,
			'tempMax' => 8,
			'condition' => 'soleil'
		],
		'Mercredi' => [
			'tempMin' => 10,
			'tempMax' => 15,
			'condition' => 'averse'
		],
		'Jeudi' => [
			'tempMin' => -5,
			'tempMax' => 0,
			'condition' => 'nuageux'
		],
		'Vendredi' => [
			'tempMin' => -10,
			'tempMax' => -8,
			'condition' => 'partiel'
		],
		'Samedi' => [
			'tempMin' => -12,
			'tempMax' => -5,
			'condition' => 'averse'
		],
		'Dimanche' => [
			'tempMin' => -5,
			'tempMax' => 0,
			'condition' => 'soleil'
		],
	];
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
    	<div class="alert alert-info" style="margin-top: 20px"><h2 style="margin: 0">Prévisions météo</h2></div>

        <table class="table">
          <thead>
            <tr>
              <th>Jour</th>
              <th>Temp Min</th>
              <th>Temp Max</th>
              <th>Condition</th>
              <th>Temp Moyenne</th>
            </tr>
          </thead>
          <tbody>
            
            <?php 
              foreach ($previsions as $jours => $temperature) {
                echo '<tr>';
                echo '<td>' . $jours . '</td>';
                echo '<td>' . $temperature['tempMin'] . '</td>';
                echo '<td>' . $temperature['tempMax'] . '</td>';
                if ($temperature['condition'] == 'averse' && $temperature['tempMax'] > 0) {
                  echo '<td> <img src=pluie.gif /></td>';
                }
                elseif ($temperature['condition'] == 'averse' && $temperature['tempMax'] < 0) {
                  echo '<td> <img src=neige.gif /></td>';
                }
                else {
                  echo '<td> <img src=' . $temperature['condition'] . '.gif /></td>';
                }
                echo '<td>' . (($temperature['tempMin'] + $temperature['tempMax']) / 2) . '</td>';  
                echo '</tr>';
              }
            ?>

          </tbody>
        </table>


    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script>
	</script>
  </body>
</html>