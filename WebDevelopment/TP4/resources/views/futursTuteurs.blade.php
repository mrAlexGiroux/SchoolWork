@extends('layouts.app')

@section('contenu')
<h2>Décerner l'accréditateur de tuteur</h2>
    <div>Veuillez sélectionner l'étudiant(e) qui a complété avec succès la formation obligatoire.</div>
    <div>Le tuteur (ou tutrice) aura la possibilité de répondre aux demaindes de support.</div>
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
                @foreach($futursTuteurs as $unEleve)
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
                        <a href="accrediter/{{$unEleve['matricule']}}" type="button" class="btn btn-success">Accréditer</a>
                        </td>
                    </tr>
                @endforeach
            </tbody>
        </table>
@endsection