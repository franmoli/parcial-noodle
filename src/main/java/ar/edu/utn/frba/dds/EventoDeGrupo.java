package ar.edu.utn.frba.dds;

public class EventoDeGrupo {
  GrupoDeTrabajo grupo;
  Alumno alumno;
  TipoDeEventoDeGrupo tipo;

  public EventoDeGrupo(GrupoDeTrabajo grupo, Alumno alumno, TipoDeEventoDeGrupo tipo) {
    this.grupo = grupo;
    this.alumno = alumno;
    this.tipo = tipo;
  }

  public GrupoDeTrabajo getGrupo() {
    return grupo;
  }

  public Alumno getAlumno() {
    return alumno;
  }

  public TipoDeEventoDeGrupo getTipo() {
    return tipo;
  }
}
