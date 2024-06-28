package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Asignacion {
  String titulo;
  List<String> listaDeEntregas = new ArrayList<String>();
  Integer entregasHabilitadas = 0;
  GrupoDeTrabajo grupoDeTrabajo;

  public Asignacion(String titulo, List<String> listaDeEntregas, GrupoDeTrabajo grupoDeTrabajo) {
    this.titulo = titulo;
    this.listaDeEntregas = listaDeEntregas;
    this.grupoDeTrabajo = grupoDeTrabajo;
  }

  public void habilitarEntrega() {
    if (entregasHabilitadas < listaDeEntregas.size()) {
      grupoDeTrabajo.enviarMailAlosAlumnos("Se habilito una nueva entrega",
          "Se habilito una nueva entrega para la asignacion "
              + titulo + "El link para la siguiente entrega es: "
              + listaDeEntregas.get(entregasHabilitadas)

      );
      entregasHabilitadas++;
    }
  }
}
