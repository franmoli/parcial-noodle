package ar.edu.utn.frba.dds.observers;

import ar.edu.utn.frba.dds.EventoDeGrupo;
import ar.edu.utn.frba.dds.GuitabSdK;
import ar.edu.utn.frba.dds.TipoDeEventoDeGrupo;

public class ObserverBajaDeAlumno implements ObserverCambioEnGrupo {
  GuitabSdK repoSdk;

  public void update(EventoDeGrupo evento) {
    if (evento.getTipo() == TipoDeEventoDeGrupo.ALUMNO_DADO_BAJA) {
      evento.getGrupo()
          .enviarMailAlosAlumnos("Un alumno se dio de baja",
              "El alumno " + evento.getAlumno().getNombre()
                  + " Se dio de baja");
      if (evento.getGrupo().estaCerrado()) {
        repoSdk.quitarAcceso(evento.getGrupo().getNombre(), evento.getAlumno().getUsername());
      }
    }
  }
}
