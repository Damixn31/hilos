package org.olmedo.hilos.ejemploexecutor;

import org.olmedo.hilos.ejemplosync.Panaderia;
import org.olmedo.hilos.ejemplosync.runnable.Consumidor;
import org.olmedo.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // representa un resultado futuro de una operacion asincrona dependiendo si es Runnable o Callable
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); // como son dos tareas sincronizadas minimo tiene que tener un pool de dos, para que se puedas ejecutar estas dos al mismo tiempo

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());

        Panaderia p = new Panaderia(); // Panaderia seria como el monitor para que trabajen Panadero y Consumidor
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("Tamanio del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());


        executor.shutdown();
        System.out.println("Continunando con la ejecucion del metodo main");
         

    }
}
