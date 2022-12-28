package org.olmedo.hilos.ejemplos;

import org.olmedo.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
  public static void main(String[] args) throws InterruptedException {

    /*Runnable viaje = new Runnable(){
      @Override
      public void run(){
      for (int i = 0; i < 10; i++) {
        System.out.println(i + " - " + Thread.currentThread().getName());
        try {
          Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
 
      }
    };*/
    // lo mismo que arriba pero en expresion lamda
    Thread main = Thread.currentThread(); // aca obtenemos el Thread principal del main
    Runnable viaje = () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(i + " - " + Thread.currentThread().getName());
        try {
          Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
      System.out.println(main.getState()); // aca nos muestra el estado del main
 
    };
    Thread v1 = new Thread(viaje, "Isla de pascua"); 
    Thread v2 = new Thread(viaje, "Robinson Crusso"); 
    Thread v3 = new Thread(viaje, "Juan Fernandez"); 
    Thread v4 = new Thread(viaje, "Isla de Chiloe"); 
    
    v1.start();
    v2.start();
    v3.start();
    v4.start();
    // el metodo join se ejecuta en la estancia del thread une, el join no es estatico
    v1.join();
    v2.join();
    v3.join();
    v4.join();

    // Thread.sleep(1000);
    System.out.println("Continuando con la ejecucion del metodo main: " + main.getName());
  }
}
