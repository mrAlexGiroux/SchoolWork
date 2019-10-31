@extends('layouts.app')

@section('contenu')
      <div class="col-md-12">
        <div class="row">
          <h1>Jeu de dés  <a href="/" class="btn btn-warning">brasser la main</a></h1>
          <strong>Cliquez sur l'image pour brasser un dé individuel</strong><br>

          @foreach($mainDes as $position => $valeurDe)
          <a href="brasserDe/$position>">
            <img src="de{{$valeurDe}}.png" width="104" height="103"/>
          </a>
          @endforeach
          <h3>Total de la main: {{$sommesDes}}</h3>
          <h3>Stats</h3>
          <ul>

            @foreach($sommesFace as $position => $somme)
                <li>Nombre de {{$position+1}}: {{$somme}}</li>
            @endforeach

          </ul>
        </div>
      </div>
@endsection
