package org.olmedo.hilos.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        // representa un resultado futuro de una operacion asincrona dependiendo si es Runnable o Callabled
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Incio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ...");
        };
        executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continunando con la ejecucion del metodo main 1");
        //executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continunando con la ejecucion del metodo main 2");

    }
}
