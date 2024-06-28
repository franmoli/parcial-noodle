package ar.edu.utn.frba.dds.observers;

import ar.edu.utn.frba.dds.EventoDeGrupo;
import ar.edu.utn.frba.dds.GuitabSdK;
import ar.edu.utn.frba.dds.TipoDeEventoDeGrupo;

public class ObserverInscripcionAlumno implements ObserverCambioEnGrupo {
  GuitabSdK repoSdk;

  public void update(EventoDeGrupo evento) {
    if (evento.getTipo() == TipoDeEventoDeGrupo.ALUMNO_INSCRIPTO) {
      evento.getGrupo()
          .enviarMailAlosAlumnos("Un alumno se inscribio",
              "El alumno " + evento.getAlumno().getNombre()
                  + " Se inscribio");
      if (evento.getGrupo().estaCerrado()) {
        repoSdk.darAcceso(evento.getGrupo().getNombre(), evento.getAlumno().getUsername());
      }
    }
  }
}
