@extends('layouts.app')

@section('contenu')
  <h1>Demandes disponibles</h1>
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>Session</th>
        <th># cours</th>
        <th>Aide demandée</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    @foreach($demandes as $demande)
      <tr>
        <td>{{ $demande['session'] }}</td>
        <td>{{ $demande['noCours'] }}</td>
        <td>{{ $demande['descrDemande'] }}</td>
        <td><a href="/assignerDemande/{{ $demande['noDemande'] }}" class="btn btn-large btn-primary">M'assigner</a></td>
      </tr>
    @endforeach
    </tbody>
  </table>
@endsection