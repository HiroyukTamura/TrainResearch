// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.os.HandlerThread;
import android.os.Handler;

class CameraThread
{
    private static final String TAG;
    private static CameraThread instance;
    private final Object LOCK;
    private Handler handler;
    private int openCount;
    private HandlerThread thread;
    
    static {
        TAG = CameraThread.class.getSimpleName();
    }
    
    private CameraThread() {
        this.openCount = 0;
        this.LOCK = new Object();
    }
    
    private void checkRunning() {
        Label_0074: {
            synchronized (this.LOCK) {
                if (this.handler != null) {
                    break Label_0074;
                }
                if (this.openCount <= 0) {
                    throw new IllegalStateException("CameraThread is not open");
                }
            }
            (this.thread = new HandlerThread("CameraThread")).start();
            this.handler = new Handler(this.thread.getLooper());
        }
    }
    // monitorexit(o)
    
    public static CameraThread getInstance() {
        if (CameraThread.instance == null) {
            CameraThread.instance = new CameraThread();
        }
        return CameraThread.instance;
    }
    
    private void quit() {
        synchronized (this.LOCK) {
            this.thread.quit();
            this.thread = null;
            this.handler = null;
        }
    }
    
    protected void decrementInstances() {
        synchronized (this.LOCK) {
            --this.openCount;
            if (this.openCount == 0) {
                this.quit();
            }
        }
    }
    
    protected void enqueue(final Runnable runnable) {
        synchronized (this.LOCK) {
            this.checkRunning();
            this.handler.post(runnable);
        }
    }
    
    protected void enqueueDelayed(final Runnable runnable, final long n) {
        synchronized (this.LOCK) {
            this.checkRunning();
            this.handler.postDelayed(runnable, n);
        }
    }
    
    protected void incrementAndEnqueue(final Runnable runnable) {
        synchronized (this.LOCK) {
            ++this.openCount;
            this.enqueue(runnable);
        }
    }
}
