package ar.edu.utn.frba.dds;

public class SolicitudDeCierre {
  EstadoDeSolicitud status = EstadoDeSolicitud.PENDIENTE;
  GrupoDeTrabajo grupoDeTrabajo;
  Maestro maestroProponente;
  Maestro maestroVerificador;

  public SolicitudDeCierre(Maestro maestroProponente, GrupoDeTrabajo grupoDeTrabajo ) {
    this.maestroProponente = maestroProponente;
    this.grupoDeTrabajo = grupoDeTrabajo;

    if(grupoDeTrabajo.getTamanioIdeal() == grupoDeTrabajo.getInscriptos().size()){
      this.aprobarSolicitud(maestroProponente);

    }
  }

  public void aprobarSolicitud(Maestro maestroVerificador) {
    grupoDeTrabajo.cerrarGrupoDeTrabajo();
    this.maestroVerificador = maestroVerificador;
    status = EstadoDeSolicitud.APROBADA;
  }

  public void rechazarSolicitud(Maestro maestroVerificador) {
    this.maestroVerificador = maestroVerificador;
    status = EstadoDeSolicitud.RECHAZADA;
  }
}
