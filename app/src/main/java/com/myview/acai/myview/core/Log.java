package com.myview.acai.myview.core;


/**
 * Created by Cosmin on 1/22/2017.
 * A Log class
 */
public class Log{
    private int DEBUG = 2;
    private int WARNING = 1;
    private int ERROR = 0;

    private int LEVEL = DEBUG;


    public void d(String TAG, String message){
        if ( LEVEL >= DEBUG ) {
            android.util.Log.d(TAG, "::" + message);
        }
    }

    public void w(String TAG, String message){
        if ( LEVEL >= WARNING ) {
            android.util.Log.d(TAG, "::" + message);
        }
    }

    public void e(String TAG, String message){
        if ( LEVEL >= ERROR ) {
            android.util.Log.d(TAG, "::" + message);
        }
    }
}
