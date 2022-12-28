package org.olmedo.hilos.ejemplos;

import org.olmedo.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        // esto es concurrente esto lo maneja el sistema operativo y la maquina virtual asi que el tiempo de ejecucuon va a ir variando
      Thread hilo = new NombreThread("Damian Olmedo");
      hilo.start(); //el estar se invoca y llama al run
      // Thread.sleep(1000);
      Thread hilo2 = new NombreThread("Maria Lopez");
      hilo2.start();

      NombreThread hilo3 = new NombreThread("El Pepe");
      hilo3.start();
        System.out.println(hilo.getState());

    }
}
