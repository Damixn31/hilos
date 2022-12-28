package org.olmedo.hilos.ejemplos;

import org.olmedo.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
  public static void main(String[] args) {

    new Thread(new ViajeTarea("Isla de pascua")).start(); 
    new Thread(new ViajeTarea("Robinson Crusso")).start(); 
    new Thread(new ViajeTarea("Juan Fernandez")).start(); 
    new Thread(new ViajeTarea("Isla de Chiloe")).start();
  }
}
