package org.olmedo.hilos.ejemplos.runnable;

import static org.olmedo.hilos.ejemplos.EjemploSincronizacionThread.imprimirFrases;

public class ImprimirFrase implements Runnable {
  private String frase1, frase2;

  public ImprimirFrase(String frase1, String frase2){
    this.frase1 = frase1;
    this.frase2 = frase2;
  }

  @Override
  public void run(){
    imprimirFrases(this.frase1, this.frase2);
  }
}
