@extends('layouts.app')

@section('contenu')
<h2>Simulation -- Login</h2>
    @if(isset($tEleve))
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                <th class="col-md-4">Matricule</th>
                <th class="col-md-4">Prénom</th>
                <th class="col-md-4">Nom</th>
                <th class="col-md-4">Action</th>
                </tr>
            </thead>
            <tbody>
                @foreach($tEleve as $unEleve)
                    <tr>
                        <td>
                            {{$unEleve["matricule"]}}
                        </td>
                        <td>
                            {{$unEleve["prenom"]}}
                        </td>
                        <td>
                            {{$unEleve["nom"]}}
                        </td>
                        <td>
                        <a href="simulerLogin/{{$unEleve['matricule']}}" type="button" class="btn btn-success">Login</a>
                        </td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    @else
    <div class="alert alert-danger">
    Aucun eleve.
    </div>
    @endif
@endsection