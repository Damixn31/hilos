package org.olmedo.hilos.ejemplos.threads;

public class NombreThread extends Thread {
  public NombreThread(String name) {
    super(name);
  }
  @Override
  public void run() {
    System.out.println("Se inicia el metodo run del hilo " + getName());

    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(10); // mete una pausa en cada hilo
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(this.getName());
      
    }
    System.out.println("Finalizo el hilo");
  }
}
