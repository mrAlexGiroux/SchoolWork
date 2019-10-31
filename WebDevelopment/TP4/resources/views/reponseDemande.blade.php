@extends('layouts.app')

@section('contenu')
<h1>Bilan d'inscription d'une demande</h1>
    @if($resultatDemande)
        <div class="alert alert-success" role="alert">
         Merci, votre demande est acceptée.
        </div>
    @else
        <div class="alert alert-danger" role="alert">
            Désolé. Vous avez déjà une demande active pour ce cours.
        </div>
    @endif
@endsection