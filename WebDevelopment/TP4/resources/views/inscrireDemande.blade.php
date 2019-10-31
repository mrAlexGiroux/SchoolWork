@extends('layouts.app')

@section('contenu')
<h2>{{$eleveSelect["prenom"]}} {{$eleveSelect["nom"]}}  {{($eleveSelect["matricule"])}}</h2>
<h1>Je souhaite avoir de l'aide...</h1>
  <form method="POST" action="/inscrireDemande" >
    <div class="form-group">
      <label for="pourCours">Pour le cours :</label>
      <select name="cours" id="cours" class="form-control">
            @foreach($_SESSION['tCours'] as $unCours)
            <option value="{{$unCours['noCours']}}">{{$unCours['noCours']}} {{$unCours['titre']}} ({{$unCours['session']}})</option>
            @endforeach
      </select>
    </div>
    <div class="form-group">
      <label for="pourSupport">Objectif(s) du support</label>
      <input type="text" name="description" id="description" class="form-control" placeholder="" aria-describedby="helpId" required>
    </div>
    <button type="submit" class="btn btn-primary btn-lg active">Soumettre la demande</button>
  </form>
@endsection