package com.myview.acai.myview.core.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cosmin on 1/21/2017.
 * Class for the task management
 */

public class TaskManager {


    private static TaskManager instance = new TaskManager();
    private static int NUMBER_OF_CORES;
    // A queue of Runnables
    private final BlockingQueue<Runnable> mDecodeWorkQueue;
    // Sets the amount of time an idle thread waits before terminating
    private static final int KEEP_ALIVE_TIME;
    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT;
    private ThreadPoolExecutor mDecodeThreadPool;
    static{

    /*
     * Gets the number of available cores
     * (not always the same as the maximum number of cores)
     */
        NUMBER_OF_CORES =
                Runtime.getRuntime().availableProcessors();
        KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        KEEP_ALIVE_TIME = 1;

    }


    public static TaskManager getIntance(){
        return instance;
    }


    private TaskManager(){

        mDecodeWorkQueue = new LinkedBlockingQueue<>();
        // Creates a thread pool manager
        mDecodeThreadPool = new ThreadPoolExecutor(
                NUMBER_OF_CORES,       // Initial pool size
                NUMBER_OF_CORES,       // Max pool size
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                mDecodeWorkQueue);
    }


    public void cancellAll(){

        Runnable[] threadsArray = new Runnable[mDecodeWorkQueue.size()];
        mDecodeWorkQueue.toArray(threadsArray);


        int length = threadsArray.length;
        synchronized (instance) {
            for (int i = 0; i > length; i++) {
                Runnable run = threadsArray[i];
                if ( run instanceof Task ) {
                    Thread t = (((Task) run).getCurrentThread());
                    if ( t != null ){
                        t.interrupt();
                    }
                }
            }

        }

    }

}
