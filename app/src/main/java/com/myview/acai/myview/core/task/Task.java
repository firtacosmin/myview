package com.myview.acai.myview.core.task;


import android.util.Log;

/**
 * Created by Cosmin on 1/21/2017.
 * A task that is running on the {@link TaskManager}
 */

public class Task implements Runnable,ITask {

    private static String TAG = "TASK";

    private Thread mCurrentThread = null;

    @Override
    public void run() {


        if ( preExecute() ) {
            mCurrentThread = Thread.currentThread();
            /*
             * Before continuing, checks to see that the Thread hasn't
             * been interrupted
             */
            if (Thread.interrupted()) {
                return;
            }
            onExecute();
        }


    }

    public Thread getCurrentThread() {
        return mCurrentThread;


    }




    @Override
    public boolean preExecute(){

        Log.d(TAG,"::preExecute");
        return true;
    }
    @Override
    public void onExecute() {
        Log.d(TAG,"::onExecute");
    }

    @Override
    public void postExecute() {

    }
}
