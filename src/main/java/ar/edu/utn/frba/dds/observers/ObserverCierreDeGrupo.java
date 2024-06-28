package ar.edu.utn.frba.dds.observers;

import ar.edu.utn.frba.dds.Alumno;
import ar.edu.utn.frba.dds.EventoDeGrupo;
import ar.edu.utn.frba.dds.GuitabSdK;
import ar.edu.utn.frba.dds.TipoDeEventoDeGrupo;

import java.util.List;

public class ObserverCierreDeGrupo implements ObserverCambioEnGrupo{
  GuitabSdK repoSdk;
  public ObserverCierreDeGrupo(GuitabSdK repoSdk){
    this.repoSdk = repoSdk;
  }
  public void update(EventoDeGrupo evento) {
    if(evento.getTipo() == TipoDeEventoDeGrupo.CERRAR_GRUPO){
      List<String> listaDeUsernames = evento.getGrupo().getInscriptos().stream().map(
          Alumno::getUsername).toList();
      repoSdk.crearRepositorioConAccesos(evento.getGrupo().getNombre(), listaDeUsernames);
    }
  }
}
