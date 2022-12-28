package org.olmedo.hilos.ejemplos;

import org.olmedo.hilos.ejemplos.runnable.ImprimirFrase;

public class EjemploSincronizacionThread {
  public static void main(String[] args) throws InterruptedException {
    new Thread(new ImprimirFrase("Hola ", "que tal!")).start();
    new Thread(new ImprimirFrase("Quien eres ", "tu? ")).start();
    Thread.sleep(100);
    Thread h3 = new Thread(new ImprimirFrase("Muchas ", "gracias amigo!"));
    h3.start();
    Thread.sleep(100);
    System.out.println(h3.getState());
  }

  // con el synchronized va a compilarlo en orden sincronizado
  public synchronized static void imprimirFrases(String frase1, String frase2) {
    System.out.println(frase1);

    try{
      Thread.sleep(500);
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(frase2);
  }
}
