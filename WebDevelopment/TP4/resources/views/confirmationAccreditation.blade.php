@extends('layouts.app')

@section('contenu')
<h1>Confirmation d'accréditation</h1>
<div>L'étudian(e) répondant au matricule <strong>{{$tuteur['matricule']}}</strong> a dorénavant la possibilité d'agir comme <u>tuteur</u></div>
<div>Toutes nos félicitations à <strong>{{$tuteur['prenom']}} {{$tuteur['nom']}}</strong> </div>

<a href="/accrediter" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Revenir aux accréditations</a>

@endsection