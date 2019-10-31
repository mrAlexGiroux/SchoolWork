<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$app->get('/', function() use ($app){
    session_start();
    $mainDes = [rand(1,6),rand(1,6),rand(1,6),rand(1,6),rand(1,6)];
    $_SESSION['mainDes'] = $mainDes;

    $sommesFace = [0,0,0,0,0,0];
    $sommeDes = 0;
    foreach($mainDes as $valeurDe) {
        $sommesFace[$valeurDe - 1]++;
        $sommeDes += $valeurDe;
    }

    return view('jeuDes', ['mainDes' => $mainDes, 
                            'sommesFace' => $sommesFace,
                            'sommesDes' => $sommeDes]);
});

$app->get('brasserDe/{position}', function($position) use ($app){
    session_start();
    if (!isset($_SESSION['mainDes'])){
        return redirect('/');
    }
    else {
        $mainDes = $_SESSION['mainDes'];
        $mainDes[$position] = rand(1,6);
        
        $sommesFace = [0,0,0,0,0,0];
        $sommeDes = 0;
        foreach($mainDes as $valeurDe) {
            $sommesFace[$valeurDe - 1]++;
            $sommeDes += $valeurDe;
        }
        $_SESSION['mainDes'] = $mainDes;
    }
    return view('jeuDes',['mainDes' => $mainDes, 
                            'sommesFace' => $sommesFace,
                            'sommesDes' => $sommeDes]);
});
