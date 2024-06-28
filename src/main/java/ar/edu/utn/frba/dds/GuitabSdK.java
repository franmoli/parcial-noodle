package ar.edu.utn.frba.dds;

import java.util.List;

public interface GuitabSdK {
  public void crearRepositorioConAccesos(String nombre, List<String> usernames);
  public void darAcceso(String nombreRepositorio, String username);
  public void quitarAcceso(String nombreRepositorio, String username);

}
