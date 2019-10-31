<?php
session_start();
session_destroy();
session_start();

$poids = 20;

$resultats = [
    ['note' => 18.5, 'nom' => 'Adam Bernard'],
    ['note' => 20.0, 'nom' => 'Charles Demers'],
    ['note' => 16.0, 'nom' => 'Eric Fillion'],
    ['note' => 11.0, 'nom' => 'Guy Huard'],
    ['note' => 12.0, 'nom' => 'Ian Jacob'],
    ['note' => 14.0, 'nom' => 'Kim Labrecque'],
    ['note' => 20.0, 'nom' => 'Michel Nolet'],
    ['note' =>  5.0, 'nom' => 'Olivier Paquet'],
    ['note' =>  0.0, 'nom' => 'Quentin Roberge'],
    ['note' => 18.5, 'nom' => 'Sylvie Tanguay']
];

$_SESSION['poids'] = $poids;
$_SESSION['resultats'] = $resultats;

header('Location: affichage.php');
?>