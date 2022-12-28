package org.olmedo.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // representa un resultado futuro de una operacion asincrona dependiendo si es Runnable o Callable
        ExecutorService executor =  Executors.newSingleThreadExecutor(); // de esta manera las tareas se ejecutan al mismo tiempo pero puede ir variando quien inicia primero segundo y tercero


        Callable<String> tarea = () -> { // el Callable devuelve un valor a difrencia de Runnable que no devuelve nada 
            System.out.println("Incio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ...");
            return "Algun resultado importante de la tarea";
        };

        Future<String> resultadoFuture = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continunando con la ejecucion del metodo main 1");
         
        while (!resultadoFuture.isDone()) {
          System.out.println("ejecutando tarea ...");
          TimeUnit.MILLISECONDS.sleep(1500);
        }
       System.out.println("Obtenemos resultado1 de la tarea: " + resultadoFuture.get()); // aca se va a bloquear por 3 segundos hasta que finalize la tarea el get tambien puede recibir un parametro un timeout esto es bueno cuando una tarea se puede demorar mucho y queremos evitar un bloqueo
        // System.out.println("Continuamos ...");
        System.out.println("Finaliza la tarea: " + resultadoFuture.isDone()); // aca nos va a decir true

 
    }
}
