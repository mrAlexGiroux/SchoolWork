@extends('layouts.app')

@section('contenu')
  <h1>Sommaire des demandes pour le tuteur {{$tuteur['prenom']}} {{$tuteur['nom']}}</h1>
  <h3>Demandes actives</h3>
  @if(count($actives) > 0)
    <table class="table table-striped table-bordered">
      <thead>
        <tr>
          <th>No cours</th>
          <th>Tutoré</th>
          <th class="col-sm-7">Problème</th>
          <th class="col-sm-1">Action</th>
        </tr>    
      </thead>
      <tbody>
      @foreach($actives as $demande)
        <tr>
          <td>{{ $demande['noCours'] }}</td>
          <td>{{ $demande['prenom'] }} {{ $demande['nom'] }}</td>
          <td>{{ $demande['descrDemande'] }}</td>
          <td><a href="/completerRapport/{{ $demande['noDemande'] }}" class="btn btn-xs btn-primary">Compléter le rapport</a></td>
        </tr>
      @endforeach
      </tbody>
    </table>
  @else
    <div class="alert alert-warning" role="alert">
    <p>Vous n'avez présentement aucune demande d'assignée.</p><br>
    <a href="/demandesDisponibles" class="btn btn-xs btn-warning">Consulter les demandes disponibles</a>
    </div>
  @endif
    <h3>Demandes complétées</h3>
    @if(count($completees) > 0)
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>No cours</th>
            <th>Tutoré</th>
            <th class="col-sm-4">Problème</th>
            <th>Cote</th>
            <th class="col-sm-4">Bilan</th>
          </tr>
        </thead>
        <tbody>
        @foreach($completees as $demande)
          <tr>
            <td>{{ $demande['noCours'] }}</td>
            <td>{{ $demande['prenom'] }} {{ $demande['nom'] }}</td>
            <td>{{ $demande['descrDemande'] }}</td>
            <td>{{ $demande['coteTuteur'] }}</td>
            <td>{{ $demande['commentaireTuteur'] }}</td>
          </tr>
        @endforeach
        </tbody>
      </table>
   @else
     <div class="alert alert-warning" role="alert">Vous n'avez complété aucun rapport de tutorat jusqu'à maintenant.</div>
   @endif
   <hr>
   <p>Vous pouvez également inscrire une demande de support si vous avez vous-même besoin d'un tuteur.</p>
   <a href="/inscrireDemande" class="btn btn-xs btn-success">Inscrire une demande</a>
@endsection
