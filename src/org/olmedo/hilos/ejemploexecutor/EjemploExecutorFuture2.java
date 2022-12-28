package org.olmedo.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // representa un resultado futuro de una operacion asincrona dependiendo si es Runnable o Callable
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1); // de esta manera las tareas se ejecutan al mismo tiempo pero puede ir variando quien inicia primero segundo y tercero

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());

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

        Callable<Integer> tarea2 = () -> {
          System.out.println("Inciamos tarea 3 ...");
          TimeUnit.SECONDS.sleep(3);
          return 10;
        };

        Future<String> resultadoFuture = executor.submit(tarea);
        Future<String> resultadoFuture2 = executor.submit(tarea); // enviamos otra tarea
        Future<Integer> resultadoFuture3 = executor.submit(tarea2);

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());


        executor.shutdown();
        System.out.println("Continunando con la ejecucion del metodo main 1");
         
        // System.out.println(resultadoFuture.isDone()); // aca nos va a decir porque todavia no se inicia la tarea
        while (!(resultadoFuture.isDone() && resultadoFuture2.isDone() && resultadoFuture3.isDone())) {
          System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                resultadoFuture.isDone()? "Finalizo": "En proceso", 
                resultadoFuture2.isDone()? "Finalizo": "En proceso",
                resultadoFuture3.isDone()? "Finalizo": "En proceso" ));
          TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Obtenemos resultado1 de la tarea: " + resultadoFuture.get()); // aca se va a bloquear por 3 segundos hasta que finalize la tarea el get tambien puede recibir un parametro un timeout esto es bueno cuando una tarea se puede demorar mucho y queremos evitar un bloqueo
        // System.out.println("Continuamos ...");
        System.out.println("Finaliza la tarea1: " + resultadoFuture.isDone()); // aca nos va a decir true

        System.out.println("Obtenemos resultado2 de la tarea: " + resultadoFuture2.get());
        System.out.println("Finaliza la tarea2: " + resultadoFuture2.isDone());

        System.out.println("Obtenemos resultado3 de la tarea: " + resultadoFuture3.get());
        System.out.println("Finaliza la tarea3: " + resultadoFuture3.isDone());
 
    }
}
