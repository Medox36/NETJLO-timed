package ch.giuntini.netjlo_timed.threads;

import ch.giuntini.netjlo_timed.interpreter.Interpretable;
import ch.giuntini.netjlo_timed.packages.TimedPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TimedReceiverInterpretThread<T extends TimedPackage, I extends Interpretable<T>>
        extends Thread implements AutoCloseable {

    private final ConcurrentLinkedQueue<T> packages;
    private final I interpreter;
    private volatile boolean stop;

    public TimedReceiverInterpretThread(ConcurrentLinkedQueue<T> packages, I interpreterC) {
        super("Timed-ReceiverInterpret-Thread");
        this.packages = packages;
        this.interpreter = interpreterC;
    }

    @Override
    public void run() {
        while (!stop) {
            while (!packages.isEmpty()) {
                T p = packages.poll();
                if (p != null) {
                    interpreter.interpret(p);
                }
            }
            Thread.onSpinWait();
        }
    }

    @Override
    public void close() {
        stop = true;
    }
}
