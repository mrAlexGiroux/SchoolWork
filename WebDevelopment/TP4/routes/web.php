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
#region Question
    /*
    close cursor necessaire partout?
    */
#endregion

#region fonction obtenirConnexion()
function obtenirConnexion()
{
    $PARAM_hote='localhost'; 
    $PARAM_port='3306';
    $PARAM_utilisateur='root'; 
    $PARAM_nom_bd= 'tp4'; 
    $PARAM_mot_passe=''; 

    try
    {
       $connexion = new PDO(
           'mysql:host=' . $PARAM_hote . ';port=' . $PARAM_port .
           ';dbname=' . $PARAM_nom_bd, 
           $PARAM_utilisateur, $PARAM_mot_passe);
       $connexion->exec("SET CHARACTER SET utf8");
       $mode = PDO::FETCH_ASSOC; // Collection d'association
       //$mode = PDO::FETCH_OBJ;   // Objet PHP
       $connexion->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, $mode); 

       return $connexion;
    } catch(Exception $e) 
      {
        echo 'Erreur : '.$e->getMessage().'<br>';
        echo 'N° : '.$e->getCode();
        die();
    }    
}
#endregion

#region get /
$app->get('/', function () use ($app) {
    session_start();

    if (!isset($_SESSION['tCours'])) {
        $connexion = obtenirConnexion();
         $requeteCours = $connexion->query(
        'SELECT * ' .
        'FROM TCours ' .
        'ORDER BY session, noCours'
        );
        $cours = $requeteCours->fetchAll();
        
         $requeteCours->closeCursor();
    
        $_SESSION['tCours'] = $cours;

        $connexion = null;
    }
    return redirect('/simulerLogin');
});
#endregion

#region get /simulerLogin
$app->get('/simulerLogin', function() use ($app){
    session_start();
    $connexion = obtenirConnexion();
        $requeteEleve = $connexion->query(
            'SELECT * ' .
            'FROM TEleve ' .
            'ORDER BY matricule'
        );
        $tEleve = $requeteEleve->fetchAll();
    
        $requeteEleve->closeCursor();
    
        $connexion = null;

    return view('simulerLogin', ['tEleve' => $tEleve]);
});
#endregion

#region get /simulerLogin/{matricule} 
$app->get('/simulerLogin/{matricule}', function ($matricule) use ($app){
    session_start();
    $connexion = obtenirConnexion();
    $requete = $connexion->prepare(
        'SELECT * ' .
        'FROM TEleve ' .
        'WHERE matricule = :matricule');
    $requete->execute(['matricule' => $matricule]);
    $eleveSelect = $requete->fetch();
    $requete->closeCursor();
    $connexion = null;
    
    $_SESSION['eleve'] = $eleveSelect;

    return redirect('inscrireDemande');
});
#endregion

#region get /inscrireDemande
$app->get('/inscrireDemande', function () use ($app){
    session_start();

    $tCours = $_SESSION['tCours'];
    $eleveSelect = $_SESSION['eleve'];

    return view('inscrireDemande', ['eleveSelect' => $eleveSelect , 'tCours' => $tCours]);
});
#endregion

#region post /inscrireDemande
$app->post('/inscrireDemande', function() use ($app){
    session_start();
    $resultatDemande = false;

    $matrTutore = $_SESSION['eleve']['matricule'];
    $noCours = $app->request->input('cours');

    $connexion = obtenirConnexion();

    $requete = $connexion->prepare(
        'SELECT COUNT(*) as demandeActive ' .
        'FROM tDemande ' .
        'WHERE matrTutore = :matrTutore AND noCours = :noCours AND coteTuteur IS NULL');
    $requete->execute(['noCours' => $noCours,'matrTutore' => $matrTutore]);
    $retourRequete = $requete->fetch();

    if ($retourRequete['demandeActive'] == '0'){
        $descrDemande = $app->request->input('description');

        $requete = $connexion->prepare(
            'INSERT INTO tdemande (matrTutore, noCours, descrDemande) ' .
            'VALUES (:matrTutore, :noCours, :descrDemande)');

        $check = $requete->execute(['matrTutore' => $matrTutore, 'noCours' => $noCours,
                            'descrDemande' => $descrDemande]);

        $resultatDemande = true;
    }

    $connexion = null;

    return view('reponseDemande',['resultatDemande' => $resultatDemande]);
});
#endregion

#region get /accrediter
$app->get('/accrediter' , function() use ($app){
    session_start();

    $connexion = obtenirConnexion();
    $requete = $connexion->prepare(
        'SELECT * ' .
        'FROM TEleve ' .
        'WHERE estTuteur = 0');
    $requete->execute();

    $nonTuteur = $requete->fetchAll();

    $connexion = null;

    return view('futursTuteurs', ['futursTuteurs' => $nonTuteur]);
});
#endregion

