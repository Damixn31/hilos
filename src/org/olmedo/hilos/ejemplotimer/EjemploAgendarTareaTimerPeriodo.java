package org.olmedo.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // para hacer un sonido cada ves que termine un proceso
        AtomicInteger contadorAtomic = new AtomicInteger(3); // tambien esta de esta manera para pasarle las veces que queremos que se repita el rpoceso
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            // private int contador = 3;
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if (i > 0) {
                    toolkit.beep();
                    System.out.println("Tarea " + i + " periodica en: "
                            + new Date() + " nombre del Thread: "
                            + Thread.currentThread().getName());
                    // contador--;
                } else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 0, 10000); //cada 10 segundos se va a volver a repetir infinitamente si no le pasamos un contador y cuando veces queremos que se repita el proceso
        System.out.println("Agendamos una tarea inmediatamente que se repite cada 10 segundos ... ");
    }
}
