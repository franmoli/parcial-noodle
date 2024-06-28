package ar.edu.utn.frba.dds;

public class SolicitudDeInscripcion {
  Alumno alumno;
  GrupoDeTrabajo grupo;
  EstadoDeSolicitud estado = EstadoDeSolicitud.PENDIENTE;

  public SolicitudDeInscripcion(Alumno alumno, GrupoDeTrabajo grupoDeTrabajo) {
    this.alumno = alumno;
    this.grupo = grupoDeTrabajo;

    if (!grupoDeTrabajo.estaCerrado()) {
      this.aceptarSolicitud();
    }
  }

  public void aceptarSolicitud() {
    if (estado == EstadoDeSolicitud.PENDIENTE) {
      grupo.inscribirAlumno(alumno);
      estado = EstadoDeSolicitud.APROBADA;
    }
  }

  public void rechazarSolicitud() {
    estado = EstadoDeSolicitud.RECHAZADA;
  }
}
