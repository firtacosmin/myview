package com.myview.acai.myview.core.task;

/**
 * Created by Cosmin on 1/22/2017.
 * An interface to be implemented by all the tasks
 */

public interface ITask {

    /**
     * will be called in the {@link Runnable#run()} before the {@link #onExecute()} method
     * @return true if the thread should continue to run
     * false if the thread should be interrupted here before the call of the {@link #onExecute()}
     */
    boolean preExecute();

    /**
     * The method that will do the work on the thread
     */
    void onExecute();


    /**
     * The method that will be called after the havy work done on {@link #onExecute()}
     */
    void postExecute();

}