#region get /accrediter/{matricule}
$app->get('/accrediter/{matricule}' , function($matricule) use ($app){

    $connexion = obtenirConnexion();
    $requete = $connexion->prepare(
        'UPDATE TEleve ' .
        'SET estTuteur = 1 ' .
        'WHERE matricule = :matricule');
    $requete->execute(['matricule' => $matricule]);

    $requete = $connexion->prepare(
        'SELECT * ' .
        'FROM TEleve ' .
        'WHERE matricule = :matricule');
    $requete->execute(['matricule' => $matricule]);
    $tuteur = $requete->fetch();

    $connexion = null;

    return view('confirmationAccreditation',['tuteur' => $tuteur]);
});
#endregion

#region get /demandeDisponibles
$app->get('/demandesDisponibles', function() use($app) {
    session_start();
    // acces Tuteur
    $connexion = obtenirConnexion();
    $requete = $connexion->query(
                'SELECT TDemande.*, session ' .
                'FROM TDemande ' .
                ' INNER JOIN TCours ' .
                ' ON TDemande.noCours = TCours.noCours ' .
                'WHERE matrTuteur IS NULL ' .
                'ORDER BY session, noCours');
    $demandes = $requete->fetchAll();
    $requete->closeCursor();
    $connexion = null;
    if ($_SESSION['eleve']['estTuteur'] = 0) {
        return view('nonAccreditation');
    }
    else {
        return view('US1demandesDisponibles', ['demandes' => $demandes]);
    }
    });
#endregion

#region get /assignerDemande/{noDemande}   
$app->get('assignerDemande/{noDemande}', function ($noDemande) use($app){
    session_start();
    $matrTuteur = $_SESSION['eleve']['matricule'];
    $connexion = obtenirConnexion();

    $requete = $connexion->prepare(
        'UPDATE Tdemande ' .
        'SET matrTuteur = :matrTuteur ' .
        'WHERE noDemande = :noDemande');
    var_dump($requete);
    $requete->execute(['noDemande' => $noDemande, 'matrTuteur' => $matrTuteur]);

    $connexion = null;
    return redirect('/demandesTuteur');
});
#endregion

#region get /demandeTuteur
$app->get('/demandesTuteur', function() use($app) {
    session_start();
    $matrTuteur = $_SESSION['eleve']['matricule'];
    $connexion = obtenirConnexion();
    // demandes actives
    $requete = $connexion->prepare(
                'SELECT TDemande.*, prenom, nom ' .
                'FROM TDemande ' .
                '   INNER JOIN TEleve ' .
                '   ON TDemande.matrTutore = TEleve.matricule ' .
                '   INNER JOIN TCours ' .
                '   ON TCours.noCours = TDemande.noCours ' .
                'WHERE matrTuteur = :matrTuteur AND ' .
                '       coteTuteur IS NULL ' .
                'ORDER BY session, noCours, matrTutore');
    $requete->execute(['matrTuteur' => $matrTuteur]);
    $demandesActives = $requete->fetchAll();
    $requete->closeCursor();

    // demandes complétées
    $requete = $connexion->prepare(
                'SELECT TDemande.*, prenom, nom ' .
                'FROM TDemande ' .
                ' INNER JOIN TEleve ' .
                ' ON TDemande.matrTutore = TEleve.matricule ' .
                ' INNER JOIN TCours ' .
                ' ON TCours.noCours = TDemande.noCours ' .
                'WHERE matrTuteur = :matrTuteur AND ' .
                ' coteTuteur IS NOT NULL ' .
                'ORDER BY session, noCours, matrTutore');
    $requete->execute(['matrTuteur' => $matrTuteur]);
    $demandesCompletees = $requete->fetchAll();
    $requete->closeCursor();
    $connexion = null;
    return view('US7demandesTuteur', [
            'actives' => $demandesActives,
            'completees' => $demandesCompletees,
            'tuteur' => $_SESSION['eleve']]);
    });
#endregion

#region get /completerRapport/{{ $demande['noDemande'] }}
$app->get('/completerRapport/{noDemande}', function($noDemande) use ($app){
    session_start();
    $connexion = obtenirConnexion();
    $requete = $connexion->prepare(
        'SELECT * ' .
        'FROM tDemande ' .
        'WHERE noDemande = :noDemande');
    $requete->execute(['noDemande' => $noDemande]);
    $rapport = $requete->fetch();
    var_dump($rapport);
    $connexion = null;
    return view('completerRapport', ['rapport' => $rapport ,'noDemande' => $noDemande]);
});
$app->post('/completerRapport/{noDemande}', function($noDemande) use ($app){
    session_start();
    $coteTuteur = $app->request->input('coteTuteur');
    $commentaireTuteur = $app->request->input('commentaireTuteur');

    $connexion = obtenirConnexion();
    $requete = $connexion->prepare(
        'UPDATE TDemande.*' .
        'SET coteTuteur = :coteTuteur, ' .
        '    commentairetuteur = :commentaireTuteur ' .
        'WHERE TDemande.noDemande = :noDemande');
        //UPDATE `tdemande` SET `coteTuteur` = '5', `commentaireTuteur` = 'bob' WHERE `tdemande`.`noDemande` = 2;
    $connexion = null;
    return redirect('/demandesTuteur');
});

#region logout
    $app->get('/logout', function() use ($app){
        session_start();
        session_destroy();
        return redirect('/');
    });
#endregion