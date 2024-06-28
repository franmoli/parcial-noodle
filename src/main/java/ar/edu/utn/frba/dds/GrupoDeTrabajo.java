package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.observers.ObserverCambioEnGrupo;

import java.util.ArrayList;
import java.util.List;

public class GrupoDeTrabajo {
  Integer tamanioIdeal;
  Boolean cerrado = false;
  MailSender mailSender;
  String nombre;
  List<Alumno> inscriptos = new ArrayList<Alumno>();
  List<SolicitudDeCierre> solicitudesDeCierre = new ArrayList<SolicitudDeCierre>();
  List<SolicitudDeInscripcion> solicitudesDeInscripcion = new ArrayList<SolicitudDeInscripcion>();
  List<ObserverCambioEnGrupo> observerCambioEnGrupo = new ArrayList<ObserverCambioEnGrupo>();
  List<Asignacion> asignaciones = new ArrayList<Asignacion>();


  public GrupoDeTrabajo(Integer tamanioIdeal, MailSender mailSender, String nombre) {
    this.tamanioIdeal = tamanioIdeal;
    this.mailSender = mailSender;
    this.nombre = nombre;
  }

  public void inscribirAlumno(Alumno alumno) {
    inscriptos.add(alumno);
    notificarEvento(new EventoDeGrupo(this, alumno, TipoDeEventoDeGrupo.ALUMNO_INSCRIPTO));
  }

  public void darDeBajaAlumno(Alumno alumno) {
    inscriptos.remove(alumno);
    notificarEvento(new EventoDeGrupo(this, alumno, TipoDeEventoDeGrupo.ALUMNO_DADO_BAJA));
  }

  public void cerrarGrupoDeTrabajo() {
    this.cerrado = true;
    notificarEvento(new EventoDeGrupo(this, null, TipoDeEventoDeGrupo.CERRAR_GRUPO));
  }

  public void solicitarCierreDeGrupo(Maestro maestro) {
    this.solicitudesDeCierre.add(new SolicitudDeCierre(maestro, this));
  }

  public void solicitarInscripcion(Alumno alumno) {
    this.solicitudesDeInscripcion.add(new SolicitudDeInscripcion(alumno, this));
  }

  private void notificarEvento(EventoDeGrupo evento){
    observerCambioEnGrupo.forEach(observer -> observer.update(evento));
  }

  public void enviarMailAlosAlumnos(String subject, String body) {
    for (Alumno a : inscriptos) {
      mailSender.send(a.getMail(), subject, body);
    }
  }

  public void suscribirObserver(ObserverCambioEnGrupo observerCambioEnGrupo) {
    this.observerCambioEnGrupo.add(observerCambioEnGrupo);
  }

  public void agregarAsignacion(Asignacion asignacion) {
    this.asignaciones.add(asignacion);
  }

  public void habilitarEntregasSemanales(){
    this.asignaciones.forEach(Asignacion::habilitarEntrega);
  }


  public Integer getTamanioIdeal() {
    return tamanioIdeal;
  }

  public List<Alumno> getInscriptos() {
    return inscriptos;
  }

  public Boolean estaCerrado() {
    return cerrado;
  }

  public List<SolicitudDeCierre> getSolicitudesDeCierre() {
    return solicitudesDeCierre;
  }

  public String getNombre(){
    return nombre;
  }

}
