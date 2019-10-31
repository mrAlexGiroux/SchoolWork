@extends('layouts.app')

@section('contenu')
<h1>Completer le rapport no {{$rapport['noDemande']}}</h1>
  <form method="POST" action="/completerRapport/{{$noDemande}}" >
    <div class="form-group">
      <label for="pourCote">Cote du tuteur :</label>
      <input type="number" min="1" max="6" name="coteTuteur" class="form-control" id="session" required>
    </div>
    <div class="form-group">
      <label for="pourComment">Commentaire du tuteur</label>
      <input type="text" name="commentaireTuteur" id="commentaireTuteur" class="form-control" placeholder="" aria-describedby="helpId" required>
    </div>
    <button type="submit" class="btn btn-primary btn-lg active">Soumettre le rapport</button>
  </form>
@endsection